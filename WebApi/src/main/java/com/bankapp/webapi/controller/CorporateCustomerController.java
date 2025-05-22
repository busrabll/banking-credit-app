package com.bankapp.webapi.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.business.abstracts.CorporateCustomerService;
import com.bankapp.business.dtos.requests.CorporateCustomerCreateRequest;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;
import com.bankapp.core.utilities.results.PaginatedDataResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/corporate-customers")
@AllArgsConstructor
@Tag(name = "Corporate Customers", description = "APIs for managing corporate customers")
public class CorporateCustomerController {
	
    private CorporateCustomerService corporateCustomerService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new corporate customer")
    public CorporateCustomerResponse create(@RequestBody CorporateCustomerCreateRequest request) {
        return corporateCustomerService.create(request);
    }

    @GetMapping("/by-customer-number/{customerNumber}")
    @Operation(summary = "Get corporate customer by customer number")
    public CorporateCustomerResponse getByCustomerNumber(@PathVariable String customerNumber) {
        return corporateCustomerService.getByCustomerNumber(customerNumber);
    }
    
    @GetMapping("/by-tax-number/{taxNumber}")
    @Operation(summary = "Get corporate customer by tax number")
    public CorporateCustomerResponse getByTaxNumber(@PathVariable String taxNumber) {
        return corporateCustomerService.getByTaxNumber(taxNumber);
    }

    @GetMapping
    @Operation(summary = "Get all corporate customers with pagination")
    public PaginatedDataResponse<CorporateCustomerResponse> getAllPaged(
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
        return corporateCustomerService.getAllPaged(pageable);
    }

}
