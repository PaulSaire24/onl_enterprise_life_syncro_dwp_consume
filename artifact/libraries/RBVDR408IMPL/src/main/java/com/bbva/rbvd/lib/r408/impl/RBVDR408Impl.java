package com.bbva.rbvd.lib.r408.impl;

import com.bbva.pdwy.dto.auth.salesforce.SalesforceResponseDTO;
import com.bbva.rbvd.dto.payroll.salesforce.SalesForceBO;
import com.bbva.rbvd.dto.payroll.upsilon.body.DwpConsumeBodyDTO;
import com.bbva.rbvd.lib.r408.impl.util.JsonHelper;
import com.bbva.rbvd.lib.r408.transform.bean.UpdateDwpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * The RBVDR408Impl class...
 */
public class RBVDR408Impl extends RBVDR408Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(RBVDR408Impl.class);
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String SERVICE_CONNECTION_PROPERTY = "dwpUpdateSalesForce";
	@Override
	public boolean executeConsumeDWPServiceForUpdateStatus(DwpConsumeBodyDTO requestBody) {
		LOGGER.info("***** RBVDR408Impl - executeConsumeDWPServiceForUpdateStatus START *****");
		LOGGER.info("***** RBVDR408Impl - invoke - pdwyR008.executeGetAuthenticationData ***** Param: {}", "dwpWServiceToken");
		SalesforceResponseDTO authentication =  pdwyR008.executeGetAuthenticationData(SERVICE_CONNECTION_PROPERTY);
		LOGGER.info("***** RBVDR408Impl - authentication data dto ***** {}", authentication);
		SalesForceBO requestBO = UpdateDwpRequest.mapRequestToSalesForceDwpBean(requestBody);

		String jsonString = this.getRequestBodyAsJsonFormat(requestBO);
		LOGGER.info("***** RBVDR408Impl - executeConsumeDWPServiceForUpdateStatus ***** Param: {}", jsonString);
			HttpEntity<String> entity = new HttpEntity<>(jsonString, createHttpHeaders(authentication));
		try {
			ResponseEntity<SalesForceBO> responseEntity = this.externalApiConnector.postForEntity(SERVICE_CONNECTION_PROPERTY, entity,
					SalesForceBO.class);
			if(Objects.isNull(responseEntity.getBody())){
				LOGGER.info("***** RBVDR408Impl - executeConsumeDWPServiceForUpdateStatus END - NULL RESPONSE SALESFORCE API *****");
				return false;
			}
			LOGGER.info("***** RBVDR408Impl - executeConsumeDWPServiceForUpdateStatus ***** Response: {}", getRequestBodyAsJsonFormat(responseEntity.getBody()));
			LOGGER.info("***** RBVDR408Impl - executeConsumeDWPServiceForUpdateStatus END *****");
			return Objects.nonNull(responseEntity.getBody().getMessage()) && responseEntity.getStatusCode().equals(HttpStatus.OK);
		} catch (RestClientException ex) {
			this.addAdviceWithDescription("RBVD10094960",ex.getMessage());
			LOGGER.info("***** RBVDR408Impl - executeConsumeDWPServiceForUpdateStatus ***** Exception: {}", ex.getMessage());
			return false;
		}
	}

	private String getRequestBodyAsJsonFormat(Object requestBody) {
		return JsonHelper.getInstance().toJsonString(requestBody);
	}

	private HttpHeaders createHttpHeaders(SalesforceResponseDTO authorizationData) {
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = new MediaType("application","json", StandardCharsets.UTF_8);
		headers.setContentType(mediaType);
		headers.set(AUTHORIZATION_HEADER,
				authorizationData.getTokenType().concat(" ").
						concat(authorizationData.getAccessToken()));
		return headers;
	}
}
