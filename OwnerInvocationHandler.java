/**
 * @author Fatih OĞUZ
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * this class implements InvocationHandler interface
 * and hold on databasetable reference
 *      override invoke method from InvocationHandler interface
 *      In this method, I put the set operation in priority order compared to the get operation.
 */
public class OwnerInvocationHandler implements InvocationHandler {
    /**
     * data base table reference
     */
    DataBaseTable dataBaseTable;

    /**
     * constructor
     * @param dataBaseTable is data base table
     */
    public OwnerInvocationHandler(DataBaseTable dataBaseTable){
        this.dataBaseTable=dataBaseTable;
    }

    /**
     * override invoke method from InvocationHandler interface
     * @param proxy is proxy class object
     * @param method is method from user
     * @param args parameter of methods
     * @return Object
     * @throws IllegalAccessException exception for illegal access exception
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws IllegalAccessException{
       try {
           if(method.getName().startsWith("set")){
               return method.invoke(dataBaseTable,args);
           }
           else if(method.getName().startsWith("get")){
               return method.invoke(dataBaseTable,args);
           }

       }catch (InvocationTargetException e){
           e.printStackTrace();
       }
        return null;
    }
}
