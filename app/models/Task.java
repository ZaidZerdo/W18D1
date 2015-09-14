package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Zaid on 9/14/2015.
 */
@Entity
public class Task extends Model {
    @Id
    public String id;

    public String filename;
}
