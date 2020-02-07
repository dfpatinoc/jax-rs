package com.dfpatino.testfeatures.cucumber.stepdefs;

import com.dfpatino.testfeatures.model.*;
import com.dfpatino.testfeatures.repository.PaymentsRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.val;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GetDomesticPaymentSteps extends AbstractSteps {

    @Autowired
    private PaymentsRepository repository;

    @Before
    public void setup() {
        repository.deleteAll();
    }

    @Given("A domestic payment with id {string} that is stored in our system")
    public void aDomesticPaymentWithIdDomesticPaymentIdThatIsStoredInOurSystem(final String domesticPaymentId) {
        cucumberContext().reset();
        val domesticPayment = createDomesticPaymentResponse(domesticPaymentId);
        repository.save(domesticPayment);
    }

    @When("I get the domestic payment with id {string}")
    public void iGetTheDomesticPaymentWithIdDomesticPaymentId(final String domesticPaymentId) {
        doGet("domestic-payments/".concat(domesticPaymentId));
    }

    @Then("The system return the http status code {int}")
    public void theSystemReturnTheHttpStatusCode(int httpStatusCode) {
        val response = cucumberContext().getResponse();
        assertNotNull(response);
        assertEquals(httpStatusCode, response.getStatus());
        if (httpStatusCode >= 200 && httpStatusCode < 300) {
            assertNotNull(response.readEntity(DomesticPaymentResponse.class));
        }
    }

    @Given("A domestic payment that is not stored in our system")
    public void aDomesticPaymentThatIsNotStoredInOurSystem() {
        cucumberContext().reset();
    }

    private DomesticPaymentResponse createDomesticPaymentResponse(final String domesticPaymentId) {
        return DomesticPaymentResponse.builder()
                .domesticPaymentId(domesticPaymentId)
                .creationDateTime(LocalDateTime.now())
                .status(DomesticPaymentResponse.StatusEnum.PENDING)
                .statusUpdateDateTime(LocalDateTime.now())
                .initiation(Initiation.builder()
                        .instructedAmount(InitiationInstructedAmount.builder()
                                .amount(120.12)
                                .currency("EUR")
                                .build())
                        .creditorAccount(InitiationCreditorAccount.builder()
                                .schemeName("IBAN")
                                .identification("ES0000000000000000000001")
                                .name("Account name creditor")
                                .build())
                        .debtorAccount(InitiationDebtorAccount.builder()
                                .schemeName("IBAN")
                                .identification("ES9999999999999999999999")
                                .name("Account name debtor")
                                .build())
                        .build())
                .build();
    }

}
