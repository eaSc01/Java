
public interface Queue<T> {

    int size();

    void insert(T e);

    T delete();

    T first();

    boolean isEmpty();

}