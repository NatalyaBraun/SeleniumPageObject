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
        reportIssuePage.createNewIssueWithRequeredFileds("summary", "description");

        reportIssuePage.waitId();

//        String expectedSummary = reportIssuePage.getExpectedSummary();
//        String actualSummary = reportIssuePage.getActualSummary();
//        String expectedSeverity = reportIssuePage.getExpectedSeverity();
//        String actualSeverity = reportIssuePage.getActualSeverity();


        SoftAssertions softAssert = new SoftAssertions();
//        softAssert.assertThat(actualSummary).isEqualTo(expectedSummary);
//        softAssert.assertThat(actualSeverity).isEqualTo(expectedSeverity);


        String expectedId = mantisSite.getReportIssuePage().getExpectedId();

        reportIssuePage.clickIdField();

        String actualId = mantisSite.getReportIssuePage().getActualId();

        softAssert.assertThat(actualId).isEqualTo(expectedId);

        reportIssuePage.deleteIssue();

        String newActualId = mantisSite.getReportIssuePage().getExpectedId();

        softAssert.assertThat(newActualId).isNotEqualTo(expectedId);

        softAssert.assertAll();
    }
}
