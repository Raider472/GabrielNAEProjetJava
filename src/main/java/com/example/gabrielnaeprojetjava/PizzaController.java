package com.example.gabrielnaeprojetjava;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PizzaController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnRecette.setCellValueFactory(new PropertyValueFactory<Pizza, String>("nom"));
        columnPrix.setCellValueFactory(new PropertyValueFactory<Pizza, Float>("prix"));
        columnNbIngredients.setCellValueFactory(new PropertyValueFactory<Pizza, Integer>("nbIngredients"));

        List<Pizza> pizzas = new PizzaDAO().getPizza();

        pizzas.stream().forEach(pizza -> {
            Pizza laPizza = new Pizza(pizza.getNom(), pizza.getPrix(), pizza.getNbIngredients());
            ObservableList<Pizza> pizzaTable = tablePizza.getItems();
            pizzaTable.add(laPizza);
            tablePizza.setItems(pizzaTable);
        });
    }

    @FXML
    private TableView tablePizza;

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
    @FXML
    private void ajouterPizzaBouton() {
        this.ajouterPizzaDansTab(this.textRecette.getText(), Float.parseFloat(this.textPrix.getText()), Integer.parseInt(this.textNbIngredients.getText()));
    }
    @FXML
    private void supprimerTouteLesPizzasBouton() {
        tablePizza.getItems().clear();
        new PizzaDAO().supprimerPizza();
    }

    public void ajouterPizzaDansTab(String nom, Float prix, Integer nbIngredients) {
        Pizza unePizza = new Pizza(nom, prix, nbIngredients);

        ObservableList<Pizza> pizzas = tablePizza.getItems();
        pizzas.add(unePizza);
        tablePizza.setItems(pizzas);

        new PizzaDAO().ajouterPizza(unePizza);
    }
}
