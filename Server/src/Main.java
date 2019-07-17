import database.PersonDB;
import logic.Person;
import rmi.Controller;
import rmi.ControllerInterface;

import java.rmi.Naming;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        try {
//            ControllerInterface stub = new Controller();
//            Naming.rebind("rmi://192.168.43.157:5000/messenger", stub);
            Person p = new Person("AAAA", "AAA", "AAA", "AAA", "AAA", "AAA", new Date());
            PersonDB personDB = new PersonDB();
            personDB.addPerson(p);
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println(e.printStackTrace());
        }
    }
}

