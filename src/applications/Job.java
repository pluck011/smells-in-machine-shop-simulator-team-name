package applications;

import dataStructures.LinkedQueue;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

class Job {
    // data members
    private LinkedQueue taskQ; // this job's tasks
    private int length; // sum of scheduled task times - default is 0
    private int arrivalTime; // arrival time at current queue - default is 0
    private int id; // job identifier

    // constructor
    Job(int theId) {
        id = theId;
        taskQ = new LinkedQueue();
    }

    // other methods

    /**
     * add a task with the data structure Pair<> on this.taskQ
     * @param theMachine is the Key in Pair<>
     * @param theTime is the Value in Pair<>
     */
    public void addTask(int theMachine, int theTime) {
        getTaskQ().put(new ImmutablePair<Integer, Integer>(theMachine, theTime));
    }

    /**
     * get next machine and return it to
     * MachineShopSimulator.moveToNextMachine()
     * @return next machine
     */
    public int getNextMachine() {
        Pair<Integer, Integer> task = (ImmutablePair<Integer, Integer>) this.taskQ.getFrontElement();
        int machine = task.getKey();
        return machine;
    }

    /**
     * remove next task from the job and return its time
     * to MachineShopSimulator.changeState()
     * also update length
     * @return the time for task
     */
    public int removeNextTask() {
        Pair<Integer, Integer> task = ((ImmutablePair<Integer, Integer>) getTaskQ().remove());
        int theTime = task.getValue();
        length = getLength() + theTime;
        return theTime;
    }

    public LinkedQueue getTaskQ() {
        return taskQ;
    }

    public int getLength() {
        return length;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }
}
