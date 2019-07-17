import database.PersonDB;
import logic.Person;
import rmi.Controller;
import rmi.ControllerInterface;

import java.rmi.Naming;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        try {
            ControllerInterface stub = new Controller();
            Naming.rebind("rmi://localhost:5000/messenger", stub);
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println(e.printStackTrace());
        }
    }
}

