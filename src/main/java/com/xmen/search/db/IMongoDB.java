package com.xmen.search.db;

import org.bson.Document;

public interface IMongoDB {
    void save(Document doc);
    long find(String s);
}
