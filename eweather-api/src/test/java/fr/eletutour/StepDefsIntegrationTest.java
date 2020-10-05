package fr.eletutour;

import com.google.gson.Gson;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.eletutour.eweather.dto.Forecast;
import fr.eletutour.eweather.exceptions.ApiError;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StepDefsIntegrationTest extends SpringIntegrationTest {

    @When("^the client call /eweather/toto$")
    public void the_client_call_eweather_toto() throws Throwable {
        executeGet("http://localhost:8080/eweather/toto");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @When("^the client call /eweather/forecast\\?location=Paris$")
    public void the_client_call_eweather_forecast_location_Paris() throws Throwable {
        executeGet("http://localhost:8080/eweather/forecast?location=Paris");
    }

    @Then("^the client receive status code of (\\d+)$")
    public void the_client_receive_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @Then("^I receive valid Response$")
    public void i_receive_valid_Response() throws Throwable {
        String responseBody = latestResponse.getBody();
        Gson g = new Gson();
        Forecast f = g.fromJson(responseBody, Forecast.class);
        assertThat(f).isNotNull();
        assertThat(f.getLocation()).isNotNull().isNotEmpty().contains("Paris");
        assertThat(f.getCurrently()).isNotNull();
        assertThat(f.getDaily()).isNotNull();
        assertThat(f.getHourly()).isNotNull();
    }

    @When("^the client call /eweather/forecast\\?location=$")
    public void the_client_call_eweather_forecast_location() throws Throwable {
        executeGet("http://localhost:8080/eweather/forecast?location=");
    }

    @Then("^I receive an error Response$")
    public void i_receive_an_error_Response() throws Throwable {
        String responseBody = latestResponse.getBody();
        Gson g = new Gson();
        ApiError error = g.fromJson(responseBody, ApiError.class);
        assertThat(error).isNotNull();
        assertThat(error.getStatus()).isNotNull().isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(error.getMessage()).isNotNull().isNotEmpty().isEqualTo("Une erreur concernant la location est survenue.");
        assertThat(error.getDebugMessage()).isNotNull().isNotEmpty();
    }
}