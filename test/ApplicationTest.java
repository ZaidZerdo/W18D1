import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import models.User;
import org.junit.*;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import play.Logger;
import play.Play;
import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static org.junit.Assert.assertNull;
import static play.test.Helpers.*;
import static org.junit.Assert.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest extends WithApplication {

    @Before
    public void configureDatabase() {
        fakeApplication(inMemoryDatabase());
    }

    @Test
    public void testAddition() {
        int sum = 2 + 2;

        assertEquals(sum, 4);
    }

    @Test
    public void testNullPointer() {
        String s = "Dinko";

        assertNotNull(s);
    }

    @Test
    public void testDatabase() {
        List<User> userList = User.all();

        assertNotNull(userList);
    }

    @Test
    public void testSavingInDatabase() {
        User u = new User();
        u.fname = "Dinko";
        u.lname = "Hodzic";
        u.id = "100";
        u.password = "Nema ga";

        u.save();
    }

    @Test
    public void testNonexistantUser() {
        User u = User.findUser("ouhafuzadfu");

        assertNull(u);
    }

    @Test
    public void testSavingAndLoading() {
        User u = new User();
        u.fname = "Dinko";
        u.lname = "Hodzic";
        u.id = "100";
        u.password = "Nema ga";

        u.save();

        User u1 = User.findUser("100");

        assertNotNull(u1);
    }


/*
    @Before
    public void setup() {
        fakeApplication(inMemoryDatabase());
    }

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertEquals("Is 1 + 1 = 2?", 2, a);
    }

    @Test
    public void testGetAllUsers() {
        List<User> list = User.all();

        Logger.info(list.toString());
        assertNotNull(list);
    }

    @Test
    public void testCreateUser() {
        User u = new User();
        u.fname = "Zaid";
        u.lname = "Zerdo";
        u.id = "1";
        u.password = "1234";
        u.save();

        List<User> list = User.all();
        assertEquals(list.size(), 1);
    }

    @Test
    public void testUserThatDoesNotExist() {
        User u = User.findUser("12139281923");

        assertNull(u);
    }

    @Test
    public void testLogin() {
        running(testServer(3333,
                        fakeApplication(inMemoryDatabase())),
                new HtmlUnitDriver(),
                new Callback<TestBrowser>() {
                    public void invoke(TestBrowser browser) {
                        User u = new User();
                        u.fname = "Zaid";
                        u.lname = "Zerdo";
                        u.id = "1";
                        u.save();

                        browser.goTo("http://localhost:3333");
                        assertTrue(browser.pageSource().contains("Login"));

                        browser.fill("#regfname").with("Zaid");
                        browser.fill("#regpass").with("1234");
                        browser.fill("#reglname").with("Zerdo");
                        browser.click("#regsubmit");

                        browser.fill("#logfname").with("Zaid");
                        browser.fill("#logpass").with("1234");
                        browser.click("#logsubmit");

                        assertTrue(browser.pageSource().contains("Wrong name or password."));
                    }
                });}*/

}
