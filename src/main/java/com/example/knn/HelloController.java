package com.example.knn;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.example.logic.*;

public class HelloController implements Initializable {
    @FXML
    private ChoiceBox<String> chooseMetric;
    @FXML
    private GridPane grid2;
    @FXML
    private GridPane grid1;
    @FXML
    private TextField articlesNumber;
    @FXML
    private TextField neighbors;
    @FXML
    private TextField percentage;
    @FXML
    private CheckBox c1;
    @FXML
    private CheckBox c2;
    @FXML
    private CheckBox c3;
    @FXML
    private CheckBox c4;
    @FXML
    private CheckBox c5;
    @FXML
    private CheckBox c6;
    @FXML
    private CheckBox c7;
    @FXML
    private CheckBox c8;
    @FXML
    private CheckBox c9;
    @FXML
    private CheckBox c10;
    @FXML
    private CheckBox c11;
    @FXML
    private Button button;
    @FXML
    private Label accId;

    private kNN kNN;
    private List<Article> articles;
    private List<Article> testArticles;

    private ObservableList<String> availableMetrics = FXCollections.observableArrayList("Euklidesowa", "Miejska", "Czebyszewa");
    private ObservableList<String> rows1 = FXCollections.observableArrayList("USA", "UK", "CANADA", "GERMANY", "FRANCE", "JAPAN", "Średnia");
    private ObservableList<String> rows2 = FXCollections.observableArrayList("Precision", "Recall", "F1");
    private List<String> countries = new ArrayList<>() {{
        add("usa");
        add("uk");
        add("canada");
        add("west-germany");
        add("france");
        add("japan");
    }};
    private List<Double> allPrecisions;
    private List<Double> allRecalls;
    private List<Double> allF1;
    private List<Integer> found;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chooseMetric.setItems(availableMetrics);
        for (int i = 1; i < grid1.getColumnCount(); i++) {
            Text text = new Text(rows1.get(i - 1));
            Text text2 = new Text(rows1.get(i - 1));
            GridPane.setHalignment(text, HPos.CENTER);
            GridPane.setHalignment(text2, HPos.CENTER);
            grid1.add(text, i, 0);
            grid1.add(text2, 0, i);
        }

        for (int i = 1; i < grid2.getColumnCount(); i++) {
            Text text = new Text(rows1.get(i - 1));
            GridPane.setHalignment(text, HPos.CENTER);
            grid2.add(text, i, 0);
        }

        for (int i = 1; i < grid2.getRowCount(); i++) {
            Text text = new Text(rows2.get(i - 1));
            GridPane.setHalignment(text, HPos.CENTER);
            grid2.add(text, 0, i);
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        replaceValuesInGridPane(grid1, "", 6, 6);
        replaceValuesInGridPane(grid2, "", 7, 3);
        try {
            articles = ArticlesLoader.loadData(getArticlesNumber(), null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Article article : articles) {
            if (c1.isSelected()) {
                article.addFirstChar();
            }
            if (c2.isSelected()) {
                article.addSecondChar();
            }
            if (c3.isSelected()) {
                article.addThirdChar();
            }
            if (c4.isSelected()) {
                article.addFourthChar();
            }
            if (c5.isSelected()) {
                article.addFifthChar();
            }
            if (c6.isSelected()) {
                article.addSixthChar();
            }
            if (c7.isSelected()) {
                article.addSeventhChar();
            }
            if (c8.isSelected()) {
                article.addEighthChar();
            }
            if (c9.isSelected()) {
                article.addNinthChar();
            }
            if (c10.isSelected()) {
                article.addTenthChar();
            }
            if (c11.isSelected()) {
                article.addEleventhChar();
            }
        }
        kNN = new kNN(articles, getNeighbors(), getChooseMetric(), getPercentage());
        kNN.predict();
        testArticles = kNN.getTestArticles();
        accId.setText(String.valueOf(Utils.accuracy(testArticles)));
        allPrecisions = new ArrayList<>();
        allRecalls = new ArrayList<>();
        allF1 = new ArrayList<>();
        for (String country : countries) {
            allPrecisions.add(Utils.precision(testArticles, country));
            allRecalls.add(Utils.recall(testArticles, country));
            allF1.add(Utils.f_1(Utils.precision(testArticles, country), Utils.recall(testArticles, country)));
        }
        allPrecisions.add(Utils.averagePrecision(testArticles));
        allRecalls.add(Utils.averageRecall(testArticles));
        allF1.add(Utils.averageF1(testArticles));
        for (int i = 1; i < grid2.getColumnCount(); i++) {
            Text text = new Text(String.valueOf(allPrecisions.get(i - 1)));
            GridPane.setHalignment(text, HPos.CENTER);
            grid2.add(text, i, 1);
        }
        for (int i = 1; i < grid2.getColumnCount(); i++) {
            Text text = new Text(String.valueOf(allRecalls.get(i - 1)));
            GridPane.setHalignment(text, HPos.CENTER);
            grid2.add(text, i, 2);
        }
        for (int i = 1; i < grid2.getColumnCount(); i++) {
            Text text = new Text(String.valueOf(allF1.get(i - 1)));
            GridPane.setHalignment(text, HPos.CENTER);
            grid2.add(text, i, 3);
        }
        found = Utils.getFoundInCountry(testArticles, "usa");
        for (int i = 1; i < grid1.getColumnCount(); i++) {
            Text text = new Text(String.valueOf(found.get(i - 1)));
            GridPane.setHalignment(text, HPos.CENTER);
            grid1.add(text, 1, i);
        }
        found = Utils.getFoundInCountry(testArticles, "uk");
        for (int i = 1; i < grid1.getColumnCount(); i++) {
            Text text = new Text(String.valueOf(found.get(i - 1)));
            GridPane.setHalignment(text, HPos.CENTER);
            grid1.add(text, 2, i);
        }
        found = Utils.getFoundInCountry(testArticles, "canada");
        for (int i = 1; i < grid1.getColumnCount(); i++) {
            Text text = new Text(String.valueOf(found.get(i - 1)));
            GridPane.setHalignment(text, HPos.CENTER);
            grid1.add(text, 3, i);
        }
        found = Utils.getFoundInCountry(testArticles, "west-germany");
        for (int i = 1; i < grid1.getColumnCount(); i++) {
            Text text = new Text(String.valueOf(found.get(i - 1)));
            GridPane.setHalignment(text, HPos.CENTER);
            grid1.add(text, 4, i);
        }
        found = Utils.getFoundInCountry(testArticles, "france");
        for (int i = 1; i < grid1.getColumnCount(); i++) {
            Text text = new Text(String.valueOf(found.get(i - 1)));
            GridPane.setHalignment(text, HPos.CENTER);
            grid1.add(text, 5, i);
        }
        found = Utils.getFoundInCountry(testArticles, "japan");
        for (int i = 1; i < grid1.getColumnCount(); i++) {
            Text text = new Text(String.valueOf(found.get(i - 1)));
            GridPane.setHalignment(text, HPos.CENTER);
            grid1.add(text, 6, i);
        }

    }

    public void replaceValuesInGridPane(GridPane gridPane, String newValue, int colMax, int rowMax) {
        for (int row = 1; row <= rowMax; row++) {
            for (int col = 1; col <= colMax; col++) {
                Node existingNode = null;
                for (Node node : gridPane.getChildren()) {
                    Integer columnIndex = GridPane.getColumnIndex(node);
                    Integer rowIndex = GridPane.getRowIndex(node);
                    if (columnIndex != null && rowIndex != null && columnIndex == col && rowIndex == row) {
                        existingNode = node;
                        break;
                    }
                }
                if (existingNode != null) {
                    gridPane.getChildren().remove(existingNode);
                }
            }
        }
    }

    public String getChooseMetric() {
        return chooseMetric.getValue();
    }

    public Integer getArticlesNumber() {
        return Integer.parseInt(articlesNumber.getText());
    }

    public Integer getNeighbors() {
        return Integer.parseInt(neighbors.getText());
    }

    public Integer getPercentage() {
        return Integer.parseInt(percentage.getText());
    }
}