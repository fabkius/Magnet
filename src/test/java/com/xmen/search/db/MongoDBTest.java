package com.xmen.search.db;

import org.bson.Document;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest
@RunWith(MockitoJUnitRunner.class)
public class MongoDBTest {

    @Mock
    private MongoDB mongoDB;

    @Test
    public void shouldReturnSaveOK(){
        mongoDB.save(new Document());
    }

    @Test
    public void shouldReturnFindOK(){
        long response = mongoDB.find("0");
        Assert.assertNotNull(response);
    }
}
