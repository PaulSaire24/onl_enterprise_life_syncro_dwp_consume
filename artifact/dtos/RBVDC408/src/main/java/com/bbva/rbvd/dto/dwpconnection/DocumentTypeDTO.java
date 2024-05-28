package com.bbva.rbvd.dto.dwpconnection;

public class DocumentTypeDTO {
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
