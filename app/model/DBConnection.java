package model;


import com.google.inject.Inject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.jongo.Jongo;
import com.typesafe.config.Config;


/**
 *  Conexión con la Base de datos Mongo DB
 */
public class DBConnection {

    private Jongo jongo;
    private Config configuration;


    @Inject
    public DBConnection(Config configuration) {
        this.configuration = configuration;
    }

    public Jongo getConnection(){
       jongo = new Jongo(createConnection());
       return jongo;
    }

    private MongoClientURI URI(){
        String URI = "DataBase.uri";
        final String uriKey = configuration.getString(URI);
        return new MongoClientURI(uriKey);
    }

    private DB createConnection(){
        String NAME_DATABASE_PATH = "DataBase.name";
        final String databaseKey = configuration.getString(NAME_DATABASE_PATH);
        final MongoClient client = new MongoClient(URI());
        return new DB(client,databaseKey);
    }


}
