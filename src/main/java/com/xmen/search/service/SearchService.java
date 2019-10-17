package com.xmen.search.service;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.xmen.search.db.IMongoDB;
import com.xmen.search.db.MongoDB;
import com.xmen.search.domain.RqIsMutant;
import com.xmen.search.domain.Statistics;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;

import static com.mongodb.client.model.Filters.eq;

@Service
public class SearchService implements ISearchService{

    @Autowired
    private IMongoDB iMongoDB;

    private static List<String> listSecuenceMutant =
            Arrays.asList(new String[]{"AAAA","TTTT","CCCC","GGGG"});


    public boolean findMutantDna(RqIsMutant rqIsMutant){

        if(!isValidRequest(rqIsMutant)){
            return false;
        }

        int total = 0;
        String arr[][] = new String[6][6];

        fillMatriz(arr,rqIsMutant);
        total = readByRowColsDiagonalMatriz(arr);

        System.out.println("contador: "+total);

        if(total>=2){
            saveDNAOk("MUTANT",rqIsMutant.getDna());
            return true;
        }

        saveDNAOk("HUMAN",rqIsMutant.getDna());
        return false;
    }

    @Override
    public Statistics getStatistics() {
        long respuesta1 = iMongoDB.find("1");
        long respuesta2 = iMongoDB.find("2");
        Statistics sta = new Statistics();
        sta.setCount_mutant_dna(respuesta1);
        sta.setCount_human_dna(respuesta2);
        sta.setRatio(respuesta1*100/respuesta2);
        return sta;
    }

    private void saveDNAOk(String type, String[] data) {
        Document doc = null;

        if(type.equals("MUTANT")){
            doc = new Document("MutantDna", Arrays.deepToString(data))
                    .append("type","1")
                    .append("dateCreate", new Date());
        }else{
            doc = new Document("HumanDna", Arrays.deepToString(data))
                    .append("type","2")
                    .append("dateCreate", new Date());
        }
        iMongoDB.save(doc);
    }

    private boolean isValidRequest(RqIsMutant rqIsMutant) {
        if(rqIsMutant.getDna().length!=6){
            return false;
        }
        return true;
    }

    private int readByRowColsDiagonalMatriz(String[][] data) {
        int count=0;
        int max=5;

        StringBuilder aux3 = new StringBuilder();
        StringBuilder aux4 = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            StringBuilder aux1 = new StringBuilder();
            StringBuilder aux2 = new StringBuilder();

            aux3.append(data[i][i]);
            aux4.append(data[i][max-i]);

            if(i==5) {
                if (isDnaMutant(aux3.toString())) {
                    count++;
                }
            }

            for (int j = 0; j < 6; j++) {
                aux1.append(data[i][j]);
                aux2.append(data[j][i]);

                if(j==5){
                    if(isDnaMutant(aux1.toString())){
                        count++;
                    }
                    if(isDnaMutant(aux2.toString())){
                        count++;
                    }

                }
            }
        }
        return count;
    }

    private boolean isDnaMutant(String data){
        for(String str: listSecuenceMutant) {
            if(data.contains(str)){
                System.out.println(data);
                return true;
            }
        }
        return false;
    }

    private void fillMatriz(String[][] arr, RqIsMutant rqIsMutant) {
        int m=6;
        IntStream.range(0,m).forEach(i->{
             String aux = rqIsMutant.getDna()[i];
                IntStream.range(0,m).forEach(j ->{
                    arr[i][j] = aux.split("(?!^)")[j];
                });
        });

    }


}
