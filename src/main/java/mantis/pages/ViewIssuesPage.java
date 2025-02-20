package mantis.pages;

import Utils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ViewIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#buglist tbody tr")
    private List<WebElement> issues;

    @FindBy(css = "#bug_arr_all")
    private WebElement tableCheckboxFooter;

    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(30),Duration.ofMillis(500));
        PageFactory.initElements(driver, this);
    }

    public int countIssues() {
        return issues.size();
    }

    public void scrollToTableCheckboxFooter() {
        TestUtils.scrollToElement(driver, tableCheckboxFooter);
    }
}
