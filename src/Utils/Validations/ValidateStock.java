package Utils.Validations;

public class ValidateStock {
    // Method to validate stock input (only integers allowed)
    public static boolean VStock(String stock) {
        try {
            // Null or empty check
            if (stock == null || stock.isEmpty()) return false;

            // Must contain only digits (no decimals allowed)
            if (!stock.matches("\\d+")) {
                return false;
            }

            // Try to parse to integer
            Integer.parseInt(stock);
            return true;
        } catch (NumberFormatException error) {
            return false;
        }
    }
}
