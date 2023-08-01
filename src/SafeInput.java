import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    // method 2

    /**
     * Prompts the user to input any integer.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return an integer value entered by the user
     */
    public static int getInt(Scanner pipe, String prompt) {
        int value = 0;
        boolean isValidInput = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                isValidInput = true;
            } else {
                String trash = pipe.nextLine(); // Read and discard invalid input
                System.out.println("Invalid input. Please enter an integer.");
            }
        } while (!isValidInput);

        pipe.nextLine(); // Clear the newline character from the input buffer

        return value;
    }



    //method 3
    /**
     * Prompts the user to input any double value.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a double value entered by the user
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double value = 0.0;
        boolean isValidInput = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                isValidInput = true;
            } else {
                String trash = pipe.nextLine(); // Read and discard invalid input
                System.out.println("Invalid input. Please enter a double value.");
            }
        } while (!isValidInput);

        pipe.nextLine(); // Clear the newline character from the input buffer

        return value;
    }



    // mthod 4
    /**
     * Prompts the user to input an integer within a specified inclusive range.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user (should not include the [lo - hi] display)
     * @param low    the low value for the input range
     * @param high   the high value for the input range
     * @return an integer value entered by the user within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int value = 0;
        boolean isValidInput = false;

        String fullPrompt = prompt + " [" + low + " - " + high + "]";
        do {
            System.out.print("\n" + fullPrompt + ": ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                if (value >= low && value <= high) {
                    isValidInput = true;
                } else {
                    System.out.println("Invalid input. Please enter an integer within the specified range.");
                }
            } else {
                String trash = pipe.nextLine(); // Read and discard invalid input
                System.out.println("Invalid input. Please enter an integer.");
            }
        } while (!isValidInput);

        pipe.nextLine(); // Clear the newline character from the input buffer

        return value;
    }
    // method5


    /**
     * Prompts the user to input a double value within a specified inclusive range.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user (should not include the [lo - hi] display)
     * @param low    the low value for the input range
     * @param high   the high value for the input range
     * @return a double value entered by the user within the specified range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double value = 0.0;
        boolean isValidInput = false;

        String fullPrompt = prompt + " [" + low + " - " + high + "]";
        do {
            System.out.print("\n" + fullPrompt + ": ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                if (value >= low && value <= high) {
                    isValidInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a double value within the specified range.");
                }
            } else {
                String trash = pipe.nextLine(); // Read and discard invalid input
                System.out.println("Invalid input. Please enter a double value.");
            }
        } while (!isValidInput);

        pipe.nextLine(); // Clear the newline character from the input buffer

        return value;
    }
    // method6

    /**
     * Gets a Yes or No confirmation from the user and returns true for Yes and false for No.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return true if the user enters Yes (Y or y), false if the user enters No (N or n)
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean isValidInput = false;

        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();
            if (response.equals("Y") || response.equals("N")) {
                isValidInput = true;
            } else {
                System.out.println("Invalid input. Please enter Y for Yes or N for No.");
            }
        } while (!isValidInput);

        return response.equals("Y");
    }

    // method7
    /**
     * Prompts the user to input a string that matches a regex pattern.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param regEx  the regex pattern in Java String format to use for matching
     * @return a string entered by the user that matches the regex pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String value = "";
        boolean isValidInput = false;

        do {
            System.out.print("\n" + prompt + ": ");
            value = pipe.nextLine();
            if (value.matches(regEx)) {
                isValidInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid string that matches the regex pattern.");
            }
        } while (!isValidInput);

        return value;


    }


        /**
         * Creates a pretty header with a message centered within it.
         *
         * @param msg the message to be centered within the header
         */
        public static void prettyHeader(String msg) {
            int headerWidth = 60;
            int messageWidth = msg.length();

            // Calculate the number of stars needed on each side of the message
            int starsOnEachSide = (headerWidth - messageWidth - 2) / 2;

            // Print the top line of stars
            for (int i = 0; i < headerWidth; i++) {
                System.out.print("*");
            }
            System.out.println();

            // Print the second line with the centered message
            System.out.print("***");
            for (int i = 0; i < starsOnEachSide; i++) {
                System.out.print(" ");
            }
            System.out.print(msg);
            for (int i = 0; i < starsOnEachSide; i++) {
                System.out.print(" ");
            }
            // Add an extra space if the message width is odd
            if (messageWidth % 2 != 0) {
                System.out.print(" ");
            }
            System.out.println("***");

            // Print the bottom line of stars
            for (int i = 0; i < headerWidth; i++) {
                System.out.print("*");
            }
            System.out.println();
    }

}











