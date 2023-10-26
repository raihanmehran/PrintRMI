package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        //HelloService service = (HelloService) Naming.lookup("rmi://localhost:5099/PrintService");
        PrintService service = (PrintService) Naming.lookup("rmi://localhost:5099/PrintService");
        //service.print("sample1.txt","printer1");
        //service.print("sample2.txt","printer1");
        //service.print("sample3.txt","printer2");
        //String queueInfo = service.printQueue("printer1");
        //System.out.println(queueInfo);
        //queueInfo = service.printQueue("printer2");
        //System.out.println(queueInfo);

        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Good to see you! \t I am your agent! \n")
        ;
        while(isRunning){
            printTaskList();
            String taskInput = scanner.nextLine();

            switch (taskInput){
                case "1":
                    System.out.print("Enter filename: ");
                    String fileName = scanner.nextLine();
                    System.out.print("Enter printer: ");
                    String printer1 = scanner.nextLine();
                    service.print(fileName,printer1);
                    break;
                case "2":
                    System.out.print("Enter printer name: ");
                    String printer2 = scanner.nextLine();
                    System.out.println("Printing jobs for printer ["+printer2+"] are:");
                    System.out.println(service.printQueue(printer2));
                    break;
                case "3":
                    System.out.print("Enter printer name: ");
                    String printer3 = scanner.nextLine();
                    System.out.print("Enter job number: ");
                    int jobId = Integer.parseInt(scanner.nextLine());
                    service.topQueue(printer3, jobId);
                    break;
                case "4":
                    service.start();
                    break;
                case "5":
                    service.stop();
                    break;
                case "6":
                    service.restart();
                    break;
                case "7":
                    System.out.print("Enter printer name: ");
                    String printer4 = scanner.nextLine();
                    System.out.println(service.status(printer4));
                    break;
                case "8":
                    System.out.print("Enter parameter name: ");
                    String parameter1 = scanner.nextLine();
                    System.out.println(service.readConfig(parameter1));
                    break;
                case "9":
                    System.out.print("Enter parameter name: ");
                    String parameter2 = scanner.nextLine();
                    System.out.print("Enter value: ");
                    String value = scanner.nextLine();

                    service.setConfig(parameter2, value);
                    break;
                case "10":
                    isRunning = false;
                    break;
                case "x":
                    isRunning = false;
                    break;
            }
        }
    }

    private static void printTaskList(){
        System.out.println("1. add a print job");
        System.out.println("2. print the job list");
        System.out.println("3. move a job to the top of the queue");
        System.out.println("4. start the print server");
        System.out.println("5. stop the print server");
        System.out.println("6. restart the print server");
        System.out.println("7. print the status of the printer");
        System.out.println("8. read the parameters");
        System.out.println("9. set the parameters");
        System.out.println("10. exit -> (x)");
        System.out.print("\nWhat can I do for you: ");
    }
}