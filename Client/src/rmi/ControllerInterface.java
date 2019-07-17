package rmi;

import java.awt.image.BufferedImage;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

public interface ControllerInterface extends Remote {


    void signup(String firstName, String lastName, String email, String username, String password, BufferedImage img) throws RemoteException;

    //        output: {String username, String firstname, String lastname, Date lastseen, bool isTyping}
    Map<String, Object> getUser(String username) throws RemoteException;

    void removeUser(String username) throws RemoteException;

    void SendMessage(String form, String to, String content) throws RemoteException;

    void SendFile(String from, String to, Byte[] file) throws RemoteException;


    ArrayList<Map<String, Object>> retrieveAllChatHistoryFromUser(String username, String opos) throws RemoteException;

    ArrayList<String> retrieveAllChatsUsername(String username) throws RemoteException;

    void changeName(String username, String firstname, String lastName);

    void changePass(String username, String newPass);

    void changePic(String username, BufferedImage img);
}
