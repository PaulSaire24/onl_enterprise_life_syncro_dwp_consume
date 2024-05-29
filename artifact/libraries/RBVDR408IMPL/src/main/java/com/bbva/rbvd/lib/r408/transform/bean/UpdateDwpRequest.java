package com.bbva.rbvd.lib.r408.transform.bean;


import com.bbva.rbvd.dto.payroll.dto.DescriptionDTO;
import com.bbva.rbvd.dto.payroll.salesforce.SalesForceBO;
import com.bbva.rbvd.dto.payroll.upsilon.body.AuditUserDTO;
import com.bbva.rbvd.dto.payroll.upsilon.body.DwpConsumeDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UpdateDwpRequest {
    private UpdateDwpRequest(){}

    public static SalesForceBO mapRequestToSalesForceDwpBean(DwpConsumeDTO requestBody){
        SalesForceBO salesForceBO = new SalesForceBO();
        salesForceBO.setQuotationId(requestBody.getQuotationId());
        salesForceBO.setCustomerId(requestBody.getCustomerId());
        salesForceBO.setQuotationIdRef(requestBody.getQuotationIdReference());
        salesForceBO.setProductId(requestBody.getProduct().getId());

        DescriptionDTO statusBO = new DescriptionDTO();
        statusBO.setId(requestBody.getStatus().getId());
        statusBO.setName(requestBody.getStatus().getName());
        salesForceBO.setStatus(statusBO);


        salesForceBO.setAuditUser(requestBody.getAuditUser());
        salesForceBO.setChannel(requestBody.getChannel());

        LocalDate currentDate = LocalDate.now();

        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        salesForceBO.setOperationDate(formattedDate);

        salesForceBO.setSourcePayroll(requestBody.getSourcePayroll());

        return salesForceBO;
    }
}
