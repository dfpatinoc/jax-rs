package com.dfpatino.testfeatures.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DomesticPaymentResponse {
    @ApiModelProperty(required = true, value = "OB: Unique identification as assigned by the ASPSP to uniquely identify the domestic payment resource.")
    @NotNull
    @Size(min = 1, max = 40)
    @Valid
    private String domesticPaymentId;

    @ApiModelProperty(required = true, value = "Date and time at which the message was created.All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00")
    @NotNull
    @Valid
    private LocalDateTime creationDateTime;

    @ApiModelProperty(required = true, value = "Specifies the status of the payment information group.")
    @NotNull
    @Valid
    private StatusEnum status;

    @ApiModelProperty(required = true, value = "Date and time at which the resource status was updated.All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00")
    @NotNull
    @Valid
    private LocalDateTime statusUpdateDateTime;

    @ApiModelProperty(required = true)
    @NotNull
    @Valid
    private Initiation initiation;

    public enum StatusEnum {

        ACCEPTED_SETTLEMENT_COMPLETED("AcceptedSettlementCompleted"),
        ACCEPTED_SETTLEMENT_IN_PROCESS("AcceptedSettlementInProcess"),
        PENDING("Pending"),
        REJECTED("Rejected");

        private String value;

        StatusEnum(String v) {
            value = v;
        }

        public String value() {
            return value;
        }

        @Override
        @JsonValue
        public String toString() {
            return value;
        }

        @JsonCreator
        public static StatusEnum fromValue(String v) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(v)) {
                    return b;
                }
            }
            return null;
        }
    }
}

