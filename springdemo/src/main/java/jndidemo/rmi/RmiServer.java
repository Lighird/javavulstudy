package jndidemo.rmi;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {
    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {
        Registry registry= LocateRegistry.createRegistry(1099);
        System.out.println("java RMI registry created,port on 1099...");
        Reference refObj= new Reference("ExportObject","remoteclass.ExportObject","http://127.0.0.1:8000/");
        ReferenceWrapper refObjWrapper = new ReferenceWrapper(refObj);
        registry.bind("refObj",refObjWrapper);
    }
}
