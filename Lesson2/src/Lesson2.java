import java.util.Arrays;

/**
 * Created by Ivan Chaykin
 * Date: 18.12.2018
 * Time: 13:17
 */
public class Lesson2 {
    private static final int SIZE = 4;

//  1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
//      при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//
//  2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
//      Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
//      должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
//
//  3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
//      MyArrayDataException, и вывести результат расчета.

    public static void main(String[] args) {

//      Array String[4][4]
        String[][] strArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"4", "9", "10", "11"},
                {"12", "13", "14", "15"}};

//      Wrong array String[5][4]
        String[][] wrongArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"A", "9", "10", "11"},
                {"12", "13", "14", "15"},
                {"16", "17", "18", "19"}};

//      Wrong array String[4][5]
        String[][] wrongArray1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"7", "9", "10", "11", "88"},
                {"12", "13", "14", "15"}};

//      Wrong array String[4][4] with char
        String[][] wrongArray2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"7", "9", "A", "11"},
                {"12", "13", "14", "15"}};

        try {
            System.out.println("Result: " + calculate(strArray));
        } catch (ArraySizeException | ArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int calculate(String[][] strArray) throws ArraySizeException, ArrayDataException {

        int result = 0;

        if (strArray.length != SIZE){

            throw new ArraySizeException("Wrong number of rows in array");
        } else {

            for (int rowIndex = 0; rowIndex < strArray.length; rowIndex++) {

                if (strArray[rowIndex].length != SIZE) {

                    throw new ArraySizeException("Wrong number of columns in array");
                } else {

                    for (int columnIndex = 0; columnIndex < strArray[rowIndex].length; columnIndex++) {

                        try {
                            result += Integer.valueOf(strArray[rowIndex][columnIndex]);
                        } catch (NumberFormatException e) {

                            throw new ArrayDataException(strArray[rowIndex][columnIndex], rowIndex, columnIndex);
                        }
                    }
                }
            }
        }
        return result;
    }
}
