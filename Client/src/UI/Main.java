package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rmi.ControllerInterface;

import java.rmi.Naming;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
      //  ControllerInterface stub = (ControllerInterface) Naming.lookup("rmi://localhost:5000/messenger");
        Parent root = FXMLLoader.load(getClass().getResource("/UI/SignUp/SignUpfx.fxml"));
        primaryStage.setTitle("Sign up");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
