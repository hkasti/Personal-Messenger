package UI.SignUp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SignUpController {
    public Button signUpB,loginB;
    public TextField userSignU;
    public PasswordField passSignU;
    public String username,pass;

    Scanner scanner=new Scanner(System.in);

    public void SignUBAction() throws IOException {
        if(username==null || pass==null || username.matches("[ ]*") || pass.matches("[ ]*")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Don't Leave The Fields Empty");
            alert.showAndWait();
        }else{
        Stage stage = (Stage) signUpB.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
                getResource("/UI/Profile/Profilefx.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage2 = new Stage();
        Scene scene = new Scene(root);
        stage2.setScene(scene);
        stage2.show();}
}
    public void LogIBAction() throws IOException {
        if(username==null || pass==null || username.matches("[ ]*") || pass.matches("[ ]*")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Don't Leave The Fields Empty");
            alert.showAndWait();
        }else {
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

    public void setUser() throws IOException {
        //userSignU.accessibleTextProperty().setValue(scanner.nextLine());
        username = userSignU.getText();
    }

    public void setPass(){
        //passSignU.accessibleTextProperty().setValue(scanner.nextLine());
        pass = passSignU.getText();

    }

}
