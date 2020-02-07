package com.dfpatino.testfeatures.service;

import com.dfpatino.testfeatures.model.DomesticPaymentRequest;
import com.dfpatino.testfeatures.model.DomesticPaymentResponse;

public interface DomesticPaymentsService {
    DomesticPaymentResponse createDomesticPayment(final DomesticPaymentRequest domesticPaymentRequest);

    DomesticPaymentResponse getDomesticPayment(final String domesticPaymentId);
}
