import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Integer> numbersList = new ArrayList<>();
    private static final Integer listSize = 100000000;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        for (int i = 0; i < listSize; i++) {
            numbersList.add(i);
        }

        for (int i = 0; i < 30; i++) {
            int randomNumber = (int) (Math.random() * listSize);
            System.out.println("Number: " + randomNumber);
            //time to execute each function
            int startTimeLinear = (int) System.currentTimeMillis();
            linearSearch(randomNumber);
            int endTimeLinear = (int) System.currentTimeMillis();
            System.out.println("Time to execute linear search: " + (endTimeLinear - startTimeLinear) + "ms");

            int startTimeBinary = (int) System.currentTimeMillis();
            binarySearch(randomNumber);
            int endTimeBinary = (int) System.currentTimeMillis();
            System.out.println("Time to execute binary search: " + (endTimeBinary - startTimeBinary) + "ms");

            System.out.println("---------------------------------------------------");
        }
    }

    public static void linearSearch(int numberToFind) {
        System.out.println("Linear search");

        for (Integer numberFromList : numbersList) {
            if (numberFromList == numberToFind) {
                System.out.println("Number found: " + numberFromList);
                return;
            }
        }

        System.out.println("Number not found");

    }

    public static void binarySearch(int numberToFind) {
        System.out.println("Binary search");

        int initial = 0;
        int end = numbersList.size() - 1;
        int middle = (initial + end) / 2;

        int foundNumber = -1;

//        System.out.println("Initial: " + initial + " End: " + end + " Middle: " + middle);

        while (foundNumber == -1) {
            if (numbersList.get(middle) == numberToFind) {
                foundNumber = numbersList.get(middle);
            }

            if (numbersList.get(middle) < numberToFind) {
                initial = middle + 1;
            }

            if (numbersList.get(middle) > numberToFind) {
                end = middle - 1;
            }

            middle = (initial + end) / 2;
//            System.out.println("Initial: " + initial + " End: " + end + " Middle: " + middle);
        }

        System.out.println("Number found: " + foundNumber);
    }
}