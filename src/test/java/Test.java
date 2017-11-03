import com.company.User;
import com.company.UserPrinter;
import org.junit.Assert;
import org.junit.Before;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Test {

    private UserPrinter user;
    private User oldestUser;

    @Before
    public void setup() throws FileNotFoundException {
        user = new UserPrinter("users.txt");
        oldestUser = new User("Grzesiek", "Motecki", LocalDate.parse("1984-11-21"), "606329632");
    }

    @org.junit.Test
    public void loadValidTextFile() {
        Assert.assertNotNull(user = new UserPrinter("users.txt"));
    }

    @org.junit.Test
    public void testPrintingOldestUser() {
        Assert.assertEquals(oldestUser.toString(), user.getOldestUser().toString());
    }

    @org.junit.Test
    public void testPrintingAllUsers() throws IOException, URISyntaxException {
        String text = new String(Files.readAllBytes(Paths.get(getClass().getResource("test.txt").toURI())));

        Assert.assertEquals(text, user.printUsers().replace("\r", ""));
    }
}
