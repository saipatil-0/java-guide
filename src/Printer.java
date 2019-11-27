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

A Printer object is instantiated with a printerName.
It also includes an instance variable of type Job which is either null or refers to the current Job being processed by the printer.
There are also int variables for startIdleTime, startInUseTime, totalIdleTime, totalInUseTime, totalJobsProcessed, which should be self-explanatory.
The following methods are required:
set and get printerName
set and get the Job reference
set the startInUseTime – includes incrementing the totalJobsProcessed variable
set the startIdleTime – includes updating the totalInUseTime
get totalIdleTime – easily calculated at the end of the simulation since it is called with currentTime as an input parameter
get totalInUseTime
get totalJobsProcessed

*/

public class Printer {
    
    Job job;
    int startIdleTime;
    int startInUseTime;
    int totalIdleTime;
    int totalInUseTime;
    int totalJobsProcessed;
    String printerName;

    Printer(String printerName) {
        this.printerName = printerName;
    }

    public int getTotalIdleTime() { //currnetTime=totalInUseTime
        return totalIdleTime;
    }

    public int getTotalInUseTime() {
        return totalInUseTime;
    }

    public int getTotalJobsProcessed() {
        return totalJobsProcessed;
    }

    public void setStartIdleTime(int startIdleTime) {
        this.startIdleTime = startIdleTime;
        this.totalInUseTime +=(this.startIdleTime-this.startInUseTime);
    }

    public void setStartInUseTime(int startInUseTime) {
        this.startInUseTime = startInUseTime;
        totalJobsProcessed++;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
    
   
}
