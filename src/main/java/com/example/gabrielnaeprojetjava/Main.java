
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
    }
}
