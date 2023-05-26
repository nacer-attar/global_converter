package convert;

public class Hexadecimal {
    public static String convertToHexadecimal(int value) {
        StringBuilder hexadecimal = new StringBuilder();

        while (value > 0) {
            int remainder = value % 16;
            char hexDigit = (char) (remainder < 10 ? remainder + '0' : remainder + 'A' - 10);
            hexadecimal.insert(0, hexDigit);
            value /= 16;
        }

        return hexadecimal.toString();
    }
}
