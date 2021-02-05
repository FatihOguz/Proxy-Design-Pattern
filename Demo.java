/**
 * @author Fatih OĞUZ
 */
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Random;


/**
 * this class run threads for getElementAt and setElementAt methods
 * threads access these 2 method via proxy
 */
public class Demo implements Runnable {
    /**
     * data base table
     */
    ArrayList<ArrayList<Object>> data = getData();
    //System.out.println(data);
    /**
     * data base
     */
    DataBaseTable dataBaseTable = new DataBaseTable(data);
    /**
     * proxy class
     */
    ITable dataBaseTableProxy = getOwnerProxy(dataBaseTable);
    //DataBaseProxy dataBaseProxy = new DataBaseProxy(dataBaseTable);
    /**
     * random class
     */
    Random random = new Random();

    /**
     * create data base table
     * this method create by randomly integer
     * @return multi dimentional ArrayList
     */
    public static ArrayList<ArrayList<Object>> getData(){

        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>(10);

        Random random = new Random();
        for(int i=0;i<10;i++){
            data.add(new ArrayList<>());
            for (int j=0;j<10;j++){
                data.get(i).add(random.nextInt(100));
            }
        }

        return data;
    }

    /**
     * take proxy class from get owner proxy method
     * @param dataBaseTable is data base table
     * @return Itable interface. this interface collective area for proxy and data base table
     */
    ITable getOwnerProxy(DataBaseTable dataBaseTable){
        return (ITable) Proxy.newProxyInstance(
                dataBaseTable.getClass().getClassLoader(),
                dataBaseTable.getClass().getInterfaces(),
                new OwnerInvocationHandler(dataBaseTable));
    }

    /**
     * threads run method
     */
    @Override
    public void run() {
        System.out.println(dataBaseTableProxy.getElementAt(3,5));
        dataBaseTableProxy.setElementAt(3,5,this.random.nextInt(100));
        System.out.println(dataBaseTableProxy.getElementAt(3,5));
    }

    /**
     * this method man method
     * it create threads and run
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Demo obj = new Demo();
        Thread thread = new Thread(obj);
        thread.start();
        Thread thread1 = new Thread(obj);
        thread1.start();
        Thread thread2 = new Thread(obj);
        thread2.start();
        Thread thread3 = new Thread(obj);
        thread3.start();
        Thread thread4 = new Thread(obj);
        thread4.start();
    }
}
