package com.dfpatino.testfeatures.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @ApiModelProperty(required = true)
    @NotNull
    @Valid
    private String schemeName;

    @ApiModelProperty(required = true)
    @NotNull
    @Size(min = 1, max = 256)
    @Valid
    private String identification;

    @ApiModelProperty
    @Size(min = 1, max = 70)
    @Valid
    private String name;
}
