package com.bankapp.webapi.controller;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import com.bankapp.business.abstracts.CreditApplicationService;
import com.bankapp.business.dtos.requests.CreditApplicationCreateRequest;
import com.bankapp.business.dtos.responses.CreditApplicationResponse;
import com.bankapp.core.utilities.results.PaginatedDataResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit-applications")
@AllArgsConstructor
@Tag(name = "Credit Applications", description = "APIs for managing credit applications")
public class CreditApplicationController {

    private CreditApplicationService creditApplicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new credit application")
    public CreditApplicationResponse apply(@Valid @RequestBody CreditApplicationCreateRequest request) {
        return creditApplicationService.apply(request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get credit application by ID")
    public CreditApplicationResponse getById(@PathVariable Long id) {
        return creditApplicationService.getById(id);
    }

    @GetMapping("/by-customer/{customerId}")
    @Operation(summary = "Get all credit applications for a customer")
    public PaginatedDataResponse<CreditApplicationResponse> getAllByCustomerId(
        @PathVariable Long customerId,
        @Parameter(description = "Page number (starts from 0)")
        @RequestParam(defaultValue = "0") int page,
        @Parameter(description = "Number of items per page")
        @RequestParam(defaultValue = "10") int size,
        @Parameter(description = "Sort field")
        @RequestParam(defaultValue = "createdDate") String sortField,
        @Parameter(description = "Sort direction (asc or desc)")
        @RequestParam(defaultValue = "DESC") String sortDirection
        ) {
        
        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortField));
        return creditApplicationService.getAllByCustomerId(customerId, pageable);
    }

    @PutMapping("/{id}/cancel")
    @Operation(summary = "Cancel a credit application")
    public CreditApplicationResponse cancel(@PathVariable Long id) {
        return creditApplicationService.cancel(id);
    }
} 
