package com.example.gabrielnaeprojetjava;

public class Pizza {
    String nom;

    Integer id;

    Float prix;

    Integer nbIngredients;

    Pizza(String nom, Float prix, Integer nbIngredients) {
        this.nom = nom;
        this.prix = prix;
        this.nbIngredients = nbIngredients;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Integer getNbIngredients() {
        return nbIngredients;
    }

    public void setNbIngredients(Integer nbIngredients) {
        this.nbIngredients = nbIngredients;
    }
}
