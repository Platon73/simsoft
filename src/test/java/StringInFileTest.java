import org.junit.Test;

import java.io.ByteArrayInputStream;

public class StringInFileTest {

    @Test
    public void writingToFile(){
        String data = "https://www.simbirsoft.com/";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        StringInFile.writingToFile();
    }
}