public class Statistics {
    private static int numberOfComparisons;

    /**
     * Reset all current statistics
     */
    public static void resetStatistics() {
        numberOfComparisons= 0;
    }

    /**
     * Reset the current number of comparisons
     */
    public static void resetNumberOfComparisons() {
        numberOfComparisons= 0;
    }

    /**
     * Increase the number of comparisons by 1
     */
    public static boolean increaseNumberOfComparisons() {
        numberOfComparisons++;
        return true;
    }

    /**
     * Increase the number of comparisons by some amount
     * @param increment
     * The amount of increment
     */
    public static void increaseNumberOfComparisons(int increment) {
        numberOfComparisons= numberOfComparisons+ increment;
    }

    /**
     * Get the number of comparisons
     * @return The current amount of comparisons made to this moment
     */
    public static int getNumberOfComparisons() {
        return numberOfComparisons;
    }
}
