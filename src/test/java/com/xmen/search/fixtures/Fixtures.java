package com.xmen.search.fixtures;

import com.mongodb.client.MongoCollection;
import com.xmen.search.domain.RqIsMutant;
import org.bson.Document;

public class Fixtures {

    public static RqIsMutant REQUEST_ISMUTANT() {
        RqIsMutant rq = new RqIsMutant();
        rq.setDna(new String[]{"ATGCGA", "CAGTGC", "TTATGT","AGAAGG","CCCCTA","TCACTG"});
        return rq;
    }

    public static Long RS_DOCUMENT() {
        return Long.valueOf(3);
    }

    public static RqIsMutant REQUEST_ISHUMAN() {
        RqIsMutant rq = new RqIsMutant();
        rq.setDna(new String[]{"ATACGA", "GAGAGC", "TTAGGT","AGCATG","CACCTA","GCACTG"});
        return rq;
    }
}
