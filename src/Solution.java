public class Solution {
    public static void main(String[] args)
    {
        // Problem 1
        String input = "2344";
        int output = parse_int(input);
        System.out.printf("Input: %s --- Type of input: %s #===# Output: %d --- Type of output: %s\n", input,
                input.getClass().getSimpleName(), output, ((Object)output).getClass().getSimpleName());

        input = "-2021";
        output = parse_int(input);
        System.out.printf("Input: %s --- Type of input: %s #===# Output: %d --- Type of output: %s\n", input,
                input.getClass().getSimpleName(), output, ((Object)output).getClass().getSimpleName());

        input = "12a34";
        output = parse_int(input);
        System.out.printf("Input: %s --- Type of input: %s #===# Output: %d --- Type of output: %s\n", input,
                input.getClass().getSimpleName(), output, ((Object)output).getClass().getSimpleName());

        // Problem 2
        input = "This Is A Test4me";
        boolean hasInteger = containsInteger(input);
        System.out.printf("Input: %s #===# Output: %s\n", input, hasInteger);

        input = "IAMGOOD";
        hasInteger = containsInteger(input);
        System.out.printf("Input: %s #===# Output: %s\n", input, hasInteger);
    }

    /**
     * Problem 1
     * Convert String to Integer by converting the character to its ASCII value, and subtract with zero_ASCII value
     * Runtime: O(n) where n is length of the string
     * Space complexity: O(1) constant space
     * @param input: a given string
     * @return sum: -1 if string contains non-number character, integer otherwise
     */
    public static int parse_int(String input)
    {
        int zero_ascii = '0';
        boolean isNegative = false;
        int sum = 0;
        int i = 0;

        // Check if first character is a negative sign. If yes, mark this number is negative and start
        // looping through the number from index 1
        if (input.charAt(0) == '-')
        {
            isNegative = true;
            i++;
        }
        // Iterate through the rest of the string, convert into integer
        while(i < input.length())
        {
            int num_ascii = input.charAt(i);

            // Check if character is a number, return -1 if not a number
            // I'm using -1 as an error. So in case the input isn't a value that can be parsed to integer, -1 is
            // the assigned error value
            if (num_ascii < zero_ascii || num_ascii > '9')
                return -1;
            else
                sum = sum * 10 + (num_ascii - zero_ascii);
            i++;
        }
        return isNegative ? -sum : sum;
    }

    /**
     * Problem 2
     * Detect whether there is an integer in a given string
     * Runtime: O(n) where n is the length of the string
     * Space complexity: O(1) constant space
     * @param input: given string
     * @return true if integer found, false otherwise
     */
    public static boolean containsInteger(String input)
    {
        // Iterate through the entire string
        for (int i = 0; i < input.length(); i++)
        {
            int num_ascii = input.charAt(i);
            if (num_ascii >= '0' && num_ascii <= '9')
                return true;
        }
        return false;
    }
}
