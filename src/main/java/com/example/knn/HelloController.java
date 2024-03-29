package com.example.knn;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

    private ObservableList<String> availableMetrics = FXCollections.observableArrayList("Euklidesowa", "Miejska", "Czebyszewa");
    private ObservableList<String> rows1 = FXCollections.observableArrayList("USA", "UK", "CANADA", "GERMANY", "FRANCE", "JAPAN");
    private ObservableList<String> rows2 = FXCollections.observableArrayList("Precision", "Recall", "F1");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chooseMetric.setItems(availableMetrics);
        for (int i = 1; i<grid1.getColumnCount(); i++) {
            Text text = new Text(rows1.get(i - 1));
            Text text2 = new Text(rows1.get(i - 1));
            GridPane.setHalignment(text, HPos.CENTER);
            GridPane.setHalignment(text2, HPos.CENTER);
            grid1.add(text, i, 0);
            grid1.add(text2, 0, i);
        }

        for (int i = 1; i<grid2.getColumnCount(); i++) {
            Text text = new Text(rows1.get(i - 1));
            GridPane.setHalignment(text, HPos.CENTER);
            grid2.add(text, i, 0);
        }

        for (int i = 1; i<grid2.getRowCount(); i++) {
            Text text = new Text(rows2.get(i - 1));
            GridPane.setHalignment(text, HPos.CENTER);
            grid2.add(text, 0, i);
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Przycisk został naciśnięty");
    }

    public String getChooseMetric() {
        return chooseMetric.getValue();
    }

    public String  getArticlesNumber() {
        return articlesNumber.getText();
    }

    public Integer getNeighbors() {
        return Integer.parseInt(neighbors.getText());
    }

    public Integer getPercentage() {
        return Integer.parseInt(percentage.getText());
    }
}