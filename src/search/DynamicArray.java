// DynamicArray.java
// Custom implementation of a dynamic array (similar to ArrayList)

public class DynamicArray {
    private int[] array;      // Internal array to store elements
    private int size;         // Number of elements actually stored
    private static final int INITIAL_CAPACITY = 10;  // Starting size

    // Constructor - creates empty dynamic array
    public DynamicArray() {
        array = new int[INITIAL_CAPACITY];
        size = 0;
    }

    // Constructor with custom initial capacity
    public DynamicArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        array = new int[initialCapacity];
        size = 0;
    }

    // 1. ADD method - adds an element to the end
    public void add(int value) {
        // If array is full, resize it
        if (size == array.length) {
            resize();
        }
        array[size] = value;
        size++;
    }

    // 2. GET method - returns element at specific index
    public int get(int index) {
        checkIndex(index);
        return array[index];
    }

    // 3. SIZE method - returns number of elements
    public int size() {
        return size;
    }

    // 4. IS EMPTY method - checks if array has no elements
    public boolean isEmpty() {
        return size == 0;
    }

    // 5. RESIZE method - doubles the array capacity when full (PRIVATE HELPER)
    private void resize() {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];

        // Copy all elements to new array
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
        System.out.println("Resized array from " + (newCapacity / 2) + " to " + newCapacity);
    }

    // 6. CHECK INDEX method - validates index bounds (PRIVATE HELPER)
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }

    // 7. Optional: TO STRING method - for easy printing
    @Override
    public String toString() {
        if (isEmpty()) {
            return "DynamicArray[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("DynamicArray[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
