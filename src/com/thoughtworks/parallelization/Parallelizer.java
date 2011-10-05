package com.thoughtworks.parallelization;


public class Parallelizer {

    private final int numberOfThreads;
    private final IWorkSource workSource;

    public Parallelizer(int numberOfThreads,IWorkSource workSource) {
        this.numberOfThreads = numberOfThreads;
        this.workSource = workSource;
    }

    public void run(){
        Workers workers = new Workers();
        for (int i=0;i<numberOfThreads;i++){
            workers.add(new Worker(workSource));
        }
        workers.start();

        //spin wait till all work is done
        while (!workers.isComplete()){
            try {
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

