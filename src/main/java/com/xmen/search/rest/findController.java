package com.xmen.search.rest;

import com.xmen.search.domain.RqIsMutant;
import com.xmen.search.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class findController {

    @Autowired
    private ISearchService iSearchService;

    @PostMapping("/mutant/")
    public boolean isMutant(@RequestBody RqIsMutant rqIsMutant){
        return iSearchService.findMutantDna(rqIsMutant);
    }
}
