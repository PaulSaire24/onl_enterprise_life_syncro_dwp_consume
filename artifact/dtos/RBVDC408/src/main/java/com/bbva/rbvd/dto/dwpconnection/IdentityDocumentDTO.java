package com.bbva.rbvd.dto.dwpconnection;

import java.io.Serializable;

public class IdentityDocumentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private DocumentTypeDTO documentType;

    public DocumentTypeDTO getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeDTO documentType) {
        this.documentType = documentType;
    }

    @Override
    public String toString() {
        return "IdentityDocumentDTO{" +
                "documentType=" + documentType +
                '}';
    }
}
