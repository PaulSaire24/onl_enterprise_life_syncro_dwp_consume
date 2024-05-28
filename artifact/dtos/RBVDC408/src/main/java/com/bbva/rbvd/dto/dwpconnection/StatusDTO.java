package com.bbva.rbvd.dto.dwpconnection;

import java.io.Serializable;

public class StatusDTO implements Serializable {
    private String id;
    private String name;
    private String statusType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    @Override
    public String toString() {
        return "StatusDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + statusType + '\'' +
                '}';
    }
}
