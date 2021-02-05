/**
 * @author Fatih OĞUZ
 */

import java.util.ArrayList;

/**
 * this class define data base
 * it iplements ITable interface
 *
 */
public class DataBaseTable implements ITable{
    /**
     * database table reference(multidimentional array list)
     */
    ArrayList<ArrayList<Object>> data;

    /**
     * constructor
     * @param data is multi dimentional array list
     */
    public DataBaseTable(ArrayList<ArrayList<Object>> data){
        this.data=data;
    }

    /**
     * get element in data arraylists
     * @param row is row for data base table
     * @param column is column for data base table
     * @return Object in table
     */
    public Object getElementAt(int row,int column){
        System.out.println("get element at");
        return data.get(row).get(column);
    }

    /**
     * update data in table
     * @param row is row for data base table
     * @param column is column for data base table
     * @param o is object . changed object
     */
    public void setElementAt(int row,int column ,Object o){
        System.out.println("SSSSet element at " + o);
        data.get(row).set(column,o);
    }

    /**
     * get number of rows in table
     * @return integer . NUmber of rowws
     */
    public int getNumberOfRows(){
        return this.data.size();
    }

    /**
     * get number of columns  in table
     * @return inteeger . Number of columns
     */
    public int getNumberOfColumns(){
        return this.data.get(0).size();
    }
}
