package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rmi.ControllerInterface;

import java.rmi.Naming;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        try {

            ControllerInterface stub = (ControllerInterface) Naming.lookup("rmi://192.168.43.157:5000/messenger");
            System.out.println(stub.test21("zahra"));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

//        launch(args);
}
