package mantis.tests;


import mantis.pages.MantisSite;
import mantis.pages.ReportIssuePage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class ReportIssueTest extends BaseTest {
    private MantisSite mantisSite;
    private ReportIssuePage reportIssuePage;

    @Test
    public void createDeleteIssue() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuePage();

        reportIssuePage = new ReportIssuePage(driver);
        reportIssuePage.inputSummary("summary");
        reportIssuePage.inputDescription("description");
        reportIssuePage.clickSeverityField();
        reportIssuePage.clickSeverityBlock();

        String contentSummary = mantisSite.getReportIssuePage().getSummary();
        String contentSeverity = mantisSite.getReportIssuePage().getSeverityBlock();

        mantisSite.getReportIssuePage().scrollToSubmitIssueButton();
        Thread.sleep(3000);

        reportIssuePage.clickSubmitIssueButton();

        Thread.sleep(3000);

        String actualSummary = mantisSite.getReportIssuePage().getActualSummary();
        String actualSeverity = mantisSite.getReportIssuePage().getSeverity();

        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(actualSummary).isEqualTo(contentSummary);
        softAssert.assertThat(actualSeverity).isEqualTo(contentSeverity);

        String contentId = mantisSite.getReportIssuePage().getContentId();
        reportIssuePage.clickIdField();

        String actualId = mantisSite.getReportIssuePage().getActualId();

        softAssert.assertThat(actualId).isEqualTo(contentId);

        reportIssuePage.clickDeleteButton();
        reportIssuePage.clickDeleteIssuesButton();
    }
}
