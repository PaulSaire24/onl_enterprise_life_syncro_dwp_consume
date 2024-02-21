package com.bbva.rbvd.dto.dwpconnection;

import java.io.Serializable;

public class DwpConsumeDTO implements Serializable {
    private String customerId;
    private String quotationId;
    private String productId;
    private StatusDTO status;
    private String source;
    private AuditUserDTO auditUser;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public AuditUserDTO getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(AuditUserDTO auditUser) {
        this.auditUser = auditUser;
    }

    @Override
    public String toString() {
        return "DwpConsumeDTO{" +
                "customerId='" + customerId + '\'' +
                ", quotationId='" + quotationId + '\'' +
                ", productId='" + productId + '\'' +
                ", status=" + status +
                ", source='" + source + '\'' +
                ", auditUser=" + auditUser +
                '}';
    }
}
