package org.example;

public class Article {
    private String body;
    private String place;
    private String title;

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
