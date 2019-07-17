import rmi.ControllerInterface;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    private static final String server_ip = "192.168.43.157";
    private ControllerInterface stub;
    private String username;


    public Controller() throws RemoteException, NotBoundException, MalformedURLException, FileNotFoundException {
        this.stub = (ControllerInterface) Naming.lookup("rmi://" + server_ip + ":5000/messenger");
        File file = new File("m_data");
        this.username = new Scanner(file).nextLine();
    }


    public void signup(Map<String, String> data, BufferedImage img) throws IOException {
        this.stub.signup(
                data.get("user"),
                data.get("pass"),
                data.get("firstname"),
                data.get("lastname"),
                data.get("email"),
                img);
    }

    public Map<String, Object> getUserInfo(String username) throws RemoteException {
//        output: {String username, String firstname, String lastname, Date lastseen, bool isTyping}
        return stub.getUser(username);
    }

    public void removeUser() throws RemoteException {
        stub.removeUser(this.username);
    }

    public void SendMessage(String to_user, String content) throws RemoteException {
        this.stub.SendMessage(this.username, to_user, content);
    }

    public void SendFile(String to, Byte[] file) throws RemoteException {
        stub.SendFile(this.username, to, file);
    }


//    TODO
    public void getFile(){

    }

    public ArrayList<Map<String, Object>> retriveAllChatHistoryFromUser(String username) throws RemoteException {
//       output: arrays of [Date date, String text, Byte[] file]
        return this.stub.retrieveAllChatHistoryFromUser(this.username, username);
    }

    public ArrayList<String> retriveAllChatsUsername() throws RemoteException {
//       output: usernames
        return this.stub.retrieveAllChatsUsername(this.username);
    }


    public void changeName(String firstname, String lastName) throws RemoteException {
    
    this.stub.changeName(this.username, firstname, lastName);
    }

    public void changePass(String newPass) throws RemoteException {
        this.stub.changePass(this.username, newPass);

    }

    public void changePic(BufferedImage img) throws RemoteException{
        this.stub.changePic(this.username, img);

    }
}
