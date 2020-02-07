package com.dfpatino.testfeatures.repository;

import com.dfpatino.testfeatures.model.DomesticPaymentRequest;
import com.dfpatino.testfeatures.model.DomesticPaymentResponse;

public interface PaymentsRepository {
    void save(final DomesticPaymentResponse domesticPayment);
    DomesticPaymentResponse findById(final String domesticPaymentId);
    void deleteAll();
}
