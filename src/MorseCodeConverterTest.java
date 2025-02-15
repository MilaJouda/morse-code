import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MorseCodeConverterTest {

    @Test
    public void testTextToMorse() {
       MorseCodeConverter converter = new MorseCodeConverter();
       assertEquals(".... . .-.. .-.. ---", converter.englishToMorse("HELLO"));
    }

    @Test
    public void testMorseToText() {
        MorseCodeConverter converter = new MorseCodeConverter();
        assertEquals("HELLO", converter.morseToEnglish(".... . .-.. .-.. ---"));
    }

    @Test
    public void testEmptyInput() {
        MorseCodeConverter converter = new MorseCodeConverter();
        assertEquals("", converter.englishToMorse(""));
        assertEquals("", converter.morseToEnglish(""));
    }

    @Test
    public void testEnglishToMorseInvalidCharacter(){
        MorseCodeConverter converter = new MorseCodeConverter();
        assertEquals("Fel: Ogiltigt tecken i engelsk text", converter.englishToMorse("HELL11"));
    }

   @Test
    public void testMorseToEnglishInvalidMorseCode(){
       MorseCodeConverter converter = new MorseCodeConverter();
       assertEquals("Fel: Ogiltig morsekod", converter.morseToEnglish(".... . .-.. .-.. --- -----"));
   }
}
