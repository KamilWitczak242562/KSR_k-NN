package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticlesLoader {
    private static final List<String> classes = List.of("west-germany", "usa", "france", "uk", "canada", "japan");

    private static Pattern EXTRACTION_PATTERN = Pattern
            .compile("<PLACES>(.*?)</PLACES>.*?<TITLE>(.*?)</TITLE>.*?<BODY>(.*?)</BODY>", Pattern.DOTALL);

    private static ArrayList<Article> parseFile(String fileData, int amount) {
        ArrayList<Article> allArticles = new ArrayList<>();
        Matcher matcher = EXTRACTION_PATTERN.matcher("articles/" + fileData);
        int number = 0;
        while (matcher.find() && number < amount) {
            List<String> places = getSeparatedPlaces(matcher.group(1).replaceAll("&lt;", "<"));
            String title = matcher.group(2).replaceAll("&lt;", "<");
            String body = matcher.group(3).replaceAll("&lt;", "<");
            if(places.size() == 1 && classes.contains(places.get(0)))
            {
                String place = places.get(0);
                body = body.replaceAll("Reuter", "");
                body = body.replaceAll("&#3;", "");
                body = body.trim();
                allArticles.add(new Article(body, place, title));
                number += 1;
            }
        }
        return allArticles;
    }

    public static List<Article> loadData(String filePath, int amount) throws IOException {
        List<Article> articles = new ArrayList<>();
        File file = new File("articles/" + filePath);
        articles.addAll(ArticlesLoader.parseFile(Files.readString(file.toPath()), amount));
        return articles;
    }

    private static List<String> getSeparatedPlaces(String match) {
        Matcher m = Pattern.compile("<D>(.+?)</D>").matcher(match);
        List<String> separatedPlaces = new ArrayList<>();
        while (m.find()) {
            separatedPlaces.add(m.group(1).replace("&lt;", "<"));
        }
        return separatedPlaces;
    }
}
