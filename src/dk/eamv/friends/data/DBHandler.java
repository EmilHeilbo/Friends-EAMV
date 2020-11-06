package dk.eamv.friends.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DBHandler<T> {
    public void commit() {
        SQLiteJDBC.connect();
        
    }
    /*
    SQLiteJDBC.connect();

    addElement()
    getElement()
    replaceElement()
    removeElement()

    sort<K>()

    commit()
    rollback()
    */
}
