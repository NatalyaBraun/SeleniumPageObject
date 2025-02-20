package mantis.pages;

import Utils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;

public class ReportIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#mantisbt/bug_report_page.php")
    private WebElement reportIssuePageButton;

    @FindBy(css = "#summary")
    private WebElement summaryField;

    @FindBy(css = "#description")
    private WebElement descriptionField;

    @FindBy(xpath = "//input[@value='Submit Issue']")
    private WebElement submitIssueButton;

    @FindBy(xpath = "//*[@id='buglist']/tbody/tr[1]/td[11]")
    private WebElement actualSummaryField;

    @FindBy(css = "#severity")
    private WebElement severityField;

    @FindBy(xpath = "//*[@id='severity']/option[8]")
    private WebElement severityBlock;

    @FindBy(xpath = "//*[@id='buglist']/tbody/tr[1]/td[8]/span")
    private WebElement severity;

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

    LocalDate currentDate = LocalDate.now();

    public void inputSummary(String inputSummary) {
        summaryField.sendKeys("summary" + " " + currentDate);
    }

    public void inputDescription(String description) {
        descriptionField.sendKeys(description);
    }

    public void clickSubmitIssueButton() {
        submitIssueButton.click();
    }

    public void scrollToSubmitIssueButton() {
        TestUtils.scrollToElement(driver, submitIssueButton);
    }

    public String getSummary() {
        return (("summary" + " " + LocalDate.now()));
    }

    public String getActualSummary() {
        return actualSummaryField.getText();
    }

    public void clickSeverityField() {
        severityField.click();
    }

    public void clickSeverityBlock() {
        severityBlock.click();
    }

    public String getSeverityBlock() {
        return severityBlock.getText();
    }

    public String getSeverity() {
        return severity.getText();
    }

    public void clickIdField() {
        idField.click();
    }

    public String getContentId() {
        return idField.getText();
    }

    public String getActualId() {
        return actualId.getText();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public void clickDeleteIssuesButton() {
        deleteIssuesButton.click();
    }
}