package UI.SignUp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rmi.Controller;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.HashMap;
import java.util.Map;

public class SignUpController {
    public Button signUpB, loginB;
    public TextField userSignU;
    public PasswordField passSignU;

    public void SignUBAction() throws IOException, NotBoundException {
        Stage stage = (Stage) signUpB.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
                getResource("/UI/Home/Homefx.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage2 = new Stage();
        Scene scene = new Scene(root);
        stage2.setScene(scene);
        stage2.show();
        String username = userSignU.getText();
        String password = passSignU.getText();
        Controller controller = new Controller();
        Map<String, String> data = new HashMap<>();
        data.put("firstname", "");
        data.put("lastname", "");
        data.put("email", "");
        data.put("user", username);
        data.put("pass", password);
        controller.signup(data, null);

    }

    public void LogIBAction() throws IOException, NotBoundException {
        String username = userSignU.getText();
        String password = passSignU.getText();
        Controller controller = new Controller();
        if (!controller.signin(username, password))
            return;
        Stage stage = (Stage) loginB.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
                getResource("/UI/Home/Homefx.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage2 = new Stage();
        Scene scene = new Scene(root);
        stage2.setScene(scene);
        stage2.show();

    }

}
