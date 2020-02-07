package com.dfpatino.testfeatures.model;

import io.swagger.annotations.ApiModel;
import lombok.*;

@ApiModel(description = "Unambiguous identification of the account of the creditor to which a credit entry will be posted as a result of the payment transaction.")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InitiationCreditorAccount extends Account {

    @Builder
    public InitiationCreditorAccount(String schemeName, String identification, String name) {
        super(schemeName, identification, name);
    }

}

