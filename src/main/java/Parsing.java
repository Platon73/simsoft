import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Parsing {
    //получения адреса страницы, который вводит пользователь
    public static String gettingStringFromConsole() throws IOException {
        System.out.println("Введите адресс страницы для парсинга, например: https://www.simbirsoft.com/");
        while (true){
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            if (!str.isEmpty() && str.startsWith("https:") && str.length() > 7) {
                System.out.println("Строка введена верно " + str);
                in.close();
                return str;
            }
            System.out.println("Вы ввели -> "+ str + "\n" +
                    "В начале строки должно быть \"https:\" и количество символов не менее 8");
        }
    }

    //возвращает TreeMap слова=>количество повторений
    public static TreeMap<String, Integer> parsWebAdressa(){
        TreeMap<String, Integer> wordToCount = new TreeMap<>();
        try {
            System.out.println("Начался парсинг страницы");
            Document doc = Jsoup.connect(gettingStringFromConsole()).get(); //парсинг страницы
            String result = doc.text()
                    .replaceAll("[^A-Za-zА-Яа-я]", " ") //удалится все кроме букв
                    .replaceAll("[\\s]{2,}", " ")  //удалить лишние пробелы
                    .toUpperCase(); // все буквы в верхний регистр

            String[] words = result.split(" ");

            for (String word : words) {
                if (!wordToCount.containsKey(word)) {
                    wordToCount.put(word, 0);
                }
                wordToCount.put(word, wordToCount.get(word) + 1);
            }
            return wordToCount;
        } catch (IOException exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
            return wordToCount;
        }
    }
}

