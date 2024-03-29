package com.example.knn;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ChoiceBox<String> chooseMetric;

    private ObservableList<String> availableMetrics = FXCollections.observableArrayList("Euklidesowa", "Miejska", "Czebyszewa");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chooseMetric.setItems(availableMetrics);
    }
}