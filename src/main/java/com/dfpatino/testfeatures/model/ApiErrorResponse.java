package com.dfpatino.testfeatures.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "An array of detail error codes, and messages to documentation to help remediation.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiErrorResponse {

    @ApiModelProperty(required = true, value = "High level textual error code, to help categorize the errors.")
    @NotNull
    @Size(min = 1, max = 40)
    @Valid
    private String code;

    @ApiModelProperty(value = "A unique reference for the error instance, for audit purposes, in case of unknown/unclassified errors.")
    @Size(min = 1, max = 40)
    @Valid
    private String id;

    @ApiModelProperty(required = true, value = "Brief Error message, e.g., 'There is something wrong with the request parameters provided'")
    @NotNull
    @Size(min = 1, max = 500)
    @Valid
    private String message;

    @ApiModelProperty(required = true, value = "Array of detailed errors")
    @Size(min = 1)
    @Valid
    private List<ApiError> errors = new ArrayList<>();

}

