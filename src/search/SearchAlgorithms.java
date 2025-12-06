// SearchAlgorithms.java
// Linear Search and Binary Search Implementations
// Students' Implementation

public class SearchAlgorithms {

    // === EXISTING METHODS (for int[] arrays) ===

    // Linear Search: O(n) time complexity
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Found at index i
            }
        }
        return -1; // Not found
    }

    // Binary Search: O(log n) time complexity – requires sorted array
    public static int binarySearch(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] == target) {
                return mid; // Found
            } else if (sortedArray[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Not found
    }

    // === NEW METHODS (for DynamicArray) ===

    // Linear Search for DynamicArray
    public static int linearSearch(DynamicArray array, int target) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == target) {
                return i; // Found at index i
            }
        }
        return -1; // Not found
    }

    // Binary Search for DynamicArray (requires sorted DynamicArray)
    public static int binarySearch(DynamicArray sortedArray, int target) {
        int left = 0;
        int right = sortedArray.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = sortedArray.get(mid);

            if (midValue == target) {
                return mid; // Found
            } else if (midValue < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Not found
    }
}