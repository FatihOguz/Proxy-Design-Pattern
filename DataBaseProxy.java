/**
 * @author Fatih OĞUZ
 */
/**
 * this class proxy class for data base
 *
 * if user want to ITable method
 *          he/she say this method to this class
 *
 * this class hold on databasetable reference and lock multi dimentional array
 * it do operations by databaseTable reference
 *
 * Lock variable for synchronized.
 * Since the common point of all operations to be synchronized must be the same row,
 * this variable is used in the synchronization of operations by locking the row.
 *
 *
 * As a result, while doing a user set operation,
 * it prevents another user doing the get operation from getting incorrect results.
 */
public class DataBaseProxy implements ITable{

    /**
     * data base reference
     */
    DataBaseTable dataBaseTable;

    /**
     * for synchronized lock
     */
    Integer[][] locks;

    /**
     * COnstructor
     * @param toLock is lock array for synchronized
     */
    public DataBaseProxy(DataBaseTable toLock){
        this.dataBaseTable = toLock;
        locks = new Integer[toLock.getNumberOfRows()][toLock.getNumberOfColumns()];
        for(int row=0;row<toLock.getNumberOfRows();row++){
            for (int j=0;j< toLock.getNumberOfColumns();j++){
                locks[row][j]= (Integer) this.dataBaseTable.getElementAt(row,j);
            }
        }

    }

    /**
     * print lock array
     * @param lock is lock array
     */
    public void printLock(Integer[] lock){
        for (int i=0;i<lock.length;i++){
            System.out.print(lock[i] + " ");
        }
    }

    /**
     * get element in data base table
     * @param row is row for data base table
     * @param column is column for data base table
     * @return Object element in table
     */
    @Override
    public Object getElementAt(int row, int column) {
        synchronized (locks[row]){
            System.out.print("get element row ");
            return dataBaseTable.getElementAt(row,column);
        }

    }

    /**
     * set element in data base table
     * @param row is row for data base table
     * @param column is column for data base table
     * @param o is object . changed object
     */
    @Override
    public void setElementAt(int row, int column, Object o) {
        synchronized(locks[row]){
            System.out.println("set element row :"+ row + " "+  "object " +  o + "-->" );

            locks[row][column]= (Integer) o;
            dataBaseTable.setElementAt(row,column,o);
        }
    }

    /**
     * get number of rows in data base table
     * @return integer . number of rows
     */
    @Override
    public int getNumberOfRows() {
        return dataBaseTable.getNumberOfRows();
    }

    /**
     * get number of columns in data base table
     * @return integer . number of columns
     */
    @Override
    public int getNumberOfColumns() {
        return dataBaseTable.getNumberOfColumns();
    }
}
