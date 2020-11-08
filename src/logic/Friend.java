package logic;

import java.io.Serializable;
import java.util.Set;

public class Friend implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name, email, mobile;
    private Group group;
    private Set<Interest> interests;

    public Friend(String name, String email, String mobile, Group group, Set<Interest> interests) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.group = group;
        this.interests = interests;
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

    @Override
    public String toString() {
        return email + group + interests.toString().replaceAll("[\\[\\], ]", "") + mobile + name;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Friend)) return false;
        var f = (Friend) o;
        return email.compareTo(f.email)==0;
    }
}