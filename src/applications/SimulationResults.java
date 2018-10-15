package applications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class SimulationResults {
    private int finishTime;
    private int numMachines;
    private int[] numTasksPerMachine;
    private int[] totalWaitTimePerMachine;

    // the key is the job number, the completionTime is the left value of the ImmutablePair and the totalWaitTime is the right value of the ImmutablePair
    private Map<Integer, ImmutablePair<Integer, Integer>>[] jobCompletions;
    private int nextJob = 0;

    public SimulationResults(int numJobs) {
        jobCompletions = new HashMap[numJobs];
    }

    public void print() {
        for (Map<Integer, ImmutablePair<Integer, Integer>> map : jobCompletions) {
            for (Map.Entry<Integer, ImmutablePair<Integer, Integer>> entry : map.entrySet()) {
                System.out.println("Job " + entry.getKey() + " has completed at "
                        + entry.getValue().left + " Total wait was " + entry.getValue().right);
            }
        }

        System.out.println("Finish time = " + finishTime);
        for (int p = 1; p <= numMachines; p++) {
            System.out.println("Machine " + p + " completed "
                    + numTasksPerMachine[p] + " tasks");
            System.out.println("The total wait time was "
                    + totalWaitTimePerMachine[p]);
            System.out.println();
        }
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public void setNumMachines(int numMachines) {
        this.numMachines = numMachines;
    }

    public int[] getNumTasksPerMachine() {
        return Arrays.copyOf(numTasksPerMachine, numTasksPerMachine.length);
    }

    public void setNumTasksPerMachine(int[] numTasksPerMachine) {
        this.numTasksPerMachine = numTasksPerMachine;
    }

    public int[] getTotalWaitTimePerMachine() {
        return Arrays.copyOf(totalWaitTimePerMachine, totalWaitTimePerMachine.length);
    }

    public void setTotalWaitTimePerMachine(int[] totalWaitTimePerMachine) {
        this.totalWaitTimePerMachine = totalWaitTimePerMachine;
    }

    public Map<Integer, ImmutablePair<Integer, Integer>> getNthJobCompletionData(int i) {
        return jobCompletions[i];
    }

    public void setJobCompletionData(int jobNumber, int completionTime, int totalWaitTime) {
        ImmutablePair<Integer, Integer> timeHolder = new ImmutablePair<>(completionTime, totalWaitTime);

        Map<Integer, ImmutablePair<Integer, Integer>> jobCompletionData = new HashMap();
        jobCompletionData.put(jobNumber, timeHolder);
        jobCompletions[nextJob] = jobCompletionData;
        nextJob++;
    }
}
