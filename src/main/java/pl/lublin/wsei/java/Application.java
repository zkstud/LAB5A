package pl.lublin.wsei.java;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Lab5 ZK-37652 'Nobel prize by winner'");
        stage.setScene(scene);
        stage.setResizable(false);
        File fIconsStage = new File("medal_award_icon.png");
        stage.getIcons().add(new Image(fIconsStage.getAbsolutePath()));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}