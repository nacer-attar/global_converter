package convert;

public class Octal {
    public static String convertToOctal(int value) {
        StringBuilder octal = new StringBuilder();

        while (value > 0) {
            int remainder = value % 8;
            octal.insert(0, remainder);
            value /= 8;
        }

        return octal.toString();
    }
}
