package com.xmen.search.rest;

import com.xmen.search.domain.RqIsMutant;
import com.xmen.search.fixtures.Fixtures;
import com.xmen.search.service.SearchService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class findControllerTest {

    @InjectMocks
    private FindController findController;

    @Mock
    private SearchService iSearchService;

    @Test
    public void shouldReturnisMutantOK(){
        when(iSearchService.findMutantDna(any(RqIsMutant.class))).thenReturn(true);
        ResponseEntity response = findController.isMutant(Fixtures.REQUEST_ISMUTANT());
        Assert.assertEquals(response.getStatusCode().value(),200);
    }

    @Test
    public void shouldReturnisMutantFail(){
        when(iSearchService.findMutantDna(any(RqIsMutant.class))).thenReturn(false);
        ResponseEntity response = findController.isMutant(Fixtures.REQUEST_ISMUTANT());
        Assert.assertEquals(response.getStatusCode().value(),403);
    }
}
