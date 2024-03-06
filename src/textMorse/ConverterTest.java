package textMorse;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConverterTest {

    @Test
    public void testLettToMor(){
        //Arrange
        Converter convert = new Converter();
        String expected = "-*- ";
        //Act
        String testData = "k";
        String actual = convert.getMorse(testData);
        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testMorToLett(){
        Converter convert = new Converter();
        String expected = "c";

        String testData = "-*-*";
        String actual = convert.getEnglish(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void specialLetter(){
        Converter convert = new Converter();
        String expected = "Unrecognized input!";

        String testData = "ä";
        String actual = convert.getMorse(testData);

        assertEquals(expected,actual);
    }

    @Test
    public void capitalLetter(){
        Converter convert = new Converter();
        String expected = "*- ";

        String testData = "A";
        String actual = convert.getMorse(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void engWord(){
        Converter convert = new Converter();
        String expected = "-** --- --* ";

        String testData = "Dog";
        String actual = convert.getMorse(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void wordContainsSpecChar(){
        Converter convert = new Converter();
        String expected = "Unrecognized input!";

        String testData = "förskola";
        String actual = convert.getMorse(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void englishWord(){
        Converter convert = new Converter();
        String expected = "**** * -*-- ";

        String testData = "hey";
        String actual = convert.getMorse(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void testNumber(){
        Converter convert = new Converter();
        String expected = "*---- ";

        String testData = "1";
        String actual = convert.getMorse(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void morseWord(){
        Converter convert = new Converter();
        String expected = "egg";

        String testData = "* --* --*";
        String actual = convert.getEnglish(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void wordNumCombo(){
        Converter convert = new Converter();
        String expected = "**--- * --* --* *** ";

        String testData = "2eggs";
        String actual = convert.getMorse(testData);

        assertEquals(expected, actual);

    }


}
