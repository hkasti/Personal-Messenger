package rmi;

import database.PersonDB;
import logic.Person;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class Controller extends UnicastRemoteObject implements ControllerInterface{
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
    public String test21(String a) throws RemoteException {
        return a + " ahmad:) ";
    }

    @Override
    public void signup(String firstName, String lastName, String email, String username, String password, String profileImage) throws RemoteException {
//        TODO profile image
        Person p = new Person(firstName, lastName, email, username, password, profileImage, new Date());
        try {
            PersonDB.addPerson(p);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        }

    }

    @Override
    public String getPerson(String username) throws RemoteException {
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
}
