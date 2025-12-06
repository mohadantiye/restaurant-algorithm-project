// TestIntegration.java
public class TestIntegration {
    public static void main(String[] args) {
        System.out.println("=== Testing DynamicArray with Search Algorithms ===\n");

        DynamicArray da = new DynamicArray();
        da.add(10);
        da.add(20);
        da.add(30);
        da.add(40);
        da.add(50);

        System.out.println("Array: " + da.toString());

        // Test linear search
        System.out.println("\nLinear Search for 30: " +
                SearchAlgorithms.linearSearch(da, 30));
        System.out.println("Linear Search for 99: " +
                SearchAlgorithms.linearSearch(da, 99));

        // Test binary search (array is sorted: 10, 20, 30, 40, 50)
        System.out.println("\nBinary Search for 40: " +
                SearchAlgorithms.binarySearch(da, 40));
        System.out.println("Binary Search for 25: " +
                SearchAlgorithms.binarySearch(da, 25));

        System.out.println("\n=== Test Complete ===");
    }
}