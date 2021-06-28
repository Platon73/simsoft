import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class StringInFile {
    //из Parsing.parsWebAdressa получает TreeMap (слово=>количество повторений) и сохраняет в файл
    public static void writingToFile(){
        try(FileWriter writer = new FileWriter("parsFile.txt", false))
        {
            TreeMap<String, Integer> wordToCount = Parsing.parsWebAdressa();
            for (String word : wordToCount.keySet()){
                // запись всей строки
                writer.write(word + " - " + wordToCount.get(word));
                // запись по символам
                writer.append('\n');
            }
            writer.flush();
            System.out.println("Данные записаны в файл");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
