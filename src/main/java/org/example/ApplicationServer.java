package org.example;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ApplicationServer {
    public static void main (String[] args) throws RemoteException{
        try{
            Registry registry = LocateRegistry.createRegistry(5099);
            registry.rebind("PrintService", new PrintServant());
            System.out.println("Print Server Is Running!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
