import java.util.Scanner;

public class MorseMain {
    public static void main(String[] args) {
        MorseCodeConverter converter = new MorseCodeConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Välkommen till Morse-kod översättaren!");

        while (true) {
            System.out.println("1: Text till Morse");
            System.out.println("2: Morse till Text");
            System.out.println("3: Avsluta");
            System.out.print("Välj ett alternativ (1|2|3): ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Konsumera ny rad
            } catch (Exception e) {
                System.out.println("Du har matat in fel tecken. Mata in en siffra!");
                System.out.println();
                scanner.nextLine();
                continue;
            }

            if (choice == 1) {
                System.out.print("Ange engelsk text: ");
                String text = scanner.nextLine();
                System.out.println("morsekod: " + converter.englishToMorse(text));
                System.out.println();
            } else if (choice == 2) {
                System.out.print("Ange morsekod (separata mellanslag): ");
                String morse = scanner.nextLine();
                System.out.println("Engelsk text: " + converter.morseToEnglish(morse));
                System.out.println();
            } else if (choice == 3) {
                System.out.print("Avslut!");
                scanner.close();
                break;
            }
            else {
                System.out.println("Ogiltigt val! välj 1 eller 2");
            }
        }
    }
}









