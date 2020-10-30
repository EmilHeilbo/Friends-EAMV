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

public class Container<T> {
    private List<T> list = new ArrayList<>();
    private String dbfile = null;

    public Container() {
        this.dbfile = null;
    }

    public Container(String dbfile) {
        this.dbfile = dbfile;
    }

    void commit() {}

    void rollback() {}
}