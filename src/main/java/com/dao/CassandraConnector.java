package com.dao;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by m840378 on 4/13/18.
 */

@Service
public class CassandraConnector {

    @Value("${cassandra.node}")
    private String node;
    @Value("${cassandra.port}")
    private String port;

    private Cluster cluster;

    private Session session;

    public void connect() {
        Cluster.Builder b = Cluster.builder().addContactPoint(node);
        if (port != null) {
            b.withPort(Integer.parseInt(port));
        }
        cluster = b.build();

        session = cluster.connect();
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}
