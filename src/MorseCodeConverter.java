import java.util.HashMap;
import java.util.Map;

public class MorseCodeConverter {
    private final Map<String, String> englishToMorse = new HashMap<>();
    private final Map<String, String> morseToEnglish = new HashMap<>();

    public MorseCodeConverter() {
        String[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."};

        for (int i = 0; i < letters.length; i++) {
            englishToMorse.put(String.valueOf(letters[i].charAt(0)), morseCodes[i]); // Engelsk bokstav till Morse
            morseToEnglish.put(morseCodes[i], String.valueOf(letters[i].charAt(0))); // morse till engelsk bokstav
        }
    }

    // Konverterar engelsk text till morsekod
    public String englishToMorse(String text) {
        String result = "";

        try {
            for (char c : text.toUpperCase().toCharArray()) {
                String letter = String.valueOf(c);
                if (letter.equals(" ")) {
                    continue;
                }
                result = result.concat(englishToMorse.get(letter)).concat(" ");
            }
        } catch (Exception e) {
            return "Fel: Ogiltigt tecken i engelsk text";
        }
        return result.trim();
    }

    // Konverter morsekod till engelsk text
    public String morseToEnglish(String morse) {
        if (morse.isEmpty()) {
            return "";
        }
        String result = "";

        try {
            for (String morseChar : morse.split(" ")) {
                result = result.concat(morseToEnglish.get(morseChar));
            }
        } catch (Exception e) {
            return "Fel: Ogiltig morsekod";
        }
        return result;
    }
}
