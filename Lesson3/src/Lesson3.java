import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ivan Chaykin
 * Date: 19.12.2018
 * Time: 17:05
 */
public class Lesson3 {

//    1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//      Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//      Посчитать сколько раз встречается каждое слово.

//    2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
//      В этот телефонный справочник с помощью метода add() можно добавлять записи.
//      С помощью метода get() искать номер телефона по фамилии.
//      Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//      тогда при запросе такой фамилии должны выводиться все телефоны.

    public static void main(String[] args) {

        String[] fruits = {
          "Абрикос", "Авокадо", "Гранат", "Груша", "Киви",
          "Лимон", "Мандарин", "Папайя", "Фейхоа", "Абрикос",
          "Киви", "Гранат", "Папайя", "Груша", "Гранат",
          "Авокадо", "Абрикос", "Груша", "Абрикос", "Лимон"
        };

        calcFruits(fruits);

    }

    private static void calcFruits(String[] fruits) {
        Map<String, Integer> fruitsMap = new TreeMap<>();

        for (String fruit: fruits) {

            if (fruitsMap.containsKey(fruit)) {
                fruitsMap.put(fruit, fruitsMap.get(fruit) + 1);
            } else {
                fruitsMap.put(fruit, 1);
            }
        }
        System.out.println(fruitsMap.toString());

    }

}
