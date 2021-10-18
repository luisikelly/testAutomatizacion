package automationcraft.engine.database;


import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Aggregates.limit;

public class MongoDBManage {
    public MongoDBManage(String databaseName){
        this.databaseName = databaseName;
    }
    ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:Gl7VPtk1saZBYPx8@cluster0-automationcraf.yyz8v.mongodb.net/test?retryWrites=true&w=majority");
    private final String databaseName;

    public void insertObject(String collectionName, Object data, Class className){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client,databaseName);
        MongoCollection<Object> collection = database.getCollection(collectionName,className);
        collection.insertOne(data);
    }
    public void insertObjects(String collectionName,List<Object> data,Class className){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client,databaseName);
        MongoCollection<Object> collection = database.getCollection(collectionName,className);
        collection.insertMany(data);
    }
    public void insertDocument(String collectionName,Document data){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client,databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(data);
    }
    public void insertDocuments(String collectionName,List<Document> data){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client,databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertMany(data);
    }

    public List<Document> getDocuments(Document queryFilter, String collectionName){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client,databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        List<Document> documents = new ArrayList<>();
        collection.find(queryFilter).into(documents);
        return documents ;
    }

    public void update(Document query,Document change, String collectionName){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client,databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.updateOne(query,new Document("$set",change));
    }
    public void deleteDocument(Document query, String collectionName){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client,databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.deleteOne(query);
        Assert.assertNull(collection.find(query));
    }

    public void deleteDocuments(Document query, String collectionName){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client,databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.deleteMany(query);
    }

    public Document getLastDocument(String collectionName){
        MongoClient client = MongoDBConfig.mongoClient(connectionString);
        MongoDatabase database = MongoDBConfig.mongoDatabase(client,databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return  collection.find().sort(new Document("_id", -1)).first();
    }

}
