package mantis.tests;


import mantis.pages.MantisSite;
import mantis.pages.ReportIssuePage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ReportIssueTest extends BaseTest {
    private MantisSite mantisSite;
    private ReportIssuePage reportIssuePage;

    @Test
    public void createDeleteIssue() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuePage();

        reportIssuePage = new ReportIssuePage(driver);
        String summary = "summary" + " " + Timestamp.valueOf(LocalDateTime.now());
        String description = "description";

        reportIssuePage.createNewIssueWithRequeredFileds(summary, description);

        reportIssuePage.waitId();

        String actualSummary = reportIssuePage.getActualSummary();

        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(actualSummary).isEqualTo(summary);

        String expectedId = mantisSite.getReportIssuePage().getExpectedId();

        reportIssuePage.clickIdField();

        String actualId = mantisSite.getReportIssuePage().getActualId();
        String actualDescription = mantisSite.getReportIssuePage().getActualDescription();

        softAssert.assertThat(actualId).isEqualTo(expectedId);
        softAssert.assertThat(actualDescription).isEqualTo(description);

        reportIssuePage.deleteIssue();
//
        String newActualId = mantisSite.getReportIssuePage().getExpectedId();

        softAssert.assertThat(newActualId).isNotEqualTo(expectedId);

        softAssert.assertAll();
    }
}