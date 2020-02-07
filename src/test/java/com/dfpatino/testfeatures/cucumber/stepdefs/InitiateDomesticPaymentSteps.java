package com.dfpatino.testfeatures.cucumber.stepdefs;

import com.dfpatino.testfeatures.model.*;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import lombok.val;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InitiateDomesticPaymentSteps extends AbstractSteps {

    @When("I initiate a domestic payment")
    public void iInitiateADomesticPayment(final DomesticPaymentRequest domesticPayment) {
        doPost("domestic-payments", domesticPayment);
    }

    @DataTableType
    public DomesticPaymentRequest domesticPaymentRequestEntry(Map<String, String> entry) {
        return DomesticPaymentRequest.builder()
                .initiation(Initiation.builder()
                        .instructedAmount(InitiationInstructedAmount.builder()
                                .amount(entry.get("amount") != null ? Double.valueOf(entry.get("amount")) : null)
                                .currency(entry.get("currency"))
                                .build())
                        .creditorAccount(InitiationCreditorAccount.builder()
                                .schemeName(entry.get("debtorAccountScheme"))
                                .identification(entry.get("debtorAccount"))
                                .name(entry.get("debtorAccountName"))
                                .build())
                        .debtorAccount(InitiationDebtorAccount.builder()
                                .schemeName(entry.get("creditorAccountScheme"))
                                .identification(entry.get("creditorAccount"))
                                .name(entry.get("creditorAccountName"))
                                .build())
                        .build())
                .build();
    }

    @And("The error message {string}")
    public void theErrorMessageIsErrorMessage(final String errorMessage) {
        val response = cucumberContext().getResponse();
        assertNotNull(response);
        val apiError = response.readEntity(ApiErrorResponse.class);
        assertNotNull(apiError);
        assertEquals(errorMessage, apiError.getMessage());
    }
}
