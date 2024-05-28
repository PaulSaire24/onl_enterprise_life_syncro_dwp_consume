package com.bbva.rbvd.dto.dwpconnection;

public class HolderDTO {
    private String id;
    private IdentityDocumentDTO identityDocument;

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
