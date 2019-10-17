package com.xmen.search.service;

import com.xmen.search.db.MongoDB;
import com.xmen.search.domain.Statistics;
import com.xmen.search.fixtures.Fixtures;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {

    @InjectMocks
    private SearchService searchService;

    @Mock
    private MongoDB IMongoDB;

    @Test
    public void shouldReturnFindMutantDnaOK(){
        boolean response = searchService.findMutantDna(Fixtures.REQUEST_ISMUTANT());
        Assert.assertEquals(response,true);
    }

    @Test
    public void shouldReturnFindMutantDnaFail(){
        boolean response = searchService.findMutantDna(Fixtures.REQUEST_ISHUMAN());
        Assert.assertEquals(response,false);
    }

    @Test
    public void shouldReturnFindOK(){
        when(IMongoDB.find(anyString())).thenReturn(Fixtures.RS_DOCUMENT());
        Statistics response = searchService.getStatistics();
        Assert.assertNotNull(response);
    }

}
