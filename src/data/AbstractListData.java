package data;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListData<E> implements ListData<E> {

    protected List<E> data = new ArrayList<E>();
    protected String uri;
    
    public AbstractListData(String uri){
        this.uri = uri;
    }

    public AbstractListData(AbstractListData<E> data){
        this.data = data.data;
    }
    
    @Override
    public boolean add(E element) {
        return data.add(element);
    }

    @Override
    public E get(int index) {
        return data.get(index);
    }

    @Override
    public E set(int index, E element) {
        return data.set(index, element);
    }

    @Override
    public boolean remove(E element) {
        return data.remove(element);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void setURI(String uri){
        this.uri = uri;
    }

}