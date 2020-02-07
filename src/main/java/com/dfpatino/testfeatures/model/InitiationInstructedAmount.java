package com.dfpatino.testfeatures.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(description = "Amount of money to be moved between the debtor and creditor, before deduction of charges, expressed in the currency as ordered by the initiating party. Usage: This amount has to be transported unchanged through the transaction chain.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InitiationInstructedAmount {

    @ApiModelProperty(required = true)
    @NotNull
    @Valid
    private Double amount;

    @ApiModelProperty(required = true)
    @NotBlank
    @Valid
    private String currency;
}

