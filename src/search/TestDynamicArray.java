// TestDynamicArray.java
public class TestDynamicArray {
    public static void main(String[] args) {
        System.out.println("=== Testing DynamicArray ===");

        // Test 1: Create and add elements
        DynamicArray da = new DynamicArray();
        System.out.println("1. Created new DynamicArray");
        System.out.println("   Initial size: " + da.size());
        System.out.println("   Is empty? " + da.isEmpty());

        // Test 2: Add elements
        da.add(10);
        da.add(20);
        da.add(30);
        da.add(40);
        da.add(50);

        System.out.println("\n2. Added 5 elements");
        System.out.println("   Current size: " + da.size());
        System.out.println("   Array: " + da.toString());

        // Test 3: Get elements
        System.out.println("\n3. Getting elements:");
        System.out.println("   Element at index 0: " + da.get(0));
        System.out.println("   Element at index 2: " + da.get(2));
        System.out.println("   Element at index 4: " + da.get(4));

        // Test 4: Test resizing (add more than 10 elements)
        System.out.println("\n4. Testing resize (adding 15 elements total):");
        for (int i = 6; i <= 15; i++) {
            da.add(i * 10);
        }
        System.out.println("   Final size: " + da.size());
        System.out.println("   Final array: " + da.toString());

        // Test 5: Error handling
        System.out.println("\n5. Testing error handling:");
        try {
            da.get(100); // This should throw exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println("   ✓ Correctly caught: " + e.getMessage());
        }

        System.out.println("\n=== All DynamicArray Tests Complete ===");
    }
}
