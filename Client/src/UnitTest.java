import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rmi.ControllerInterface;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
    public void test2_() {

    }

}
