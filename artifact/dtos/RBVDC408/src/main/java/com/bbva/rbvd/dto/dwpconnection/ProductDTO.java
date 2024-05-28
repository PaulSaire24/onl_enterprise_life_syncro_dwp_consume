package com.bbva.rbvd.dto.dwpconnection;

import java.io.Serializable;

public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id='" + id + '\'' +
                '}';
    }
}
