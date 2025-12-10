cat > src/RestaurantSystem.java << 'END'
// RestaurantSystem.java - Fixed version
// Student: mohantiye

import java.util.Scanner;
import java.util.Random;

public class RestaurantSystem {
    
    private static String[] menuItems = {
        "Burger", "Pizza", "Pasta", "Salad", "Soup",
        "Steak", "Chicken", "Fish", "Rice", "Fries"
    };
    
    private static double[] menuPrices = {
        12.99, 15.99, 14.50, 8.99, 6.99,
        24.99, 16.99, 18.99, 9.99, 4.99
    };
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("================================");
        System.out.println("   SUYA & CHILL RESTAURANT      ");
        System.out.println("================================");
        
        System.out.println("\n1. Search Menu Item");
        System.out.println("2. Test Search Algorithms");
        System.out.println("3. Exit");
        System.out.print("Choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice == 1) {
            searchMenuItem(scanner);
        } else if (choice == 2) {
            testAlgorithms();
        }
        
        System.out.println("\nGoodbye!");
        scanner.close();
    }
    
    private static void searchMenuItem(Scanner scanner) {
        System.out.println("\n=== MENU ===");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.printf("%d. %-10s $%.2f\n", i+1, menuItems[i], menuPrices[i]);
        }
        
        System.out.print("\nEnter item to search: ");
        String target = scanner.nextLine();
        
        // Linear Search
        System.out.println("\n--- Linear Search ---");
        long start = System.nanoTime();
        int linearResult = -1;
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i].equalsIgnoreCase(target)) {
                linearResult = i;
                break;
            }
        }
        long linearTime = System.nanoTime() - start;
        
        if (linearResult != -1) {
            System.out.printf("Found: %s ($%.2f) in %d ns\n", 
                menuItems[linearResult], menuPrices[linearResult], linearTime);
        } else {
            System.out.println("Not found");
        }
        
        // Binary Search - FIXED
        System.out.println("\n--- Binary Search ---");
        String[] sorted = new String[menuItems.length];
        for (int i = 0; i < menuItems.length; i++) {
            sorted[i] = menuItems[i].toLowerCase();
        }
        java.util.Arrays.sort(sorted);
        
        start = System.nanoTime();
        int binaryResult = java.util.Arrays.binarySearch(sorted, target.toLowerCase());
        long binaryTime = System.nanoTime() - start;
        
        if (binaryResult >= 0) {
            String foundItem = "";
            double price = 0;
            for (int i = 0; i < menuItems.length; i++) {
                if (menuItems[i].equalsIgnoreCase(target)) {
                    foundItem = menuItems[i];
                    price = menuPrices[i];
                    break;
                }
            }
            System.out.printf("Found: %s ($%.2f) in %d ns\n", foundItem, price, binaryTime);
            
            if (linearResult != -1) {
                System.out.printf("Binary Search was %.1fx faster\n", 
                    (double)linearTime / binaryTime);
            }
        } else {
            System.out.println("Not found");
        }
    }
    
    private static void testAlgorithms() {
        System.out.println("\n=== ALGORITHM TEST ===");
        
        int[] sizes = {100, 1000, 10000};
        
        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) arr[i] = i * 10;
            
            long start = System.nanoTime();
            SearchAlgorithms.linearSearch(arr, size/2 * 10);
            long linearTime = System.nanoTime() - start;
            
            start = System.nanoTime();
            SearchAlgorithms.binarySearch(arr, size/2 * 10);
            long binaryTime = System.nanoTime() - start;
            
            System.out.printf("n=%d: Linear=%dns, Binary=%dns (%.1fx faster)\n",
                size, linearTime, binaryTime, (double)linearTime/Math.max(binaryTime, 1));
        }
        System.out.println("\nThis shows O(n) vs O(log n) scaling!");
    }
}
END
