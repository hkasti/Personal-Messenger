package rmi;

import database.PersonDB;
import logic.Person;

import java.awt.image.BufferedImage;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Controller extends UnicastRemoteObject implements ControllerInterface {
    PersonDB personDB;

    public Controller() throws RemoteException {
        super();
        try {
            this.personDB = new PersonDB();
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
    public void SendMessage(String form, String to, String content) throws RemoteException {

    }

    @Override
    public void SendFile(String from, String to, Byte[] file) throws RemoteException {

    }

    @Override
    public ArrayList<Map<String, Object>> retrieveAllChatHistoryFromUser(String username, String opos) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<String> retrieveAllChatsUsername(String username) throws RemoteException {
        return null;
    }

    @Override
    public void changeName(String username, String firstname, String lastName) throws RemoteException {

    }

    @Override
    public void changePass(String username, String newPass) throws RemoteException {

    }

    @Override
    public void changePic(String username, BufferedImage img) throws RemoteException {

    }

    @Override
    public boolean isUserPassValid(String user, String pass) throws RemoteException {
        return false;
    }
}
