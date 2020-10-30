package logic;

import java.io.Serializable;
import java.util.Set;

public class Friend implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int id;
    private int key;
    private String name, email, mobile;
    private Group group;
    private Set<Interest> interests;

    public Friend(String name, String email, String mobile, Group group, Set<Interest> interests) {
        this.name = name;
        this.email = email;
        this.group = group;
        this.interests = interests;
        this.key = id++;
    }

    public int key() {
        return key;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public String mobile() {
        return mobile;
    }

    public Group group() {
        return group;
    }

    public Set<Interest> interests() {
        return interests;
    }
}