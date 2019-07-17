import org.junit.jupiter.api.Test;
import rmi.ControllerInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
    @Test
    public void test1_signup_remove() throws RemoteException, MalformedURLException, NotBoundException {
            String username = "testuser";
            ControllerInterface stub = (ControllerInterface) Naming.lookup("rmi://localhost:5000/messenger");
            stub.signup("test1", "mahmood", "test@test.com", username, "123", " ");
            String actualUsername = stub.getPerson(username);
            assertEquals(username, actualUsername);
            stub.removeUser(username);
            actualUsername = stub.getPerson(username);
            assertEquals(null, actualUsername);

    }

    @Test
    public void test2_(){

    }

}
