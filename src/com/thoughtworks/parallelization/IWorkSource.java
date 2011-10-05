package com.thoughtworks.parallelization;

/**
 * implementations of this needs to be thread safe.
 */
public interface IWorkSource {

    public boolean hasNext();

    /**
     *
     * @return Returns a workItem, should return a com.thoughtworks.parallelization.NullWorkItem when all work is done.
     */
    public IWorkItem getNext();
}
