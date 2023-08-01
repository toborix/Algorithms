package LearnAlgorithms.SortAlgorithms.MergeSort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MergeSort {

    public static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) return list;
        List<Integer> left = new ArrayList<>(list.subList(0, list.size() / 2));
        List<Integer> right = new ArrayList<>(list.subList(list.size() / 2, list.size()));
        return merge(mergeSort(left), mergeSort(right));
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftIndex = 0; // index of first sub-array
        int rightIndex = 0; // index of second sub-array
        int listIndex = 0; // index of merged sub-array

        List<Integer> mergedList = new ArrayList<>(left.size() + right.size());

        // compare left and right lists, add the smaller value to the list
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                mergedList.add(left.get(leftIndex));
                leftIndex++;
            } else {
                mergedList.add(right.get(rightIndex));
                rightIndex++;
            }
            listIndex++;
        }

        // add the rest of the list to the end of the list
        while (leftIndex < left.size()) {
            mergedList.add(left.get(leftIndex));
            leftIndex++;
            listIndex++;
        }

        while (rightIndex < right.size()) {
            mergedList.add(right.get(rightIndex));
            rightIndex++;
            listIndex++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Random r = new Random();
        List<Integer> list_rand = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            list_rand.add(r.nextInt(1000000));
        }

        System.out.println(list_rand);
        System.out.println(mergeSort(list_rand));


//        // Showcasing merge sort
//
//        // Case 1: Big integer lengths
//        List<Integer> list = List.of(5, 4, 1, 8, 7, 2, 6, 3, 9, 0, 10, 11, 12, 13, 14, 15);
//        mergeSort(list);





//        if (sortedList.equals(List.of(1, 2, 3, 4, 5, 6, 7, 8))) {
//            System.out.println("Test 1 passed");
//
//        } else {
//            throw new AssertionError( "Expected 1 : " + List.of(1, 2, 3, 4, 5, 6, 7, 8) + "\n" +
//                    "Actual 1 : " + sortedList + "\n\n");
//        }
//
//        if (sortedList2.equals(List.of(1, 2, 3, 6, 7))) {
//            System.out.println("Test 2 passed");
//
//        } else {
//            throw new AssertionError( "Expected 2 : " + List.of(1, 2, 3, 6, 7) + "\n" +
//                    "Actual 2 : " + sortedList2 + "\n\n");
//        }


        long endTime   = System.currentTimeMillis();
        float totalTime = (endTime - startTime)/1000f;
        System.out.println(totalTime + " s");





    }
}
