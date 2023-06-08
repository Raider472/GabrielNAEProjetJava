package com.example.gabrielnaeprojetjava;

import com.example.gabrielnaeprojetjava.Pizza;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Pizza testPizza = new Pizza("Peperonni", 20.50F, 5);
        System.out.println(
                testPizza.getNom()
        );
        System.out.println(
                testPizza.getNbIngredients()
        );
        System.out.println(
                testPizza.getPrix()
        );
        testPizza.setNom("Yepa");
        testPizza.setPrix(50.05F);
        testPizza.setNbIngredients(568798);
        System.out.println(
                testPizza.getNom()
        );
        System.out.println(
                testPizza.getNbIngredients()
        );
        System.out.println(
                testPizza.getPrix()
        );
        afficherPizas();
        //new PizzaDAO().ajouterPizza(new Pizza("Test", 2.5F, 5));
        //new PizzaDAO().supprimerPizza();
    }

    private static void afficherPizas() {
        List<Pizza> pizzas = new PizzaDAO().getPizza();
        pizzas.stream().forEach(pizza -> System.out.println(pizza.getNom() + " " + pizza.getPrix() + " Euros " + pizza.getNbIngredients() + " Ingredients"));
    }
}
