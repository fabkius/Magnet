package com.xmen.search.service;

import com.xmen.search.domain.RqIsMutant;
import com.xmen.search.domain.Statistics;

public interface ISearchService {
    boolean findMutantDna(RqIsMutant rqIsMutant);
    Statistics getStatistics();
}
