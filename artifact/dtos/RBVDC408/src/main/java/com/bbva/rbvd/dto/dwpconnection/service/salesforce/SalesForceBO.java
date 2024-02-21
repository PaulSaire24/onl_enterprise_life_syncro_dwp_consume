package com.bbva.rbvd.dto.dwpconnection.service.salesforce;

import java.io.Serializable;

public class SalesForceBO implements Serializable {
    private String idQuotation;
    private String idCustomer;
    private String idProduct;
    private String idStatus;
    private String idStatusType;
    private String employeeCode;
    private String source;
    private String message;

    public String getIdQuotation() {
        return idQuotation;
    }

    public void setIdQuotation(String idQuotation) {
        this.idQuotation = idQuotation;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(String idStatus) {
        this.idStatus = idStatus;
    }

    public String getIdStatusType() {
        return idStatusType;
    }

    public void setIdStatusType(String idStatusType) {
        this.idStatusType = idStatusType;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SalesForceBO{" +
                "idQuotation='" + idQuotation + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", idProduct='" + idProduct + '\'' +
                ", idStatus='" + idStatus + '\'' +
                ", idStatusType='" + idStatusType + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", source='" + source + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
