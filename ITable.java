/**
 * @author Fatih OĞUZ
 */

/**
 * interface of database table
 * also proxy class implemented this interface
 */
public interface ITable{
    /**
     * get element for database table
     * @param row is row for data base table
     * @param column is column for data base table
     * @return Object . this object in database
     */
    public Object getElementAt(int row, int column);

    /**
     * update element in data base
     * @param row is row for data base table
     * @param column is column for data base table
     * @param o is object . changed object
     */
    public void setElementAt(int row, int column, Object o);

    /**
     * get number of rows in data base table
     * @return integer.number of rows
     */
    public int getNumberOfRows();

    /**
     * get number of columns in data base table
     * @return intger. number of columns
     */
    public int getNumberOfColumns();
}