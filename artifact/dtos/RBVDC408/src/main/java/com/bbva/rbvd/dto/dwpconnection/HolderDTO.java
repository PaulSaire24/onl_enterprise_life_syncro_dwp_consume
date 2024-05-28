package com.bbva.rbvd.dto.dwpconnection;

import java.io.Serializable;

public class HolderDTO implements Serializable {
    private String id;
    private IdentityDocumentDTO identityDocument;
    private static final long serialVersionUID = 1905122041950251207L;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IdentityDocumentDTO getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(IdentityDocumentDTO identityDocument) {
        this.identityDocument = identityDocument;
    }

    @Override
    public String toString() {
        return "HolderDTO{" +
                "id='" + id + '\'' +
                ", identityDocument=" + identityDocument +
                '}';
    }
}
