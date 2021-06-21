package Common.Model;

import Client.Client;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception{

        PageLoader.initStage(stage); //this is only needed when you start program
        //and need a new stage. all scenes will be loaded on this stage
        Client.connectToServer();
        new PageLoader().load("login");
    }

    @Override
    //this function happens when the program is opened
    public void init() {
        System.out.println("program opened");
    }

    @Override
    //this function happens when the program is closed
    public void stop() {
        System.out.println("program closed");
    }
    public static void main(String[] args) {
        launch(args);
    }
}