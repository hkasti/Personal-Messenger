package UI.Chatroom;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ChatroomController {
    public Button proPicB,GoToH;
    public TextArea textField;
    public VBox Vbox;
    public ImageView image;
    public void OpenPro() throws IOException {
        Stage stage = (Stage) proPicB.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
                getResource("/UI/Profile/Profilefx.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage2 = new Stage();
        Scene scene = new Scene(root);
        stage2.setScene(scene);
        stage2.show();
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

    public void textArea(){

    }
    public void SendMessage(){
        Vbox.getChildren().add( new TextArea(textField.getText() ));
    }
    public void SendFile(){
        FileChooser fileChooser=new FileChooser();
        File selectedfile = fileChooser.showOpenDialog(null);
        if(selectedfile != null)
        {
            image.getImage();

        }else{

        }

    }
    public void OpenEmoji(){

    }
}
