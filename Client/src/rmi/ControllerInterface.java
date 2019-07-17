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

    void sendMessage(String form, String to, String content) throws RemoteException;

    void sendFile(String from, String to, byte[] file, String fileExt) throws RemoteException;


    ArrayList<Map<String, Object>> retrieveAllChatHistoryFromUser(String username, String opos) throws RemoteException;

    ArrayList<String> retrieveAllChatsUsername(String username) throws RemoteException;

    void changeName(String username, String firstname, String lastName) throws RemoteException;

    void changePass(String username, String newPass) throws RemoteException;

    void changePic(String username, BufferedImage img) throws RemoteException;

    boolean isUserPassValid(String user, String pass) throws RemoteException;

    void changeEmail(String user, String newMail) throws RemoteException;
}
