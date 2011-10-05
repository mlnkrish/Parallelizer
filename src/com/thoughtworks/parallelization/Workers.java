package com.thoughtworks.parallelization;

import java.util.ArrayList;

public class Workers extends ArrayList<Worker>{

    private Status status = Status.Ready;

    public void start(){
        for(Worker worker:this){
            worker.start();
        }
        status = Status.Running;
    }

    public boolean isComplete(){
        if(status.equals(Status.Ready))
            return false;
        if(status.equals(Status.Done))
            return true;

        for(Worker worker:this){
            if(!worker.isComplete()){
                return false;
            }
        }
        status = Status.Done;
        return true;
    }
}
