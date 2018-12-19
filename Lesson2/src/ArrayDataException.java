/**
 * Created by Ivan Chaykin
 * Date: 18.12.2018
 * Time: 16:01
 */
public class ArrayDataException extends Exception {

    private final String incorrectValue;
    private final int rowIndex;
    private final int columnIndex;

    public ArrayDataException(String incorrectValue, int rowIndex, int columnIndex) {
        super("Symbol '" + incorrectValue + "' in row: " + rowIndex + ", column: " + columnIndex + " cannot be converted to number");
        this.incorrectValue = incorrectValue;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public String getIncorrectValue() {
        return incorrectValue;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
}
