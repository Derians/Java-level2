/**
 * Created by Ivan Chaykin
 * Date: 18.12.2018
 * Time: 16:01
 */
public class ArrayDataException extends Exception {

    public ArrayDataException(String str, int rowIndex, int columnIndex) {
        System.err.println("Symbol '" + str + "' in row: " + rowIndex + ", column: " + columnIndex + " cannot be converted to number");
    }
}
