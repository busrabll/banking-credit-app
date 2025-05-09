package com.bankapp.webapi.controller;

import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.business.dtos.responses.IndividualCustomerResponse;
import com.bankapp.business.abstracts.IndividualCustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/individual-customers")
@AllArgsConstructor
@Tag(name = "Individual Customers", description = "APIs for managing individual customers")
public class IndividualCustomerController {

    private IndividualCustomerService individualCustomerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new individual customer")
    public IndividualCustomerResponse create(@RequestBody IndividualCustomerCreateRequest request) {
        return individualCustomerService.create(request);
    }

    @GetMapping("/by-customer-number/{customerNumber}")
    @Operation(summary = "Get individual customer by customer number")
    public IndividualCustomerResponse getByCustomerNumber(@PathVariable String customerNumber) {
        return individualCustomerService.getByCustomerNumber(customerNumber);
    }

    @GetMapping("/by-national-id/{nationalId}")
    @Operation(summary = "Get individual customer by national ID")
    public IndividualCustomerResponse getByNationalId(@PathVariable String nationalId) {
        return individualCustomerService.getByNationalId(nationalId);
    }
} 