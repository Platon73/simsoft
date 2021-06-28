import org.junit.Test;
import java.io.*;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class ParsingTest {

    @Test
    public void parsWebAdressa() {
        String data = "https://www.simbirsoft.com/";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        TreeMap<String, Integer> map1 = Parsing.parsWebAdressa();
        assertTrue(map1.size() > 0);
    }
}