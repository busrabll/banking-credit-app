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

import com.bankapp.business.abstracts.CorporateCreditTypeService;
import com.bankapp.business.dtos.requests.CorporateCreditTypeCreateRequest;
import com.bankapp.business.dtos.responses.CorporateCreditTypeResponse;
import com.bankapp.core.utilities.results.PaginatedDataResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/corporate-credit-types")
@AllArgsConstructor
@Tag(name = "Corporate Credit Types", description = "APIs for managing corporate credit types")
public class CorporateCreditTypeController {

	private CorporateCreditTypeService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Create a new corporate credit type")
	public CorporateCreditTypeResponse add(@Valid @RequestBody CorporateCreditTypeCreateRequest request) {
		return service.add(request);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get corporate credit type by id")
	public CorporateCreditTypeResponse getById(@PathVariable Long id) {
		return service.getById(id);
	}

	@GetMapping
	@Operation(summary = "Get all corporate credit types")
	public PaginatedDataResponse<CorporateCreditTypeResponse> getAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "name") String sortBy,
			@RequestParam(defaultValue = "ASC") String direction) {

		Sort.Direction sortDirection = Sort.Direction.fromString(direction.toUpperCase());
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

		return service.getAllPaged(pageable);
	}

	@PutMapping("/{id}/deactivate")
	@Operation(summary = "Deactivate a corporate credit type")
	public void deactivate(@PathVariable Long id) {
		service.deactivate(id);
	}

	@PutMapping("/{id}/activate")
	@Operation(summary = "Activate a corporate credit type")
	public void activate(@PathVariable Long id) {
		service.activate(id);
	}

}
