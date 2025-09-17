import java.util.ArrayList;

public class TaskSplitDemo {
    private static final int N = 2000;

    public static void execute(int[][] matrix, int cores) {
        /* split the task to individual threads */
        ArrayList<MatHunter> mathunters = new ArrayList<>();
        double dy = N/cores;
        for (int i = 0; i < cores; i++) {
            /* Divide columns to roughly equally sized groups. The last column may be a little larger due rounding */
            int slicestart = (int)Math.round(i*dy);
            int sliceend = N;
            if (i < cores-1)
                sliceend = (int)Math.round((i+1)*dy);

            /* Then create MatHunter thread/job for that part of the matrix */
            mathunters.add(new MatHunter(matrix, 0, N-1, slicestart, sliceend-1));
        }

        /* start treads */
        long start = System.nanoTime();
        for (MatHunter mh : mathunters)
            mh.start();

        /* wait for them to complete their tasks, and collect results */
        int result = 0;
        for (MatHunter mh : mathunters) {
            try {
                mh.join();
            } catch (InterruptedException e) {
                // thread was interrupted, the result may be incorrect
                e.printStackTrace();
            }
            result += mh.getFound();
        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time elapsed " + timeElapsed/10e6 + " ms. The result is " + result);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[N][N];

        /* create a matrix having zeros and random number of ones */
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (Math.random() > 0.5)
                    matrix[i][j] = 1;

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Our system has " + cores + " processor cores\n");
        System.out.print("1 Thread(s): "); execute(matrix, 1);
        System.out.print("1 Thread(s): "); execute(matrix, 1);
        System.out.print(cores + " Thread(s): "); execute(matrix, cores);
    }
}