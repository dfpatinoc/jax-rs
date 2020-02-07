package com.dfpatino.testfeatures.model;

import io.swagger.annotations.ApiModel;
import lombok.*;

@ApiModel(description = "Unambiguous identification of the account of the debtor to which a debit entry will be made as a result of the transaction.")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InitiationDebtorAccount extends Account {

    @Builder
    public InitiationDebtorAccount(String schemeName, String identification, String name) {
        super(schemeName, identification, name);
    }

}

