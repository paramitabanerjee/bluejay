package com.dao;

import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by m840378 on 4/13/18.
 */
@Service
public class MyDataDao {

    /*
    CREATE TABLE my_data (
    id INT PRIMARY KEY,
    message_data TEXT
);
     */

    @Autowired
    private CassandraConnector cassandraConnector;

    public void saveData(List<String> messages) {

        if(messages==null || messages.isEmpty()) {
            return;
        }
        try {
            cassandraConnector.connect();

            Session session = cassandraConnector.getSession();


            StringBuilder sb = new StringBuilder("BEGIN BATCH ");
            messages.forEach(message -> {
                UUID uuid = UUID.randomUUID();

                sb.append("INSERT INTO my_cass_keyspace.my_data ")
                .append("(id, message_data) ")
                .append("VALUES (").append(uuid).append(", '")
                .append(message).append("');");
            });
            sb.append("APPLY BATCH;");

            String query = sb.toString();
            session.execute(query);

            session.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }


    }
}
