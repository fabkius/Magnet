package com.xmen.search.domain;

import org.junit.Assert;
import org.junit.Test;

public class RqIsMutantTest {

    @Test
    public void RqIsMutantOK(){
        RqIsMutant rq = new  RqIsMutant();
        rq.setDna(new String[]{"AAAA","TTTT","CCCC","GGGG"});
        Assert.assertEquals(rq.getDna()[0],"AAAA");
    }
}
