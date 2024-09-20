import java.util.*;
class HelloWorld {
     public static int[] extractIntegers(String input) {
        // Split the input string by spaces
        //String[] parts = input.split(" ");
        String[] parts = input.split("[^\\d-]+");
        // List to store integers found in the string
        List<Integer> numbers = new ArrayList<>();
        
        // Loop through each part of the split string
        for (String part : parts) {
            System.out.println(part);
           if (!part.isEmpty()) { // Check if part is not empty
                try {
                    // Try to parse the part as an integer
                    int number = Integer.parseInt(part);
                    numbers.add(number); // If successful, add to list
                } catch (NumberFormatException e) {
                    // If it's not a number, ignore it and continue
                    continue;
                }
            }
        }

        // Convert the list to an array
        int[] result = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
             System.out.println(result[i]);
        }
        
        return result;
    }

    public static void main(String[] args) {
        String input = "The numbers are 45 , -22 , and 100 in this string.";
        int[] extractedNumbers = extractIntegers(input);
        
        System.out.println("Extracted integers: " + Arrays.toString(extractedNumbers));
    }
}