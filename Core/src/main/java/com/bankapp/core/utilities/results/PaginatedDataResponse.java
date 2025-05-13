package com.bankapp.core.utilities.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedDataResponse<T> {
    private List<T> items;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private Long totalItems;
    private boolean hasNextPage;
    private boolean hasPreviousPage;
    private boolean isFirstPage;
    private boolean isLastPage;
} 