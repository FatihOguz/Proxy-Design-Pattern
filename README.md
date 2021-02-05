# Proxy-Design-Pattern
QUESTION:
Your company has an old software library providing a class
DataBaseTable, but this class does not provide the capability to allow clients to lock individual table
rows. Thus, two clients might end up modifying the same row simultaneously, and we don’t want
that happening. Moreover, you do not have the source code for this class library, but you have the
complete documentation and know about the interface ITable implemented by the DataBaseTable
class.
public interface ITable{
public Object getElementAt(int row, int column);
public void setElementAt(int row, int column, Object o);
public int getNumberOfRows();
public int getNumberOfColumns();
}
a) Use the proxy design pattern in order to equip the DataBaseTable class’ objects with
synchronization capability. Make sure no reader thread calls getElementAt while a writer thread
is executing setElementAt. Provide your source code and class diagram. (15 points)
b) Clients are unhappy with your DataBaseTable synchronization proxy. There are too many
getElementAt calls that keep “locking” the Table’s rows, and this way the clients that need to
modify them using setElementAt wait too long to acquire the table lock. Solve this problem and
design a new synchronization solution that prioritizes writers of DataBaseTable more than readers
in terms of table row access. (20 points)



REPORT:


I made the database with multidimentional array list.I kept rows with lock array in my database class.
With this array, I have provided the synchronization between methods.

When we look at the last parts of the printouts. After the set was made with data 42, the request for the
get operation came before that operation was completed, and data 26 was made with another set.finally,
the get operation worked incorrectly.
The reason is that there is no synchronized keyword seen in the photo.lock array helps to lock related
row



After the synchronization process, it is said that there is accumulation from the customer due to the
intensity of the get method.



When looking at the invocation of threads and the get transaction density in the last two photos, this is
true.
To get rid of this problem, I aim to solve this problem by prioritizing methods with invocationHandler.




After the InvocationHandler operation, it is seen in the photo that the methods are called with the
operation order in the run method.
Of course, due to the thread operation, this ordering does not always occur exactly as desired. But
every time I run the code where the set method has priority, it is obvious that the get methods do not
stack like in partA.
