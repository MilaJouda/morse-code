import java.util.Scanner;
public class MorseMain {


    public static void main(String[] args) {
        MorseCodeConverter converter = new MorseCodeConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Välkommen till Morse-kod översättaren!");
        System.out.println("1: Text till Morse");
        System.out.println("2: Morse till Text");
        System.out.println();
        System.out.print("Välj ett alternativ (1/2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Konsumera ny rad

        if (choice == 1) {
            System.out.print("Ange engelsk text: ");
            String text = scanner.nextLine();
            System.out.println(" morsekod:" + converter.englishToMorse(text));
        } else if (choice == 2) {
            System.out.println("Ange morsekod ( separata mellanslag):");
            String morse = scanner.nextLine();
            System.out.println("Engelsk text:" + converter.morseToEnglish(morse));
        } else {
            System.out.println("Ogiltig val! välj 1 eller 2.");
        }
        scanner.close();

    }

}









