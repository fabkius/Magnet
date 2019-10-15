package com.xmen.search.service;

import com.xmen.search.domain.RqIsMutant;
import org.ejml.simple.SimpleMatrix;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;

@Service
public class SearchService implements ISearchService{

    public boolean findMutantDna(RqIsMutant rqIsMutant){

        String arr[][] = new String[6][6];

        fillMatriz(arr,rqIsMutant);

        boolean result = readMatrix(arr);

        System.out.println(Arrays.deepToString(arr));

        return result;
    }

    private boolean readMatrix(String[][] data) {
        String aux[] = new String[6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                aux[j] = data[i][j];
                if(j==5){
                    if(StringUtils.removeDuplicateStrings(aux).length==2){
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private void fillMatriz(String[][] arr, RqIsMutant rqIsMutant) {
        String aux;
        for (int i = 0; i < 6; i++) {
            aux = rqIsMutant.getDna()[i];
            for (int j = 0; j < 6; j++) {
                arr[i][j] = aux.split("(?!^)")[j];
            }
        }
    }


}
