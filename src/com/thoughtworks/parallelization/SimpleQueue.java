package com.thoughtworks.parallelization;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SimpleQueue implements IWorkSource {

    private final Queue<IWorkItem> workItems;

    public SimpleQueue(Queue<IWorkItem> workItems) {
        this.workItems = new ConcurrentLinkedQueue<IWorkItem>(workItems);
    }

    public boolean hasNext() {
        return !workItems.isEmpty();
    }

    public IWorkItem getNext() {
        IWorkItem workItem = workItems.poll();
        if(workItem == null){
            workItem = new NullWorkItem();
        }
        return workItem;
    }
}
