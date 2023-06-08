package com.example.gabrielnaeprojetjava;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private Label labelErreur;

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
        String nom = textRecette.getText();
        String prixText = textPrix.getText();
        String nbIngredientsText = textNbIngredients.getText();

        if(nom.isEmpty()) {
            labelErreur.setText("Veulliez mettre un nom");
            labelErreur.setVisible(true);
        }
        else if (prixText.isEmpty() || !isFloat(prixText)) {
            labelErreur.setText("Veuillez entrer un prix valide");
            labelErreur.setVisible(true);
        }
        else if (nbIngredientsText.isEmpty() || !isInteger(nbIngredientsText)) {
            labelErreur.setText("Veuillez entrer un nombre d'ingrédients valide");
            labelErreur.setVisible(true);
        }
        else {
            labelErreur.setVisible(false);
            labelErreur.setText("");
            this.ajouterPizzaDansTab(this.textRecette.getText(), Float.parseFloat(this.textPrix.getText()), Integer.parseInt(this.textNbIngredients.getText()));
        }
    }

    private boolean isFloat(String value) {
        try {
            Float.parseFloat(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
