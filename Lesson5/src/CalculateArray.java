import java.util.Arrays;

/**
 * Created by Ivan Chaykin
 * Date: 13.01.2019
 * Time: 15:11
 */
public class CalculateArray {

    static final int SIZE = 10000000;
    static final int HALF_SIZE = SIZE / 2;

    public void calcWithoutThreads() {
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] *
                    Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        System.out.println("Результат метода с одним потоком " + (System.currentTimeMillis() - startTime));
    }

    public void calcWithThreads() {
        float[] arr = new float[SIZE];
        float[] a1 = new float[HALF_SIZE];
        float[] a2 = new float[HALF_SIZE];

        Arrays.fill(arr, 1);
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, a2, 0, HALF_SIZE);
        Thread one = new Thread(new CalcArray(a1, 0));
        Thread two = new Thread(new CalcArray(a2, HALF_SIZE));
        one.start();
        two.start();
        try {
            one.join();
            two.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(a2, 0, arr, HALF_SIZE, HALF_SIZE);
        System.out.println("Результат метода с двумя потоками " + (System.currentTimeMillis() - startTime));
    }

    class CalcArray implements Runnable {
        private float[] array;
        private int shift;

        CalcArray(float[] array, int shift) {
            this.array = array;
            this.shift = shift;
        }

        @Override
        public void run() {
            for (int i = 0; i < array.length; i++)
                array[i] = (float)(array[i] *
                        Math.sin(0.2f + (i + shift) / 5) *
                        Math.cos(0.2f + (i + shift) / 5) *
                        Math.cos(0.4f + (i + shift) / 2));
        }
    }

}
