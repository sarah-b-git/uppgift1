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
        String actual = convert.findMatch(testData);
        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testMorToLett(){
        Converter convert = new Converter();
        String expected = "c";

        String testData = "-*-*";
        String actual = convert.findMatch(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void specialLetter(){
        Converter convert = new Converter();
        String expected = "Unrecognized input!";

        String testData = "ä";
        String actual = convert.findMatch(testData);

        assertEquals(expected,actual);
    }

    @Test
    public void capitalLetter(){
        Converter convert = new Converter();
        String expected = "*- ";

        String testData = "A";
        String actual = convert.findMatch(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void engWord(){
        Converter convert = new Converter();
        String expected = "-** --- --* ";

        String testData = "Dog";
        String actual = convert.findMatch(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void wordContainsSpecChar(){
        Converter convert = new Converter();
        String expected = "Unrecognized input!";

        String testData = "förskola";
        String actual = convert.findMatch(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void morseWord(){
        Converter convert = new Converter();
        String expected = "**** * -*-- ";

        String testData = "hey";
        String actual = convert.findMatch(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void blendedEngMor(){
        Converter convert = new Converter();
    }

}
