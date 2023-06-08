package com.example.gabrielnaeprojetjava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PizzaDAO {
    public List<Pizza> getPizza() {
        List<Pizza> pizzas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pizza", "root", "root");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Pizza");
            while (rs.next()) {
                pizzas.add(new Pizza(rs.getString(2),rs.getFloat(3), rs.getInt(4)));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return pizzas;
    }

    public void ajouterPizza(Pizza pizza) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pizza", "root", "root");

            PreparedStatement statement = con.prepareStatement("INSERT INTO Pizza (nom_Pizza, prix_Pizza, nbIngredients_Pizza) VALUES(?,?,?)");
            statement.setString(1, pizza.getNom());
            statement.setFloat(2,pizza.getPrix());
            statement.setInt(3,pizza.getNbIngredients());

            statement.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void supprimerPizza() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pizza", "root", "root");

            PreparedStatement statement = con.prepareStatement("DELETE FROM Pizza");

            statement.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
