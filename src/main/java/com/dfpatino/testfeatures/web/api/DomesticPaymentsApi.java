package com.dfpatino.testfeatures.web.api;

import com.dfpatino.testfeatures.service.DomesticPaymentsService;
import com.dfpatino.testfeatures.model.ApiErrorResponse;
import com.dfpatino.testfeatures.model.DomesticPaymentRequest;
import com.dfpatino.testfeatures.model.DomesticPaymentResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/domestic-payments")
@Slf4j
public class DomesticPaymentsApi {

    @Autowired
    private DomesticPaymentsService service;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Create Domestic Payments", response = DomesticPaymentResponse.class, tags = {"Domestic Payments",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Domestic Payments Created", response = DomesticPaymentResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = ApiErrorResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiErrorResponse.class)
    })
    public Response createDomesticPayments(@Valid final DomesticPaymentRequest domesticPaymentRequest) {
        log.info("Initiating domestic payment: {}", domesticPaymentRequest);
        val response = service.createDomesticPayment(domesticPaymentRequest);
        log.info("Domestic payment initiated with id {}: {}", response.getDomesticPaymentId(), response);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{domesticPaymentId}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Get Domestic Payments", response = DomesticPaymentResponse.class, tags = {"Domestic Payments"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Domestic Payments Read", response = DomesticPaymentResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = ApiErrorResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiErrorResponse.class)
    })
    public Response getDomesticPaymentsDomesticPaymentId(@PathParam("domesticPaymentId")
                                                         @ApiParam("domesticPaymentId") final String domesticPaymentId) {
        log.info("Getting domestic payment with id {}", domesticPaymentId);
        val response = service.getDomesticPayment(domesticPaymentId);
        log.info("Domestic payment obtained: {}", response);
        return response == null ?
                Response.status(Response.Status.NOT_FOUND).build() :
                Response.status(Response.Status.OK).entity(response).build();
    }
}
