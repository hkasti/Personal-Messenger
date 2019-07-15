package UI.Chatroom;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatroomController {
    public Button proPicB;
    public void OpenPro() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
                getResource("C:\\Users\\PC\\Desktop\\GUI\\src\\UI\\Profile\\Profilefx.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
