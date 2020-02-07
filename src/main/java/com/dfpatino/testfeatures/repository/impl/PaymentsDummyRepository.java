package com.dfpatino.testfeatures.repository.impl;

import com.dfpatino.testfeatures.model.DomesticPaymentResponse;
import com.dfpatino.testfeatures.repository.PaymentsRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PaymentsDummyRepository implements PaymentsRepository {

    private final Map<String, DomesticPaymentResponse> domesticPayments = new HashMap<>();

    @Override
    public void save(final DomesticPaymentResponse domesticPayment) {
        domesticPayments.put(domesticPayment.getDomesticPaymentId(), domesticPayment);
    }

    @Override
    public DomesticPaymentResponse findById(final String domesticPaymentId) {
        return domesticPayments.get(domesticPaymentId);
    }

    @Override
    public void deleteAll() {
        domesticPayments.clear();
    }
}
