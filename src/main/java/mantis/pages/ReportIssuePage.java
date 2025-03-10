package mantis.pages;

import Utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;


public class ReportIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#summary")
    private WebElement summaryField;

    @FindBy(css = "#description")
    private WebElement descriptionField;

    @FindBy(xpath = "//input[@value='Submit Issue']")
    private WebElement submitIssueButton;

    @FindBy(xpath = "//*[@id='buglist']/tbody/tr[1]/td[11]")
    private WebElement actualSummaryField;

    @FindBy(xpath = " //tr[11]/td")
    private WebElement actualDescriptionField;

    @FindBy(xpath = "//table[@id='buglist']/tbody/tr/td[4]/a")
    private WebElement idField;

    @FindBy(xpath = "//*[@class='bug-id']")
    private WebElement actualId;

    @FindBy(xpath = "//*[@value='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@value='Delete Issues']")
    private WebElement deleteIssuesButton;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        PageFactory.initElements(driver, this);
    }

    public void createNewIssueWithRequeredFileds(String summary, String description) {

        summaryField.sendKeys("summary" + " " + Timestamp.valueOf(LocalDateTime.now()));
        descriptionField.sendKeys(description);

        TestUtils.scrollToElement(driver, submitIssueButton);
        submitIssueButton.click();
    }

    public String getActualSummary() {
        return actualSummaryField.getText();
    }

    public String getActualDescription() {
        return actualDescriptionField.getText();
    }

    public void clickIdField() {
        idField.click();
    }

    public String getExpectedId() {
        return idField.getText();
    }

    public String getActualId() {
        return actualId.getText();
    }

    public void deleteIssue() {
        deleteButton.click();
        deleteIssuesButton.click();
    }

    public void waitId() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//table[@id='buglist']/tbody/tr/td[4]/a")));
    }
}