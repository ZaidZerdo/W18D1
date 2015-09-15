import com.google.common.collect.ImmutableMap;
import models.User;
import org.junit.*;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import play.Logger;
import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.junit.Assert.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;

import org.junit.*;

import Utilites.Session;

import com.google.common.collect.ImmutableMap;

import play.mvc.Content;
import play.mvc.Result;
import play.test.WithApplication;
import static play.test.Helpers.*;
import static org.junit.Assert.*;
import models.*;

public class IntegrationTest {

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
    @Test
    public void testFrontpage() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                browser.goTo("http://localhost:3333");

                boolean b = browser.pageSource().contains("Please fill in the form");

                assertTrue(b);
            }
        });
    }

    @Test
    public void testForm() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                browser.goTo("http://localhost:3333");

                User u = new User();
                u.fname = "Edvin";
                u.lname = "Mulabdic";
                u.id = "1";
                u.save();

                browser.fill("#regfname").with("Edvin");
                browser.fill("#reglname").with("Mulabdic");
                browser.fill("#regpass").with("1234");
                browser.click("#regsubmit");

                boolean b = browser.pageSource().contains("<div id=\"regdiv\">User not in database");

                //Izgleda okay, ali nije
                //boolean b = browser.pageSource().contains("User not in database");

                assertTrue(b);
            }
        });
    }



    /*
               assertTrue(browser.pageSource().contains("Registration"));

                browser.fill("#regfname").with("Zaid");
                browser.fill("#regpass").with("1234");
                browser.fill("#reglname").with("Zerdo");
                browser.click("#regsubmit");

                Logger.info(browser.value("#regdiv").toString());
                assertTrue(browser.value("#regdiv").contains("User not in database."));

     */

}
