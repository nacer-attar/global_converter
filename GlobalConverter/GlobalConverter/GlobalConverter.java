import package.convert.*;
import java.util.Scanner;

public class GlobalConverter {
    public static void main(String[] args) {
        String inputString;
        String translationBase;

        if (args.length > 0) {
            // Utiliser les arguments fournis
            inputString = args[1];
            translationBase = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);

            // Saisie de la chaîne de caractères à traduire
            System.out.print("Saisissez une chaîne de caractères à traduire : ");
            inputString = scanner.nextLine();

            // Saisie de la base de traduction souhaitée
            translationBase = getTranslationBase(scanner);

            scanner.close();
        }

        // Vérification de la validité de la chaîne de caractères
        if (!isValidString(inputString)) {
            System.out.println("La chaîne de caractères saisie est invalide.");
            return;
        }

        // Traduction de la chaîne de caractères dans la base spécifiée
        String translatedString = translateString(inputString, translationBase);

        // Affichage de la chaîne de caractères traduite
        System.out.println("Chaîne de caractères traduite : " + translatedString);
    }

    private static boolean isValidString(String inputString) {
        // Vérifie si la chaîne de caractères ne contient que des lettres et des chiffres
        return inputString.matches("[a-zA-Z0-9]+");
    }

    private static String getTranslationBase(Scanner scanner) {
        System.out.print("Choisissez la base de traduction (hexadecimal/h, octal/o, decimal/d, binary/b, text/t) : ");
        String translationBase = scanner.nextLine().toLowerCase();

        switch (translationBase) {
            case "hexadecimal":
            case "-h":
                return "hexadecimal";
            case "octal":
            case "-o":
                return "octal";
            case "decimal":
            case "-d":
                return "decimal";
            case "binary":
            case "-b":
                return "binary";
            case "text":
            case "-t":
                return "text";
            default:
                return null; // Base invalide
        }
    }

    private static String translateString(String inputString, String translationBase) {
        StringBuilder translatedString = new StringBuilder();

        for (char c : inputString.toCharArray()) {
            int asciiValue = (int) c;

            String translatedChar;
            switch (translationBase) {
                case "hexadecimal":
                    translatedChar = convertToHexadecimal(asciiValue);
                    break;
                case "octal":
                    translatedChar = convertToOctal(asciiValue);
                    break;
                case "decimal":
                    translatedChar = convertToDecimal(asciiValue);
                    break;
                case "binary":
                    translatedChar = convertToBinary(asciiValue);
                    break;
                case "text":
                    translatedChar = String.valueOf(c);
                    break;
                default:
                    return ""; // Base invalide (ne devrait pas se produire)
            }

            translatedString.append(translatedChar).append(" ");
        }

        return translatedString.toString();
    }

    private static String convertToHexadecimal(int value) {
        StringBuilder hexadecimal = new StringBuilder();

        while (value > 0) {
            int remainder = value % 16;
            char hexDigit = (char) (remainder < 10 ? remainder + '0' : remainder + 'A' - 10);
            hexadecimal.insert(0, hexDigit);
            value /= 16;
        }

        return hexadecimal.toString();
    }

    private static String convertToOctal(int value) {
        StringBuilder octal = new StringBuilder();

        while (value > 0) {
            int remainder = value % 8;
            octal.insert(0, remainder);
            value /= 8;
        }

        return octal.toString();
    }

    private static String convertToDecimal(int value) {
        // Convertit la valeur en une chaîne de caractères représentant sa valeur décimale
        return String.valueOf(value);
    }

    private static String convertToBinary(int value) {
        StringBuilder binary = new StringBuilder();

        while (value > 0) {
            int remainder = value % 2;
            binary.insert(0, remainder);
            value /= 2;
        }

        return binary.toString();
    }
}
