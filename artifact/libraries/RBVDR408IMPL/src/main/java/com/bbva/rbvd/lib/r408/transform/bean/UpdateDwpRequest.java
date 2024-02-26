package com.bbva.rbvd.lib.r408.transform.bean;

import com.bbva.pdwy.dto.auth.salesforce.SalesforceResponseDTO;
import com.bbva.rbvd.dto.dwpconnection.DwpConsumeDTO;
import com.bbva.rbvd.dto.dwpconnection.service.salesforce.SalesForceBO;
import com.bbva.rbvd.dto.dwpconnection.service.salesforce.StatusBO;

public class UpdateDwpRequest {
    public static SalesForceBO mapRequestToSalesForceDwpBean(DwpConsumeDTO requestBody){
        SalesForceBO salesForceBO = new SalesForceBO();
        salesForceBO.setIdQuotation(requestBody.getQuotationId());
        salesForceBO.setIdCustomer(requestBody.getCustomerId());
        salesForceBO.setIdProduct(requestBody.getProductId());

        StatusBO statusBO = new StatusBO();
        statusBO.setId(requestBody.getStatus().getId());
        statusBO.setName(requestBody.getStatus().getName());
        salesForceBO.setStatus(statusBO);
        salesForceBO.setEmployeeCode(requestBody.getAuditUser().getUser());
        salesForceBO.setSource(requestBody.getSource());
        return salesForceBO;
    }
}
