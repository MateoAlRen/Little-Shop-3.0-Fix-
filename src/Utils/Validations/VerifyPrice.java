package Utils.Validations;

public class VerifyPrice {
    // Method to check if the price input is valid
    public static boolean Verify(String price) {
        try {
            // Return false if null or empty
            if (price == null || price.isEmpty()) return false;

            // Regex check: only numbers or decimals allowed
            if (!price.matches("\\d+(\\.\\d+)?")) {
                return false;
            }

            // Try to parse to Double to ensure validity
            Double.parseDouble(price);
            return true;

        } catch (NumberFormatException ex) {
            // Return false if parsing fails
            return false;
        }
    }
}
