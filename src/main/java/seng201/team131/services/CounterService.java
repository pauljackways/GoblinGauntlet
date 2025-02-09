package seng201.team131.services;

import seng201.team131.models.Counter;

/**
 * Simple service class to interact with counters
 * @author seng201 teaching team
 */
public class CounterService {
    private final Counter counter;

    /**
     * Constructor
     */
    public CounterService() {
        counter = new Counter();
    }

    /**
     * Increment our counter by one
     */
    public void incrementCounter() {
        counter.setCount(counter.getCount() + 1);
    }

    /**
     * Get the current count of the counter
     * @return Current count
     */
    public int getCurrentCount() {
        return counter.getCount();
    }
}
