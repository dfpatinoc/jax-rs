package com.dfpatino.testfeatures.service.impl;

import com.dfpatino.testfeatures.errors.BusinessException;
import com.dfpatino.testfeatures.model.DomesticPaymentRequest;
import com.dfpatino.testfeatures.model.DomesticPaymentResponse;
import com.dfpatino.testfeatures.repository.PaymentsRepository;
import com.dfpatino.testfeatures.service.DomesticPaymentsService;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class DomesticPaymentsDummyService implements DomesticPaymentsService {

    private final PaymentsRepository repository;

    public DomesticPaymentsDummyService(final PaymentsRepository repository) {
        this.repository = repository;
    }

    @Override
    public DomesticPaymentResponse createDomesticPayment(final DomesticPaymentRequest domesticPaymentRequest) {
        if (domesticPaymentRequest.getInitiation().getInstructedAmount().getAmount() > 600)
            throw new BusinessException("BE-AMOUNT-01", "error.payment.amount.exceeded");
        val domesticPayment = DomesticPaymentResponse.builder()
                .domesticPaymentId(UUID.randomUUID().toString())
                .creationDateTime(LocalDateTime.now())
                .status(DomesticPaymentResponse.StatusEnum.PENDING)
                .statusUpdateDateTime(LocalDateTime.now())
                .initiation(domesticPaymentRequest.getInitiation())
                .build();
        repository.save(domesticPayment);
        return domesticPayment;
    }

    @Override
    public DomesticPaymentResponse getDomesticPayment(String domesticPaymentId) {
        return repository.findById(domesticPaymentId);
    }

}



