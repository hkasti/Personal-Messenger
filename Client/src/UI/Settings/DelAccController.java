package UI.Settings;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DelAccController {

    public Button delAYesB,delANoB;
    public void DelAccYesB() throws IOException {
        Stage stage = (Stage) delAYesB.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
                getResource("/UI/SignUp/SignUpfx.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage2 = new Stage();
        Scene scene = new Scene(root);
        stage2.setScene(scene);
        stage2.show();


    }
    public void NoB() throws IOException {
        Stage stage = (Stage) delANoB.getScene().getWindow();
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
