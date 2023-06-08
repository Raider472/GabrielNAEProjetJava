package com.example.gabrielnaeprojetjava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {
    Pizza pizza = new Pizza("Margherita", 8.99f, 5);
    @Test
    void getNom() {
        assertEquals("Margherita", pizza.getNom());
    }

    @Test
    void setNom() {
        pizza.setNom("testTest");
        assertEquals("testTest", pizza.getNom());
    }

    @Test
    void getPrix() {
        assertEquals(8.99F, pizza.getPrix());
    }

    @Test
    void setPrix() {
        pizza.setPrix(58.29F);
        assertEquals(58.29F, pizza.getPrix());
    }

    @Test
    void getNbIngredients() {
        assertEquals(5, pizza.getNbIngredients());
    }

    @Test
    void setNbIngredients() {
        pizza.setNbIngredients(99);
        assertEquals(99, pizza.getNbIngredients());
    }

    @Test
    void constructeur() {
        Pizza pizza2 = new Pizza("hifd", 78.55f, 55);
        assertEquals("hifd", pizza2.getNom());
        assertEquals(78.55f, pizza2.getPrix());
        assertEquals(55, pizza2.getNbIngredients());
    }
}