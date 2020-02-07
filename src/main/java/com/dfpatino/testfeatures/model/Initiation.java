package com.dfpatino.testfeatures.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel(description = "The Initiation payload is sent by the initiating party to the ASPSP. It is used to request movement of funds from the debtor account to a creditor for a single domestic payment.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Initiation {

    @ApiModelProperty(required = true)
    @NotNull
    @Valid
    private InitiationInstructedAmount instructedAmount;

    @ApiModelProperty
    @Valid
    private InitiationDebtorAccount debtorAccount;

    @ApiModelProperty(required = true)
    @NotNull
    @Valid
    private InitiationCreditorAccount creditorAccount;

}

