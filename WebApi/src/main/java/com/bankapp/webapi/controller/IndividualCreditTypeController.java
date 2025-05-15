package com.bankapp.webapi.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.business.abstracts.IndividualCreditTypeService;
import com.bankapp.business.dtos.requests.IndividualCreditTypeCreateRequest;
import com.bankapp.business.dtos.responses.IndividualCreditTypeResponse;
import com.bankapp.core.utilities.results.PaginatedDataResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/individual-credit-types")
@AllArgsConstructor
@Tag(name = "Individual Credit Types", description = "APIs for managing individual credit types")
public class IndividualCreditTypeController {

	private IndividualCreditTypeService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Create a new individual credit type")
	public IndividualCreditTypeResponse add(@Valid @RequestBody IndividualCreditTypeCreateRequest request) {
		return service.add(request);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get individual credit type by id")
	public IndividualCreditTypeResponse getById(@PathVariable Long id) {
		return service.getById(id);
	}

	@GetMapping
	@Operation(summary = "Get all individual credit types")
	public PaginatedDataResponse<IndividualCreditTypeResponse> getAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "name") String sortBy,
			@RequestParam(defaultValue = "ASC") String direction) {

		Sort.Direction sortDirection = Sort.Direction.fromString(direction.toUpperCase());
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

		return service.getAllPaged(pageable);
	}

	@PutMapping("/{id}/deactivate")
	@Operation(summary = "Deactivate an individual credit type")
	public void deactivate(@PathVariable Long id) {
		service.deactivate(id);
	}

	@PutMapping("/{id}/activate")
	@Operation(summary = "Activate an individual credit type")
	public void activate(@PathVariable Long id) {
		service.activate(id);
	}

}
