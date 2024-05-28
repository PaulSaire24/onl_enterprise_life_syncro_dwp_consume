package com.bbva.rbvd.dto.dwpconnection;

import java.io.Serializable;

public class DocumentTypeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "DocumentTypeDTO{" +
                "id='" + id + '\'' +
                ", name='" + number + '\'' +
                '}';
    }
}
