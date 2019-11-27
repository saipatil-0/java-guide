
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saipati
 */
public class TestPrintQueueSimulation {
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Provide number of printers \n");
        int noOfPrinters = sc.nextInt();
        System.out.println("Provide number of jobs \n");
        int noOfJobs = sc.nextInt();
        PrintQueueSimulation pQs= new PrintQueueSimulation(noOfPrinters, noOfJobs);
        pQs.simulate();
        
    }
    
}
