package com.bankapp.webapi.controller;

import com.bankapp.business.dtos.requests.IndividualCustomerCreateRequest;
import com.bankapp.business.dtos.responses.IndividualCustomerResponse;
import com.bankapp.business.abstracts.IndividualCustomerService;
import com.bankapp.core.utilities.results.PaginatedDataResponse;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/individual-customers")
@AllArgsConstructor
@Tag(name = "Individual Customers", description = "APIs for managing individual customers")
public class IndividualCustomerController {

    private IndividualCustomerService individualCustomerService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new individual customer")
    public IndividualCustomerResponse create(@RequestBody IndividualCustomerCreateRequest request) {
        return individualCustomerService.create(request);
    }

    @GetMapping("/by-national-id/{nationalId}")
    @Operation(summary = "Get individual customer by national ID")
    public IndividualCustomerResponse getByNationalId(@PathVariable String nationalId) {
        return individualCustomerService.getByNationalId(nationalId);
    }

    @GetMapping("/by-customer-number/{customerNumber}")
    @Operation(summary = "Get individual customer by customer number")
    public IndividualCustomerResponse getByCustomerNumber(@PathVariable String customerNumber) {
        return individualCustomerService.getByCustomerNumber(customerNumber);
    }

    @GetMapping
    @Operation(summary = "Get all individual customers with pagination")
    public PaginatedDataResponse<IndividualCustomerResponse> getAllPaged(
        @Parameter(description = "Page number (starts from 0)")
        @RequestParam(defaultValue = "0") int page,

        @Parameter(description = "Number of items per page")
        @RequestParam(defaultValue = "10") int size,

        @Parameter(description = "Sort field") 
        @RequestParam(defaultValue = "id") String sortField,

        @Parameter(description = "Sort direction (asc or desc)")
        @RequestParam(defaultValue = "ASC") String sortDirection
            
    ) {
        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortField));
        return individualCustomerService.getAllPaged(pageable);
    }
}