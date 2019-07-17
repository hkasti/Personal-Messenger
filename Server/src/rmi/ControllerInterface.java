package rmi;

import java.awt.image.BufferedImage;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

public interface ControllerInterface extends Remote {


    public void signup(String firstName, String lastName, String email, String username, String password, BufferedImage img) throws RemoteException;

    //        output: {String username, String firstname, String lastname, Date lastseen, bool isTyping}
    public Map<String, Object> getUser(String username) throws RemoteException;

    public void removeUser(String username) throws RemoteException;

    public void sendMessage(String form, String to, String content) throws RemoteException;

    public void sendFile(String from, String to, Byte[] file) throws RemoteException;


    public ArrayList<Map<String, Object>> retrieveAllChatHistoryFromUser(String username, String opos) throws RemoteException;

    public ArrayList<String> retrieveAllChatsUsername(String username) throws RemoteException;

    public void changeName(String username, String firstname, String lastName) throws RemoteException;

    public void changePass(String username, String newPass) throws RemoteException;

    public void changePic(String username, BufferedImage img) throws RemoteException;

    public boolean isUserPassValid(String user, String pass) throws RemoteException;
}
