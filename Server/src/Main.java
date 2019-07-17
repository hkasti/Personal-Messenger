import rmi.Controller;
import rmi.ControllerInterface;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
            URL src = Main.class.getResource("rmi/Controller_Stub.class");
            String dst = new File("../Client/out/production/Client/rmi/Controller_Stub.class")
                    .getCanonicalPath();
            Files.copy(new File(src.getPath()).toPath(),
                    new File(dst).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
//            cmd = "cp rmi/Controller_Stub.class ../../../Client/out/production/Client/rmi/Controller_Stub.class";
            LocateRegistry.createRegistry(port);
            ControllerInterface stub = new Controller();
            Naming.rebind("rmi://0.0.0.0:" + port + "/messenger", stub);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

