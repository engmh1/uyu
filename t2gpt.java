import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        // Convert the integer array to a string array
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        
        // Sort the array with a custom comparator
        Arrays.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                // Sort in descending order by comparing the two concatenations
                return order2.compareTo(order1);
            }
        });
        
        // If the largest number is '0', return "0" (e.g., when all are zeros)
        if (numStrs[0].equals("0")) {
            return "0";
        }
        
        // Build the largest number string
        StringBuilder largestNumber = new StringBuilder();
        for (String numStr : numStrs) {
            largestNumber.append(numStr);
        }
        
        return largestNumber.toString();
    }
}
