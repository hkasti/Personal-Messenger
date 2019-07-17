package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControllerInterface extends Remote {


    public String test21(String a) throws RemoteException;

    public void signup(String firstName, String lastName, String email, String username, String password, String profileImage) throws Exception;


}
