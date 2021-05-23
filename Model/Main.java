package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Main extends Application {
    int Height=680;
    int Width=430;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/login.fxml"));
        primaryStage.setTitle("SBU GRAM");
        primaryStage.setScene(new Scene(root, Width,Height));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
