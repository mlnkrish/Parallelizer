package com.thoughtworks.parallelization;

public class Worker extends Thread {

    private final IWorkSource workSource;
    private Status status = Status.Ready;

    public Worker(IWorkSource workSource) {
        this.workSource = workSource;
    }

    public void run() {
        status = Status.Running;
        while (workSource.hasNext()){
            IWorkItem workItem = workSource.getNext();
            workItem.doRun();
        }
        status = Status.Done;
    }

    public boolean isComplete() {
        return status.equals(Status.Done);
    }
}
