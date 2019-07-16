package UI.SignUp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class SignUpController {
    public Button signUpB,loginB;
    public TextField userSignU;
    public PasswordField passSignU;

    Scanner scanner=new Scanner(System.in);

    public void SignUBAction() throws IOException {
        Stage stage = (Stage) signUpB.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
                getResource("/UI/Home/Homefx.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage2 = new Stage();
        Scene scene = new Scene(root);
        stage2.setScene(scene);
        stage2.show();
}
    public void LogIBAction() throws IOException {
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

    public void setUser(){
        //userSignU.accessibleTextProperty().setValue(scanner.nextLine());
        String username = userSignU.getText();
    }
    public void setPass(){
        //passSignU.accessibleTextProperty().setValue(scanner.nextLine());
        String username = passSignU.getText();

    }

}
