package com.example.gabrielnaeprojetjava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControllerPizza {
    @FXML
    private TableView tabelPizza;

    @FXML
    private TableColumn columnRecette;

    @FXML
    private TableColumn columnPrix;

    @FXML
    private TableColumn columnNbIngredients;

    @FXML
    private TextField textRecette;

    @FXML
    private TextField textPrix;

    @FXML
    private TextField textNbIngredients;

    @FXML
    private Button buttonAjouter;

    @FXML
    private Button buttonSuprimer;
}
