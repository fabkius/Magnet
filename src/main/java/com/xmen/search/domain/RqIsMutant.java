package com.xmen.search.domain;

import java.util.Arrays;

public class RqIsMutant {

    private String[] dna;

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    @Override
    public String toString() {
        return "RqIsMutant{" +
                "dna=" + Arrays.toString(dna) +
                '}';
    }
}
