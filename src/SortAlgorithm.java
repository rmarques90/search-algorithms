import java.util.ArrayList;
import java.util.List;

public class SortAlgorithm {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            numbers.add((int) (Math.random() * 100000));
        }

        System.out.println("Before sorting:");
        for (int number : numbers) {
            System.out.println(number);
        }

        long startTime = System.currentTimeMillis();

        //Big O notation: O(n^2)
        bubbleSort(numbers);

        long endTime = System.currentTimeMillis();
        System.out.println("Time to execute bubble sort: " + (endTime - startTime) + "ms");

        System.out.println("After sorting:");
        for (int number : numbers) {
            System.out.println(number);
        }

        System.out.println("---------------------------------------------------");

        List<Integer> numbersMerge = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            numbersMerge.add((int) (Math.random() * 100000));
        }

        System.out.println("Before sorting:");
        for (int number : numbersMerge) {
            System.out.println(number);
        }

        startTime = System.currentTimeMillis();
        //Big O notation: O(n log n)
        mergeSort(numbersMerge);
        endTime = System.currentTimeMillis();

        System.out.println("Time to execute merge sort: " + (endTime - startTime) + "ms");

        System.out.println("After sorting:");
        for (int number : numbersMerge) {
            System.out.println(number);
        }


    }

    public static void bubbleSort(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size() - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    int temp = numbers.get(j);
                    numbers.set(j , numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
    }

    public static void mergeSort(List<Integer> numbers) {
        if (numbers.size() < 2) {
            return;
        }

        int middle = numbers.size() / 2;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < middle; i++) {
            left.add(numbers.get(i));
        }

        for (int i = middle; i < numbers.size(); i++) {
            right.add(numbers.get(i));
        }

        mergeSort(left);
        mergeSort(right);

        merge(numbers, left, right);
    }

    public static void merge(List<Integer> numbers, List<Integer> left, List<Integer> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int numbersIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                numbers.set(numbersIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                numbers.set(numbersIndex, right.get(rightIndex));
                rightIndex++;
            }
            numbersIndex++;
        }

        List<Integer> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }

        for (int i = restIndex; i < rest.size(); i++) {
            numbers.set(numbersIndex, rest.get(i));
            numbersIndex++;
        }
    }
}
