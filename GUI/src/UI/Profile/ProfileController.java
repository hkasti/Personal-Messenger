package UI.Profile;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileController {
    public Button GoToH,editNameB,editUserB,editPassB,changePicB,proPicB;
    public TextField name,user;
    public PasswordField pass;
    public void setName(){
        String  Name = name.getText();
    }
    public void setUser(){
        String User = user.getText();
    }
    public void setPass(){
        String Pass = pass.getText();
    }
    public void editName(){
        setName();
    }
    public void editUser(){
        setUser();
    }
    public void editPass(){
        setPass();
    }
    public void setPic(){

    }
    public void editPic(){
        setPic();
    }


    public void GoToHome() throws IOException {
        Stage stage = (Stage) GoToH.getScene().getWindow();
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
