package UI.Profile;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import rmi.Controller;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    private Controller controller;
    public Button GoToH, setPicB,
            setNameB, setUserB, setEmailB, setFamilyNameB;
    @FXML
    private TextField name, familyname, email;
    @FXML
    private PasswordField pass;
    public MouseEvent mouseEvent;
    public ImageView proPic;

    private String firstnameString, lastnameString, emailString, passString;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Map<String, Object> data = controller.getUserInfo();
            name.setText((String.valueOf(data.get("firstname"))));
            familyname.setText((String.valueOf(data.get("lastname"))));
            email.setText((String.valueOf(data.get("email"))));
            pass.setText("*********");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public ProfileController() throws RemoteException, NotBoundException, MalformedURLException {
        this.controller = new Controller();
    }

    public void setName() throws RemoteException {
        controller.changeName(name.getText(), familyname.getText());
    }

    public void setPass() throws RemoteException {
        String newPass = pass.getText();
        controller.changePass(newPass);
    }


    public void setPicB() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        Image image = new Image(file.toURI().toString());
        proPic.setImage(image);


    }

    public void setFamilyName() throws RemoteException {
        controller.changeName(name.getText(), familyname.getText());

    }

    public void setEmail() throws RemoteException {
        controller.changeEmail(email.getText());


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
