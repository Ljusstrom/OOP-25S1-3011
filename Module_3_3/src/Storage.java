/**
 * Linear storage for (value, time) pairs
 *
 * @author Jarkko Vuori
 */

import java.util.ArrayList;

public class Storage {
    protected class ProcessTemp {
        public double value;
        public long  measurementTime;

        public ProcessTemp(double value, long time) {
            this.value           = value;
            this.measurementTime = time;
        }
    }
    protected ArrayList<ProcessTemp> measurements;

    public Storage() {
        measurements = new ArrayList<>();
    }

    /** Store one (value, time) pair
     * @param value value to be stored
     * @param time  time (in milliseconds)
     */
    public void storeMeasurement(double value, long time) {
        measurements.add(new ProcessTemp(value, time));
    }
}