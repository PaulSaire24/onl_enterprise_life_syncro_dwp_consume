package com.bbva.rbvd.dto.dwpconnection;

public class IdentityDocumentDTO {
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
