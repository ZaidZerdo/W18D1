package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by Zaid on 9/14/2015.
 */
@Entity
public class User extends Model {
    @Id
    public String id;

    public String fname;
    public String lname;
    public String password;

    @ManyToMany
    public List<Task> tasks;

    private static Finder<String, User> finder =
            new Finder<>(User.class);

    public static List<User> all() {
        return finder.all();
    }

    public static User findUser(String id) {
        return finder.byId(id);
    }

    @Override
    public String toString() {
        return fname + " " + lname + "(" + password + ")";
    }
}
