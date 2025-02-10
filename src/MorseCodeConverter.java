package Automation.morscode;

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
            englishToMorse.put(String.valueOf(letters[i].charAt(0)), morseCodes[i]); // Engelsk bokstav  till Morse
            morseToEnglish.put(morseCodes[i], String.valueOf(letters[i].charAt(0))); // morse till engelsk bokstav
        }

    }

    // konverterar engelsk text till mordekod
    public String englishToMorse(String text) {
        String result = "";
        try {
            for (char c : text.toUpperCase().toCharArray()) {
                String letters = String.valueOf(c);
                if (englishToMorse.containsKey(letters)) {
                    result = result.concat(englishToMorse.get(letters)).concat(" ");

                } else {
                    return "Fel: Ogiltigt tecken i engelsk text -" + letters;
                }
            }
        } catch (Exception e) {
            return "Ett fel uppstod vid konvertering från engelska text till morsekod.";
        }
        return result.toString().trim();
    }

    // konverter morsekod till engelsk text.
    public String morseToEnglish(String morse) {
        if (morse.isEmpty()) {
            return "";
        }
        String result = "";

        try {
            for (String morseChar : morse.split(" ")) {
                if (morseToEnglish.containsKey(morseChar)) {
                    result = result.concat(morseToEnglish.get(morseChar));
                } else {
                    return "Fel: Ogiltigt morsekod - " + morseChar;
                }
            }
        } catch (Exception e) {
            return " Ett fel uppstod vid konvertering från morsekod till engelsk text.";

        }
        return result.toString();
    }
}
