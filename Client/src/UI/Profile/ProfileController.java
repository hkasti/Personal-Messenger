package UI.Profile;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class ProfileController {
    public Button GoToH,editNameB,editUserB,editPassB,editEmailB,editFamilyNameB,changePicB,
            setNameB,setUserB,setEmailB,setFamilyNameB;
    public TextField name,user,familyname,email;
    public PasswordField pass;
    public MouseEvent mouseEvent;
    public ImageView proPic;
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
    public void setPic(MouseEvent mouseEvent){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        Image image = new Image(file.toURI().toString());
        proPic.setImage(image);


    }
    public void setFamilyName(){


    }
    public void setEmail(){

    }
    public void editPic(){
        setPic(mouseEvent);
    }
    public void editFamilyName(){}
    public void editEmail(){}


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
