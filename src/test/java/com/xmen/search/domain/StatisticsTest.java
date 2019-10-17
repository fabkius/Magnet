package com.xmen.search.domain;

import org.junit.Assert;
import org.junit.Test;

public class StatisticsTest {

    @Test
    public void StatisticsOK(){
        Statistics s = new Statistics();
        s.setCount_human_dna(5);
        s.setCount_mutant_dna(2);
        s.setRatio(10);

        Assert.assertEquals(s.getCount_human_dna(),5);
        Assert.assertEquals(s.getCount_mutant_dna(),2);
        Assert.assertNotNull(s.getRatio());
    }

}
