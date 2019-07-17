import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rmi.ControllerInterface;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
    Controller controller;

    public void init() throws RemoteException, NotBoundException, MalformedURLException {
        this.controller = new Controller();
    }

    @Test
    public void test1_signup_remove() throws IOException, NotBoundException {
        init();
        String username = "zahra99";
        Map<String, String> data = new HashMap<>();
        data.put("user", username);
        data.put("pass", "123");
        data.put("firstname", "zahra");
        data.put("lastname", "mahmoudzadeh");
        data.put("email", "test@tst.tst");
        controller.signup(data, null);
        String actualUsername = (String) controller.getUserInfo(username).get("username");
        assertEquals(username, actualUsername);
        controller.removeUser();
        Object o = controller.getUserInfo(username);
        assertEquals(null, o);

    }

    @Test
    public void test2_send_and_retrieve_message() throws RemoteException, NotBoundException, MalformedURLException {
        init();
        String currentUser = "zahra99";
        this.controller.username = currentUser;
        String user = "ahmad12";
        String message = "salam 123 zange madreseh";
        this.controller.sendMessage(user, message);
        String actualText = (String) this.controller.retriveAllChatHistoryFromUser(user).get(0).get("text");
        assertEquals(message, actualText);
    }

    @Test
    public void test3_file_upload_download() throws IOException, NotBoundException {
        init();
        String currentUser = "zahra99";
        this.controller.username = currentUser;
        String user = "ahmad12";
        File file = new File("test2.mp4");
        controller.sendFile(user, file);

    }

    @Test
    public void test4_retrieveAllChatsUsername() throws RemoteException, NotBoundException, MalformedURLException {
        init();
        String currentUser = "zahra99";
        this.controller.username = currentUser;
        ArrayList<String> users = this.controller.retriveAllChatsUsername();
        assertEquals(true, users.contains("ahmad12"));
    }

}
