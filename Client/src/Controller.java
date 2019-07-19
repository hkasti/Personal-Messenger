import rmi.ControllerInterface;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

public class Controller {
    private static final String server_ip = "127.01.01.01";
    private ControllerInterface stub;
    public String username;


    public Controller() throws RemoteException, NotBoundException, MalformedURLException {
        this.stub = (ControllerInterface) Naming.lookup("rmi://" + server_ip + ":5000/messenger");
    }


    public void signup(Map<String, String> data, BufferedImage img) throws IOException {
        this.stub.signup(
                data.get("firstname"),
                data.get("lastname"),
                data.get("email"),
                data.get("user"),
                data.get("pass"),
                img);
        this.username = data.get("user");
    }

    public Map<String, Object> getUserInfo(String username) throws RemoteException {
//        output: {String username, String firstname, String lastname, Date lastseen, bool isTyping}
        return stub.getUser(username);
    }

    public void removeUser() throws RemoteException {
        stub.removeUser(this.username);
    }

    public void sendMessage(String to_user, String content) throws RemoteException {
        this.stub.sendMessage(this.username, to_user, content);
    }

    public void sendFile(String to, File file) throws IOException {
        String fileExt = getFileExtension(file);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        stub.sendFile(this.username, to, fileContent, fileExt);
    }


    //    TODO
    public void getFile() {

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

    public void changePic(BufferedImage img) throws RemoteException {
        this.stub.changePic(this.username, img);

    }

    public boolean signin(String user, String pass) throws RemoteException {
        boolean is_valid = this.stub.isUserPassValid(user, pass);
        if (is_valid)
            this.username = user;
        return is_valid;
    }

    private static String getFileExtension(File file) {
        String extension = "";

        try {
            if (file != null && file.exists()) {
                String name = file.getName();
                extension = name.substring(name.lastIndexOf("."));
            }
        } catch (Exception e) {
            extension = "";
        }

        return extension;

    }
}
