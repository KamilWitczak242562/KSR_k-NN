package logic;

import java.util.List;

public class Article {
    private String body;
    private String place;
    private String title;
    private List<Object> vector;

    public Article(String body, String place, String title) {
        this.body = body;
        this.place = place;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" +
                "body='" + body + '\'' +
                ", place='" + place + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
