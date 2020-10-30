package data;

import java.io.IOException;

public interface ListData<E>{
    public boolean add(E element);
    public E get(int index);
    public E set(int index, E element);
    public boolean remove(E element);
    public int size();
    public void setURI(String uri);
    public void commit() throws IOException;
    public void rollback() throws IOException;
}
