package com.demo.upload.dto;

import javax.persistence.*;

@Entity
@Table(name = "event_log")
public class LogRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long log_id;

    @Column(name = "id")
    private String id;

    @Column(name = "state")
    private String state;

    @Column(name = "type")
    private String type;

    @Column(name = "host")
    private long host;

    @Column(name = "timestamp")
    private long timestamp;

    public LogRequest() {}

    public LogRequest(String id, String state, String type, long host, long timestamp) {
        this.id = id;
        this.state = state;
        this.type = type;
        this.host = host;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getHost() {
        return host;
    }

    public void setHost(long host) {
        this.host = host;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
