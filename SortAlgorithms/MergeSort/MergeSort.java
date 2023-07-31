package LearnAlgorithms.SortAlgorithms.MergeSort;

import java.util.List;

public class MergeSort {

    public static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) return list;
        List<Integer> left = list.subList(0, list.size() / 2);
        List<Integer> right = list.subList(list.size() / 2, list.size());
        return merge(mergeSort(left), mergeSort(right));
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = 0;
        // compare left and right lists, add the smaller value to the list
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                left.set(listIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                left.set(listIndex, right.get(rightIndex));
                rightIndex++;
            }
            listIndex++;
        }
        // add the rest of the list to the end of the list
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
            rest.set(listIndex, rest.get(i));
            listIndex++;
        }
        return rest;
    }

    public static void main(String[] args) {
        // Showcasing merge sort

        // Case 1: Big integer lengths
        List<Integer> list = List.of(5, 4, 1, 8, 7, 2, 6, 3);
        List<Integer> sortedList = mergeSort(list);

        // Printing the expected and corresponding actual product
        System.out.println("Expected 1 : " + List.of(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println("Actual 1 : " + sortedList + "\n\n");

        assert (sortedList.equals(List.of(1, 2, 3, 4, 5, 6, 7, 8)));



    }


}
