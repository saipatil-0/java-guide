
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author saipati
 */

/*
 This is the main driver of this simulation. It is instantiated with the number of printers and the
 number of jobs to be processed. The simulation runs until all the jobs are processed. There is a
 single print queue that all printers service. As soon as a printer finishes it get the next job (if any
 exists) from the waitQueue. Printer Printer0 has priority over Printer1, etc. The simulate method
 (see below) runs the simulation and calls displayStatistics once the simulation completes.
 This class has the following instance variable:
 waitQueue which is a Queue where the references to arriving Jobs are placed, until they pulled
 by a Printer
 an int totalWaitTime which keeps track of the total wait time for all jobs
 finishedQueue which is a Queue where a Job reference is placed when a job is completed
 an int currentTime is the simulation clock which starts at 0 and is incremented 1 second at a time
 printer which is an array of Printer objects
 randy – a reference to a Random object
 two int variables – numberOfPrinters and numberOfPrintJobs
 When PrintQueueSimulation is instantiated it the numberOfJobs and numberOfPrinters. It also
 creates a Random object (randy).
 It creates a waitQueue with a size equal to the numberOfPrintJobs.
 It creates a finishedQueue with a size equal to the numberOfPrintJobs.
 It also creates an array printer of size numberOfPrinters.
 It then creates a set of printers, with the array printer referring to each of them. As the printer is
 created the printer names will be Printerl0, Printer1, …
 (Hint: printer[i] = new Printer(&quot;Printer&quot; +i);
 simulate() method
 This method will simulate the completion of all the print jobs, using the numberOfPrinters as
 defined.
 You may want to create some local variables to help with this method
 I created a flagDone which I set to false, allowing me to loop through the logic below until all
 the Jobs were printed.
 For this simulation a new job will be created every 100 seconds. When a Job is created it is
 randomly assigned a jobTime of between 10 and 1000 seconds.
 Below is an outline of the logic, but you will need to do some work and coding
 While all jobs aren’t complete (flag is false)
 If a job needs to be created (Every 100 seconds (%100 == 0) and not all job yet create
 Generate a job time and create a job
 //See if any Job is fished
 For each printer
 If there is a Job in the printer
 If the Job is complete
 Set the endTime
 Place job in the finishedQueue
 Set the printer queue Job to null
 Set the idleStartTime for the printer to the currentTime

 //See if a printer is idle. If so and a job is waiting and assign it to the printer if there is one
 For each printer

 6

 If the printer is idle
 If the waitQueue isn’t empty
 Remove a job from the waitQueue
 Set the startTime for the job.
 Place the job in the printer
 Set the startInUseTime for the printer
 Update the totalWaitTime

 Increment the totalTime
 If the number of jobs to arrive is complete and the waitQueue is empty
 Set the flag to true
 If there is still a job in any printer
 Set the flag back to false

 End of loop
 Call displayStatitics
 displayStatistics()
 Produce a report like the one in the sample output below.
 */
public class PrintQueueSimulation {

    /*
     It is instantiated with the number of printers and the
     number of jobs to be processed. The simulation runs until all the jobs are processed. There is a
     single print queue that all printers service. As soon as a printer finishes it get the next job (if any
     exists) from the waitQueue. Printer Printer0 has priority over Printer1, etc. The simulate method
     (see below) runs the simulation and calls displayStatistics once the simulation completes.
     This class has the following instance variable:
     waitQueue which is a Queue where the references to arriving Jobs are placed, until they pulled
     by a Printer
     an int totalWaitTime which keeps track of the total wait time for all jobs
     finishedQueue which is a Queue where a Job reference is placed when a job is completed
     an int currentTime is the simulation clock which starts at 0 and is incremented 1 second at a time
     printer which is an array of Printer objects
     randy – a reference to a Random object
     two int variables – numberOfPrinters and numberOfPrintJobs
     When PrintQueueSimulation is instantiated it the numberOfJobs and numberOfPrinters. It also
     creates a Random object (randy).
     It creates a waitQueue with a size equal to the numberOfPrintJobs.
     It creates a finishedQueue with a size equal to the numberOfPrintJobs.
     It also creates an array printer of size numberOfPrinters.
     It then creates a set of printers, with the array printer referring to each of them. As the printer is
     created the printer names will be Printerl0, Printer1, …
     (Hint: printer[i] = new Printer(&quot;Printer&quot; +i);
     */
    int numberOfPrinters;
    int numberOfPrintJobs;
    Queue<Job> waitQueue;
    Queue<Job> finishedQueue;

    int totalWaitTime; //keeps track of the total wait time for all jobs
    int currentTime = 0; //simulation clock which starts at 0 and is incremented 1 second at a time
    Printer[] printer; //array of Printer objects
    Random randy; //a reference to a Random object

    public PrintQueueSimulation(int numberOfPrinters, int numberOfPrintJobs) {
        this.numberOfPrinters = numberOfPrinters;
        this.numberOfPrintJobs = numberOfPrintJobs;
        randy = new Random();
        //It creates a waitQueue with a size equal to the numberOfPrintJobs.
        waitQueue = new Queue(numberOfPrintJobs);
        //It creates a finishedQueue with a size equal to the numberOfPrintJobs.
        finishedQueue = new Queue(numberOfPrintJobs);

        /*
         It also creates an array printer of size numberOfPrinters.
         It then creates a set of printers, with the array printer referring to each of them. As the printer is
         created the printer names will be Printerl0, Printer1, …
         (Hint: printer[i] = new Printer(&quot;Printer&quot; +i);*/
        
        printer = new Printer[numberOfPrinters];
        for (int i = 0; i < numberOfPrinters; i++) {
            printer[i] = new Printer("Printer" + i);
        }

    }

    // This method will simulate the completion of all the print jobs, using the numberOfPrinters as defined.
    void simulate() {
       
        int jobInterval = 100; //every 100s new job is created 
        int noOfJobs = numberOfPrintJobs;
        boolean flagDone = false;
               
        while (!flagDone) {
            
            if (noOfJobs > 0 && ((currentTime%jobInterval) == 0)) 
            {
                int timeToFinishJob = randy.nextInt(991) + 10;
                Job j = new Job(currentTime, timeToFinishJob);
                noOfJobs--; 
                this.waitQueue.insert(j); //add to the queue
            }

            for (int k = 0; k < numberOfPrinters; k++) {
                
                Printer CurrPrinter = printer[k];

                if (CurrPrinter.job != null) {
                    Job currJob = CurrPrinter.job;
                    if ((currJob.getTimeForTheJob()) == (currentTime - currJob.getStartTime())) {
                        this.finishedQueue.insert(currJob);
                        //job is completed so set endtime
                        currJob.setEndTime(currentTime);
                        CurrPrinter.job = null;
                        CurrPrinter.setStartIdleTime(currentTime);

                    }
                } else //printer is free
                {
                    if (this.waitQueue.peek() != null) {
                        Job newJob = this.waitQueue.remove();                        
                        newJob.setStartTime(currentTime);
                        CurrPrinter.setJob(newJob);
                        CurrPrinter.setStartInUseTime(currentTime);
                        this.totalWaitTime += newJob.getWaitTime();
                    }

                }
            }
             
            if (this.finishedQueue.size() == numberOfPrintJobs) {
                flagDone = true;
            }

            currentTime++;
        }
              
        displayStatistics();

        //}
                /*
         This method will simulate the completion of all the print jobs, using the numberOfPrinters as
         defined.
         You may want to create some local variables to help with this method
         I created a flagDone which I set to false, allowing me to loop through the logic below until all
         the Jobs were printed.
         For this simulation a new job will be created every 100 seconds. When a Job is created it is
         randomly assigned a jobTime of between 10 and 1000 seconds.
         Below is an outline of the logic, but you will need to do some work and coding
         While all jobs aren’t complete (flag is false)
         If a job needs to be created (Every 100 seconds (%100 == 0) and not all job yet create
         Generate a job time and create a job
         //See if any Job is fished
         For each printer
         If there is a Job in the printer
         If the Job is complete
         Set the endTime
         Place job in the finishedQueue
         Set the printer queue Job to null
         Set the idleStartTime for the printer to the currentTime

         //See if a printer is idle. If so and a job is waiting and assign it to the printer if there is one
         For each printer

         6

         If the printer is idle
         If the waitQueue isn’t empty
         Remove a job from the waitQueue
         Set the startTime for the job.
         Place the job in the printer
         Set the startInUseTime for the printer
         Update the totalWaitTime

         Increment the totalTime
         If the number of jobs to arrive is complete and the waitQueue is empty
         Set the flag to true
         If there is still a job in any printer
         Set the flag back to false

         End of loop
         Call displayStatitics
         */
    }

    void displayStatistics() {
        
        System.out.println("Simulation with "+numberOfPrinters+" printers lasted"+currentTime+" seconds processed"+numberOfPrintJobs+" jobs \n");
        System.out.println("The average time in the wait queue for a job is" + (this.totalWaitTime/numberOfPrintJobs)+"seconds \n");

        System.out.println("Printer Statistics\n");
        System.out.println("Name \t Jobs Processed \t In Use \t Idle");
        for(int i=0;i<numberOfPrinters;i++)
        {
            Printer p = printer[i];
            System.out.println(p.printerName+"\t"+p.getTotalJobsProcessed()+"\t"+p.getTotalInUseTime()+"\t\t"+(currentTime-p.getTotalInUseTime()));
        }
        
        System.out.println("Job Statistics");
       // System.out.format(null, printer) - use format to display values
        System.out.println("Job No. \t Wait Time \t Length Of Job \t ");
        
        System.out.println(finishedQueue.size());
        
        for(int i=0;i<numberOfPrintJobs;i++)
        {
            Job newJob = this.finishedQueue.remove();
            
            System.out.println(newJob.getID()+"\t"+newJob.getWaitTime()+"\t"+newJob.getTimeForTheJob());
        }           
        


    }

}
