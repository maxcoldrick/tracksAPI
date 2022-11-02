package tracksAPI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tracksAPI.model.Data;
import tracksAPI.model.RawResponse;

import static org.junit.Assert.*;

public class StepDefinitions {

    RawResponse rawResponse;

    @Given("an authenticated user")
    public void anAuthenticatedUser() {
        // Purposefully left blank as this endpoint has no authentication
    }

    @When("a GET request is sent to {string}")
    public void aGETRequestIsSentTo(String url) throws Exception {
        rawResponse = Utils.getRequest(url);
    }

    @Then("the response code is {int}")
    public void theResponseCodeIs(int targetResponseCode) {
        assertEquals(rawResponse.responseCode, targetResponseCode);
    }

    @And("the response time is below {int} second")
    public void theResponseTimeBelowSecond(int targetResponseTime) {
        assertTrue(rawResponse.responseTimeMs < (targetResponseTime * 1000L));
    }

    @Then("the ID field is never null for all items")
    public void theIDFieldIsNeverNullForAllItems() {
        for (Data d : rawResponse.response.data) {
            assertNotNull(d.getId());
        }
    }

    @And("the ID field is never empty for all items")
    public void theIDFieldIsNeverEmptyForAllItems() {
        for (Data d : rawResponse.response.data) {
            assertNotEquals("", d.getId());
        }
    }

    @And("the segment_type field is {string} for all items")
    public void theSegmentTypeFieldIsForAllItems(String input) {
        for (Data d : rawResponse.response.data) {
            assertEquals(input, d.getSegmentType());
        }
    }

    @Then("the primary title list is never null for all items")
    public void thePrimaryTitleListIsNeverNullForAllItems() {
        for (Data d : rawResponse.response.data) {
            assertNotNull(d.getTitleList().getPrimary());
        }
    }

    @And("the primary title list is never empty for all items")
    public void thePrimaryTitleListIsNeverEmptyForAllItems() {
        for (Data d : rawResponse.response.data) {
            assertNotEquals(d.getTitleList().getPrimary(), "");
        }
    }

    @Then("only one track reports true for now_playing")
    public void onlyOneTrackReportsTrueForNow_playing() {
        int count = 0;
        for (Data d : rawResponse.response.data) {
            if (d.getOffset().getNowPlaying()) {
                count++;
            }
        }
        assertEquals(1, count);
    }

    @Then("the response header has a valid date")
    public void theResponseHeaderHasAValidDate() {
        assertNotNull(rawResponse.getDate());
        assertNotEquals(rawResponse.getDate(), "");
    }
}
