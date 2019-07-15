package UI.Search;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class SearchController {
    public TextField searchUser;
    public Button searchB,GoToH;
    Scanner scanner=new Scanner(System.in);
    public void Search(){

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
    public void setSearchUser(){
        //searchUser.accessibleTextProperty().setValue(scanner.nextLine());
        String username = searchUser.getText();
    }
}
