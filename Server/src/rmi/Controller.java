package rmi;

import database.PersonDB;
import logic.Person;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class Controller extends UnicastRemoteObject implements ControllerInterface{
    public Controller() throws RemoteException {
        super();
    }

    @Override
    public String test21(String a) throws RemoteException {
        return a + " ahmad:) ";
    }

    @Override
    public void signup(String firstName, String lastName, String email, String username, String password, String profileImage) throws Exception {
//        TODO profile image
        Person p = new Person(firstName, lastName, email, username, password, profileImage, new Date());
//        PersonDB.addPerson(p);

    }
}
