public class TestSearch {
    public static void main(String[] args) {
        // Test arrays
        int[] unsortedArray = {5, 2, 9, 1, 5, 6};
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        System.out.println("=== Testing Linear Search ===");

        // Test 1: Element exists
        int target1 = 9;
        int result1 = SearchAlgorithms.linearSearch(unsortedArray, target1);
        System.out.println("Searching for " + target1 + " in unsorted array:");
        System.out.println("Expected: Found at index 2");
        System.out.println("Actual: " + (result1 == -1 ? "Not found" : "Found at index " + result1));
        System.out.println();

        // Test 2: Element doesn't exist
        int target2 = 100;
        int result2 = SearchAlgorithms.linearSearch(unsortedArray, target2);
        System.out.println("Searching for " + target2 + " in unsorted array:");
        System.out.println("Expected: Not found (-1)");
        System.out.println("Actual: " + result2);
        System.out.println();

        System.out.println("=== Testing Binary Search ===");

        // Test 3: Element exists in sorted array
        int target3 = 13;
        int result3 = SearchAlgorithms.binarySearch(sortedArray, target3);
        System.out.println("Searching for " + target3 + " in sorted array:");
        System.out.println("Expected: Found at index 6");
        System.out.println("Actual: " + (result3 == -1 ? "Not found" : "Found at index " + result3));
        System.out.println();

        // Test 4: Element at beginning
        int target4 = 1;
        int result4 = SearchAlgorithms.binarySearch(sortedArray, target4);
        System.out.println("Searching for " + target4 + " (first element):");
        System.out.println("Expected: Found at index 0");
        System.out.println("Actual: " + (result4 == -1 ? "Not found" : "Found at index " + result4));
        System.out.println();

        // Test 5: Element at end
        int target5 = 19;
        int result5 = SearchAlgorithms.binarySearch(sortedArray, target5);
        System.out.println("Searching for " + target5 + " (last element):");
        System.out.println("Expected: Found at index 9");
        System.out.println("Actual: " + (result5 == -1 ? "Not found" : "Found at index " + result5));
        System.out.println();

        // Test 6: Element doesn't exist
        int target6 = 8;
        int result6 = SearchAlgorithms.binarySearch(sortedArray, target6);
        System.out.println("Searching for " + target6 + " (not in array):");
        System.out.println("Expected: Not found (-1)");
        System.out.println("Actual: " + result6);

        System.out.println("\n=== All Tests Complete ===");
    }
}