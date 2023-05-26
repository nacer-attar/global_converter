package convert;

public class Binary {
    public static String convertToBinary(int value) {
        StringBuilder binary = new StringBuilder();

        while (value > 0) {
            int remainder = value % 2;
            binary.insert(0, remainder);
            value /= 2;
        }

        return binary.toString();
}
