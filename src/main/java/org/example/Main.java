package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        //HelloService service = (HelloService) Naming.lookup("rmi://localhost:5099/PrintService");
        PrintService service = (PrintService) Naming.lookup("rmi://localhost:5099/PrintService");
        service.print("sample1.txt","printer1");
        service.print("sample2.txt","printer1");
        service.print("sample3.txt","printer2");
        String queueInfo = service.printQueue("printer1");
        System.out.println(queueInfo);
        queueInfo = service.printQueue("printer2");
        System.out.println(queueInfo);
    }
}