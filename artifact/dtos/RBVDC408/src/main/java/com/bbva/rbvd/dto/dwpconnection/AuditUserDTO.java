package com.bbva.rbvd.dto.dwpconnection;

import java.io.Serializable;

public class AuditUserDTO implements Serializable {
    private String user;
    private String date;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AuditUserDTO{" +
                "user='" + user + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
