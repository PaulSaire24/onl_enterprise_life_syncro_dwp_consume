package com.bbva.rbvd.dto.dwpconnection;

import java.io.Serializable;
import java.util.Date;

public class DwpConsumeDTO implements Serializable {
    private String customerId;
    private String quotationId;
    private String quotationIdReference;
    private ProductDTO product;
    private StatusDTO status;
    private String sourcePayroll;
    private AuditUserDTO auditUser;
    private ChannelDTO channel;
    private Date operationDate;
    private HolderDTO holder;

    public String getQuotationId() {
        return quotationId;
    }
    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getQuotationIdReference() {
        return quotationIdReference;
    }

    public void setQuotationIdReference(String quotationIdReference) {
        this.quotationIdReference = quotationIdReference;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public String getSourcePayroll() {
        return sourcePayroll;
    }

    public void setSourcePayroll(String sourcePayroll) {
        this.sourcePayroll = sourcePayroll;
    }

    public AuditUserDTO getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(AuditUserDTO auditUser) {
        this.auditUser = auditUser;
    }

    public ChannelDTO getChannel() {
        return channel;
    }

    public void setChannel(ChannelDTO channel) {
        this.channel = channel;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public HolderDTO getHolder() {
        return holder;
    }

    public void setHolder(HolderDTO holder) {
        this.holder = holder;
    }

    @Override
    public String toString() {
        return "DwpConsumeDTO{" +
                "customerId='" + customerId + '\'' +
                ", quotationId='" + quotationId + '\'' +
                ", quotationIdReference='" + quotationIdReference + '\'' +
                ", product=" + product +
                ", status=" + status +
                ", sourcePayroll='" + sourcePayroll + '\'' +
                ", auditUser=" + auditUser +
                ", channel=" + channel +
                ", operationDate='" + operationDate + '\'' +
                ", holder=" + holder +
                '}';
    }
}