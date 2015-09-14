package controllers;

import models.User;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;

import views.html.*;

import java.util.List;

public class Application extends Controller {

    public Result index() {
        return ok(index.render());
    }

    public Result register() {
        DynamicForm form = Form.form().bindFromRequest();

        String fname = form.data().get("fname");
        String lname = form.data().get("lname");
        String pass = form.data().get("pass");

        List<User> userList = User.all();
        for (User u : userList) {
            if (u.fname.equals(fname) && u.lname.equals(lname)) {
                if (u.password == null) {
                    u.password = pass;
                    u.save();

                    return ok("1");
                } else {
                    return ok("2");
                }
            }
        }

        return ok("3");
    }

    public Result login() {
        DynamicForm form = Form.form().bindFromRequest();

        String fname = form.data().get("fn");
        String pass = form.data().get("ps");

        List<User> userList = User.all();
        for (User u : userList) {
            if (u.password != null) {
                if (u.fname.equals(fname) && u.password.equals(pass)) {
                    return ok("1");
                }
            }
        }

        return ok("2");
    }
}
