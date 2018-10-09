package applications;

import dataStructures.LinkedQueue;
import javafx.util.Pair;

class Job {
    // data members
    private LinkedQueue taskQ; // this job's tasks
    private int length; // sum of scheduled task times
    private int arrivalTime; // arrival time at current queue
    private int id; // job identifier

    // constructor
    Job(int theId) {
        id = theId;
        taskQ = new LinkedQueue();
        // length and arrivalTime have default value 0
    }

    // other methods

    /**
     * add a task with the data structure Pair<> on this.taskQ
     * @param theMachine is the Key in Pair<>
     * @param theTime is the Value in Pair<>
     */
    public void addTask(int theMachine, int theTime) {
        getTaskQ().put(new Pair<>(theMachine, theTime));
    }

    /**
     * get next machine and return it to
     * MachineShopSimulator.moveToNextMachine()
     * @return next machine
     */
    public int getNextMachine() {
        Pair task = (Pair) this.taskQ.getFrontElement();
        int machine = (Integer) task.getKey();
        return machine;
    }

    /**
     * remove next task from the job and return its time
     * to MachineShopSimulator.changeState()
     * also update length
     * @return the time for task
     */
    public int removeNextTask() {
        Pair task = ((Pair) getTaskQ().remove());
        int theTime = ((Integer) task.getValue());
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

    // top-level nested classes
    private class Task {
        // data members
        private int machine;
        private int time;

        // constructor
        Task(int theMachine, int theTime) {
            machine = theMachine;
            time = theTime;
        }

        public int getMachine() {
            return machine;
        }

        public int getTime() {
            return time;
        }
    }
}
