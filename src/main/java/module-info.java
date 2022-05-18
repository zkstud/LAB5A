module pl.lublin.wsei.java.lab5a {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.lublin.wsei.java to javafx.fxml;
    exports pl.lublin.wsei.java;
}