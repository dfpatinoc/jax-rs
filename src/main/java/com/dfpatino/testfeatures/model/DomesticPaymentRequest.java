package com.dfpatino.testfeatures.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DomesticPaymentRequest {

    @ApiModelProperty(required = true)
    @NotNull
    @Valid
    private Initiation initiation;

}

