package UI.Profile;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    public String Name,User,Pass,Email,FamilyName;
    public TextField name,user,familyname,email;
    public PasswordField pass;
    public MouseEvent mouseEvent;
    public ImageView proPic;
    public void setName(){
          Name = name.getText();
        if(Name==null || Name.matches("[ ]*") ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Don't Leave The Fields Empty");
            alert.showAndWait();
            Name = name.getText();

        }
    }
    public void setUser(){
         User = user.getText();
        if(User==null || User.matches("[ ]*") ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Don't Leave The Fields Empty");
            alert.showAndWait();
            User = user.getText();

        }
    }
    public void setPass(){
         Pass = pass.getText();
        if(Pass==null || Pass.matches("[ ]*") ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Don't Leave The Fields Empty");
            alert.showAndWait();
            Pass = pass.getText();

        }

    }
    public void setPic(MouseEvent mouseEvent){
        try{
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        Image image = new Image(file.toURI().toString());
        proPic.setImage(image);}
        catch (Exception e){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Choose Picture");
                alert.showAndWait();

        }
    }
    public void setFamilyName(){
         FamilyName = familyname.getText();
        if(FamilyName==null || FamilyName.matches("[ ]*") ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Don't Leave The Fields Empty");
            alert.showAndWait();
            FamilyName = familyname.getText();

        }
    }
    public void setEmail(){
         Email = email.getText();
        if(Email.matches("[a-zA-Z0-9]*@gmail.com"))
        {
            Email=setEmailB.getText();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid Email");
            alert.showAndWait();

        }


          }
    public void editPic(){
        setPic(mouseEvent);
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
    public void editFamilyName(){ setFamilyName();}
    public void editEmail(){ setEmail();}


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
