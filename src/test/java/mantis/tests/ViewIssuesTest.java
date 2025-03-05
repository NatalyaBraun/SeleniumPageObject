package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewIssuesTest extends BaseTest {
    private MantisSite mantisSite;


    @Test
    public void checkIssuesNumber() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToViewIssuesPage();

        mantisSite.getViewIssuesPage().scrollToTableCheckboxFooter();
        Thread.sleep(3000);

        int actualIssuesNumber = mantisSite.getViewIssuesPage().countIssues();

        Assertions.assertEquals(50, actualIssuesNumber);
    }
}
