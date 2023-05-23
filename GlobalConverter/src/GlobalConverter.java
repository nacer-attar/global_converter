import eh_gros.*;

public class GlobalConverter {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Veuillez fournir une chaîne de caractères et une base de traduction en arguments.");
            return;
        }

        String inputString = args[0];
        String translationBase = args[1];

        if (!isValidString(inputString)) {
            System.out.println("La chaîne de caractères saisie est invalide.");
            return;
        }

        if (!isValidBase(translationBase)) {
            System.out.println("La base de traduction saisie est invalide.");
            return;
        }

        String translatedString = translateString(inputString, translationBase);

        System.out.println("Chaîne de caractères traduite : " + translatedString); // résultat
    }

    private static boolean isValidString(String inputString) {
        return inputString.matches("[a-zA-Z0-9]+");
    }

    private static boolean isValidBase(String translationBase) {
        return translationBase.equals("octale") || translationBase.equals("hexadécimale")
                || translationBase.equals("binaire") || translationBase.equals("texte");
    }

    private static String translateString(String inputString, String translationBase) {
        StringBuilder translatedString = new StringBuilder();

        for (char c : inputString.toCharArray()) {
            int asciiValue = (int) c;

            String translatedChar;
            switch (translationBase) {
                case "octale":
                    translatedChar = Octale(asciiValue)
                break;
                case "hexadécimale":
                    translatedChar = convertToHexadecimal(asciiValue);
                    break;
                case "binaire":
                    translatedChar = convertToBinary(asciiValue);
                    break;
                case "texte":
                    translatedChar = String.valueOf(c);
                    break;
                default:
                    return ""; // Base invalide (ne devrait pas se produire)
            }

            translatedString.append(translatedChar).append(" ");
        }

        return translatedString.toString();
    }

    private static String convertToOctal(int value) {
        return Integer.toOctalString(value);
    }

    private static String convertToHexadecimal(int value) {
        return Integer.toHexString(value);
    }

    private static String convertToBinary(int value) {
        return Integer.toBinaryString(value);
    }
}
