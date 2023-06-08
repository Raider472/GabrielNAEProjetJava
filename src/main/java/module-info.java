module com.example.gabrielnaeprojetjava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gabrielnaeprojetjava to javafx.fxml;
    exports com.example.gabrielnaeprojetjava;
}