package rmi;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControllerInterface extends Remote {


    public String test21(String a) throws RemoteException;

    public void signup(String firstName, String lastName, String email, String username, String password, String profileImage) throws RemoteException;

    public String getPerson(String username) throws RemoteException;

    public void removeUser(String username) throws RemoteException;

    public void SendMessage() throws RemoteException;

    public void SendFile() throws RemoteException;

    public void Choosechat() throws RemoteException;

    public void setPic(MouseEvent mouseEvent) throws RemoteException;

    public void setSearchUser() throws RemoteException;

    public void DelAccYesB() throws IOException,RemoteException;

    public void LogOYesB() throws IOException,RemoteException;

    public void setUser() throws RemoteException;

    public void setPass() throws RemoteException;





}
