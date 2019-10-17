package com.xmen.search.rest;

import com.xmen.search.domain.RqIsMutant;
import com.xmen.search.domain.Statistics;
import com.xmen.search.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FindController {

    @Autowired
    private ISearchService iSearchService;

    @PostMapping("/mutant/")
    public ResponseEntity isMutant(@RequestBody RqIsMutant rqIsMutant){
        if(iSearchService.findMutantDna(rqIsMutant)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }


    @GetMapping("/stats")
    public Statistics getStats(){
       return iSearchService.getStatistics();
    }
}
