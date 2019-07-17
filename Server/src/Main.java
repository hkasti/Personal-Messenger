import rmi.Controller;
import rmi.ControllerInterface;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
    static int port = 5000;

    public static void main(String[] args) {
        try {
            String cmd;
            Process p;
            cmd = "rmic rmi.Controller";
            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            cmd = "cp rmi/Controller_Stub.class ../../../Client/out/production/Client/rmi/Controller_Stub.class";
            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            LocateRegistry.createRegistry(port);
            ControllerInterface stub = new Controller();
            Naming.rebind("rmi://0.0.0.0:" + port + "/messenger", stub);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

