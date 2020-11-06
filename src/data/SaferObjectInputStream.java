package data;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import logic.Friend;
import logic.Group;
import logic.Interest;

public class SaferObjectInputStream extends ObjectInputStream {
    private static final Set<String> whiteListedClasses = new HashSet<>(Arrays.asList(
            Friend.class.getName(),
            ArrayList.class.getName(),
            Group.class.getName(),
            Enum.class.getName(),
            TreeSet.class.getName(),
            Interest.class.getName()
    ));

    public SaferObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass input) throws IOException, ClassNotFoundException {
        if (!whiteListedClasses.contains(input.getName()))
            throw new InvalidClassException(input.getName(), "Unsupported class");
        return super.resolveClass(input);
    }
}
