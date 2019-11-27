/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saipati
 */


/*A Job object is instantiated with two variables, one indicating the arrivalTime, and the other the timeForTheJob. 
When the Job is created it is given the next sequential ID starting from 1. (You should use a static variable to keep track of where you are in ID assignment.)
There are also int variables for startTime, waitTime (in queue) and endTime for the Job.
The following methods are required:
getID, 
set and get arrivalTime
set and get timeForJob
set and get startTime
set and get endTime
get waitTime
When setting the startTime you should be able to calculate the waitTime
*/

//satisfied everything

public class Job {
    
    private static int JobId = 0;
    private int ID=0;
    //static int JobId = 0; //increment when creating a new job    
    int arrivalTime;
    int timeForTheJob;
    int startTime;
    int endTime;
    int waitTime;

    public Job() {
        
        ID = JobId+1;
    }  
    
    public Job(int arrivalTime,int timeForTheJob)            
    {
        JobId = JobId+1;
        ID = JobId;
        
        setArrivalTime(arrivalTime);
        setTimeForTheJob(timeForTheJob);
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
        setWaitTime(this.startTime-this.arrivalTime);
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
    
    public int getID()
    {
       return this.ID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTimeForTheJob() {
        return timeForTheJob;
    }

    public void setTimeForTheJob(int timeForTheJob) {
        this.timeForTheJob = timeForTheJob;
    }
    
}
