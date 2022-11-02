package tracksAPI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StepDefinitions {

    @Given("an authenticated user")
    public void anAuthenticatedUser() {
        // Purposefully left blank as this endpoint has no authentication
    }

    @When("a GET request is sent to {string}")
    public void aGETRequestIsSentTo(String url) {

    }

    @Then("the response code is {int}")
    public void theResponseCodeIs(int targetResponseCode) {
    }

    @And("the response time is below {int} second")
    public void theResponseTimeIsLowerThanSecond(int targetResponseTime) {
    }

    @Then("the ID field is never null for all items")
    public void theIDFieldIsNeverNullForAllItems() {
    }

    @And("the ID field is never empty for all items")
    public void theIDFieldIsNeverEmptyForAllItems() {
    }

    @And("the segment_type field is {string} for all items")
    public void theSegment_typeFieldIsForAllItems(String arg0) {
    }

    @Then("the primary title list is never null for all items")
    public void thePrimaryTitleListIsNeverNullForAllItems() {
    }

    @And("the primary title list is never empty for all items")
    public void thePrimaryTitleListIsNeverEmptyForAllItems() {
    }

    @Then("only one track reports true for now_playing")
    public void onlyOneTrackReportsTrueForNow_playing() {

    }

    @Then("the response header has a valid date")
    public void theResponseHeaderHasAValidDate() {
    }
}
