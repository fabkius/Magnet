package com.xmen.search.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Service;

import static com.mongodb.client.model.Filters.eq;

@Service
public class MongoDB implements IMongoDB{

    private  MongoDatabase database;

    MongoDB(){
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://fabkius:112233445566@cluster0-c2wja.mongodb.net/dna?retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase("dna");
    }

    @Override
    public void save(Document doc){
        MongoCollection<Document> collection = database.getCollection("dna");
        collection.insertOne(doc);
    }

    @Override
    public long find(String type){
        MongoCollection<Document> collection = database.getCollection("dna");
        return collection.countDocuments(eq("type",type));
    }


}
