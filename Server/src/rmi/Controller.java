package rmi;

import com.sun.tools.javac.util.ArrayUtils;
import database.MessageDB;
import database.PersonDB;
import logic.Message;
import logic.Person;

import java.awt.image.BufferedImage;
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Controller extends UnicastRemoteObject implements ControllerInterface {
    PersonDB personDB;
    MessageDB messageDB;

    public Controller() throws RemoteException {
        super();
        try {
            this.personDB = new PersonDB();
            this.messageDB = new MessageDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void signup(String firstName, String lastName, String email, String username, String password, BufferedImage img) throws RemoteException {
        Person p = new Person(firstName, lastName, email, username, password, "", new Date());
        try {
            PersonDB.addPerson(p);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public Map<String, Object> getUser(String username) throws RemoteException {
        try {
            return personDB.getPerson(username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public void removeUser(String username) throws RemoteException {
        try {
//            TODO unsafe remove
            personDB.deletePerson(username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public void sendMessage(String from, String to, String content) throws RemoteException {
        Message message = new Message(false, content, from, to, new Date());
        try {
            messageDB.addMessage(message);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public void sendFile(String from, String to, byte[] file, String fileExt) throws RemoteException {
        String fileName = getMD5(file);
        String filepath = "uploads/" + fileName + "." + fileExt;
        FileOutputStream out = null;
        try {
            File f = new File(filepath);
            out = new FileOutputStream(f);
            out.write(file);
            out.close();
            Message message = new Message(true, filepath, from, to, new Date());
            messageDB.addMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Map<String, Object>> retrieveAllChatHistoryFromUser(String username, String opos) throws RemoteException {
        try {
            return messageDB.getAllMessages(username, opos);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public ArrayList<String> retrieveAllChatsUsername(String username) throws RemoteException {
        try {
            return this.messageDB.getAllChatUsernames(username);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public void changeName(String username, String firstname, String lastName) throws RemoteException {
        try {
            personDB.changeName(username, firstname, lastName);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public void changePass(String username, String newPass) throws RemoteException {
        try {
            personDB.changePass(username, newPass);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public void changePic(String username, BufferedImage img) throws RemoteException {

    }

    @Override
    public boolean isUserPassValid(String user, String pass) throws RemoteException {
        try {
            return personDB.checkPassword(user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public void changeEmail(String user, String newMail) throws RemoteException {
        personDB.changeEmail(user, newMail);
    }

    public static String getMD5(byte[] source) {
        StringBuilder sb = new StringBuilder();
        java.security.MessageDigest md5 = null;
        try {
            md5 = java.security.MessageDigest.getInstance("MD5");
            md5.update(source);
        } catch (NoSuchAlgorithmException e) {
        }
        if (md5 != null) {
            for (byte b : md5.digest()) {
                sb.append(String.format("%02X", b));
            }
        }
        return sb.toString();
    }
}
