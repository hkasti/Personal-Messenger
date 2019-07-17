package UI.Settings;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import rmi.Controller;

import java.io.IOException;
import java.rmi.NotBoundException;

public class LogOutController {

    public Button logOutYesB, logOutNoB;

    public void LogOYesB() throws IOException, NotBoundException {
        Stage stage = (Stage) logOutYesB.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
                getResource("/UI/SignUp/SignUpfx.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage2 = new Stage();
        Scene scene = new Scene(root);
        stage2.setScene(scene);
        stage2.show();
        new Controller().username = "";

    }

    public void NoB() throws IOException {
        Stage stage = (Stage) logOutNoB.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
                getResource("/UI/Settings/Settingsfx.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage2 = new Stage();
        Scene scene = new Scene(root);
        stage2.setScene(scene);
        stage2.show();


    }
}
