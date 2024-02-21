package com.bbva.rbvd.lib.r408;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import javax.annotation.Resource;

import com.bbva.elara.utility.api.connector.APIConnector;
import com.bbva.pdwy.dto.auth.salesforce.SalesforceResponseDTO;
import com.bbva.pdwy.lib.r008.PDWYR008;
import com.bbva.rbvd.dto.dwpconnection.AuditUserDTO;
import com.bbva.rbvd.dto.dwpconnection.DwpConsumeDTO;
import com.bbva.rbvd.dto.dwpconnection.StatusDTO;
import com.bbva.rbvd.dto.dwpconnection.service.salesforce.SalesForceBO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.aop.framework.Advised;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/RBVDR408-app.xml",
		"classpath:/META-INF/spring/RBVDR408-app-test.xml",
		"classpath:/META-INF/spring/RBVDR408-arc.xml",
		"classpath:/META-INF/spring/RBVDR408-arc-test.xml" })
public class RBVDR408Test {

	@Spy
	private Context context;

	@Resource(name = "rbvdR408")
	private RBVDR408 rbvdR408;

	@Resource(name = "pdwyR008")
	private PDWYR008 pdwyr008;

	@Resource(name = "applicationConfigurationService")
	private ApplicationConfigurationService applicationConfigurationService;

	@Resource(name = "externalApiConnector")
	private APIConnector externalApiConnector;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context = new Context();
		ThreadContext.set(context);
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.rbvdR408;
		if(this.rbvdR408 instanceof Advised){
			Advised advised = (Advised) this.rbvdR408;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	/*@Test
	public void executeTestIncokationSalesForceRestClientException(){
		SalesforceResponseDTO salesforceResponseDTO = new SalesforceResponseDTO();
		salesforceResponseDTO.setAccessToken("accessToken");
		salesforceResponseDTO.setTokenType("Bearer");

		DwpConsumeDTO dwpConsumeDTO = new DwpConsumeDTO();
		dwpConsumeDTO.setQuotationId("quotationId");
		dwpConsumeDTO.setCustomerId("customerId");
		dwpConsumeDTO.setProductId("productId");
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setId("id");
		statusDTO.setType("type");
		dwpConsumeDTO.setStatus(statusDTO);
		AuditUserDTO auditUserDTO = new AuditUserDTO();
		auditUserDTO.setUser("user");
		dwpConsumeDTO.setAuditUser(auditUserDTO);
		dwpConsumeDTO.setSource("source");
		when(pdwyr008.executeGetAuthenticationData(Mockito.anyString())).thenReturn(salesforceResponseDTO);
		when(externalApiConnector.postForEntity(anyString(), anyObject(), any())).thenThrow(new RestClientException("Rest client exception"));
		boolean validationResponse = rbvdR408.executeConsumeDWPServiceForUpdateStatus(dwpConsumeDTO);
		Assert.assertFalse(validationResponse);
		Assert.assertEquals(1, context.getAdviceList().size());
	}*/

	@Test
	public void executeTestIncokationSalesForceOk(){
		SalesforceResponseDTO salesforceResponseDTO = new SalesforceResponseDTO();
		salesforceResponseDTO.setAccessToken("accessToken");
		salesforceResponseDTO.setTokenType("Bearer");

		SalesForceBO salesForceBO = new SalesForceBO();
		salesForceBO.setMessage("Updated register");

		DwpConsumeDTO dwpConsumeDTO = new DwpConsumeDTO();
		dwpConsumeDTO.setQuotationId("quotationId");
		dwpConsumeDTO.setCustomerId("customerId");
		dwpConsumeDTO.setProductId("productId");
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setId("id");
		statusDTO.setType("type");
		dwpConsumeDTO.setStatus(statusDTO);
		AuditUserDTO auditUserDTO = new AuditUserDTO();
		auditUserDTO.setUser("user");
		dwpConsumeDTO.setAuditUser(auditUserDTO);
		dwpConsumeDTO.setSource("source");
		when(pdwyr008.executeGetAuthenticationData(Mockito.anyString())).thenReturn(salesforceResponseDTO);
		when(externalApiConnector.postForEntity(anyString(), anyObject(), (Class<SalesForceBO>) any())).thenReturn(new ResponseEntity<>(salesForceBO, HttpStatus.OK));
		boolean validationResponse = rbvdR408.executeConsumeDWPServiceForUpdateStatus(dwpConsumeDTO);
		Assert.assertTrue(validationResponse);
		Assert.assertEquals(0, context.getAdviceList().size());
	}

	@Test
	public void executeTestIncokationSalesForceNullResponse(){
		SalesforceResponseDTO salesforceResponseDTO = new SalesforceResponseDTO();
		salesforceResponseDTO.setAccessToken("accessToken");
		salesforceResponseDTO.setTokenType("Bearer");

		SalesForceBO salesForceBO = new SalesForceBO();
		salesForceBO.setMessage("Updated register");

		DwpConsumeDTO dwpConsumeDTO = new DwpConsumeDTO();
		dwpConsumeDTO.setQuotationId("quotationId");
		dwpConsumeDTO.setCustomerId("customerId");
		dwpConsumeDTO.setProductId("productId");
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setId("id");
		statusDTO.setType("type");
		dwpConsumeDTO.setStatus(statusDTO);
		AuditUserDTO auditUserDTO = new AuditUserDTO();
		auditUserDTO.setUser("user");
		dwpConsumeDTO.setAuditUser(auditUserDTO);
		dwpConsumeDTO.setSource("source");
		when(pdwyr008.executeGetAuthenticationData(Mockito.anyString())).thenReturn(salesforceResponseDTO);
		when(externalApiConnector.postForEntity(anyString(), anyObject(), (Class<SalesForceBO>) any())).thenReturn(new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
		boolean validationResponse = rbvdR408.executeConsumeDWPServiceForUpdateStatus(dwpConsumeDTO);
		Assert.assertFalse(validationResponse);
		Assert.assertEquals(0, context.getAdviceList().size());
	}

	@Test
	public void executeTestIncokationSalesForceBadRequestResponse(){
		SalesforceResponseDTO salesforceResponseDTO = new SalesforceResponseDTO();
		salesforceResponseDTO.setAccessToken("accessToken");
		salesforceResponseDTO.setTokenType("Bearer");

		SalesForceBO salesForceBO = new SalesForceBO();
		salesForceBO.setMessage("Not Updated register");

		DwpConsumeDTO dwpConsumeDTO = new DwpConsumeDTO();
		dwpConsumeDTO.setQuotationId("quotationId");
		dwpConsumeDTO.setCustomerId("customerId");
		dwpConsumeDTO.setProductId("productId");
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setId("id");
		statusDTO.setType("type");
		dwpConsumeDTO.setStatus(statusDTO);
		AuditUserDTO auditUserDTO = new AuditUserDTO();
		auditUserDTO.setUser("user");
		dwpConsumeDTO.setAuditUser(auditUserDTO);
		dwpConsumeDTO.setSource("source");
		when(pdwyr008.executeGetAuthenticationData(Mockito.anyString())).thenReturn(salesforceResponseDTO);
		when(externalApiConnector.postForEntity(anyString(), anyObject(), (Class<SalesForceBO>) any())).thenReturn(new ResponseEntity<>(salesForceBO, HttpStatus.BAD_REQUEST));
		boolean validationResponse = rbvdR408.executeConsumeDWPServiceForUpdateStatus(dwpConsumeDTO);
		Assert.assertFalse(validationResponse);
		Assert.assertEquals(0, context.getAdviceList().size());
	}

	@Test
	public void executeTestIncokationSalesForceBadRequestNullMessageResponse(){
		SalesforceResponseDTO salesforceResponseDTO = new SalesforceResponseDTO();
		salesforceResponseDTO.setAccessToken("accessToken");
		salesforceResponseDTO.setTokenType("Bearer");

		SalesForceBO salesForceBO = new SalesForceBO();

		DwpConsumeDTO dwpConsumeDTO = new DwpConsumeDTO();
		dwpConsumeDTO.setQuotationId("quotationId");
		dwpConsumeDTO.setCustomerId("customerId");
		dwpConsumeDTO.setProductId("productId");
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setId("id");
		statusDTO.setType("type");
		dwpConsumeDTO.setStatus(statusDTO);
		AuditUserDTO auditUserDTO = new AuditUserDTO();
		auditUserDTO.setUser("user");
		dwpConsumeDTO.setAuditUser(auditUserDTO);
		dwpConsumeDTO.setSource("source");
		when(pdwyr008.executeGetAuthenticationData(Mockito.anyString())).thenReturn(salesforceResponseDTO);
		when(externalApiConnector.postForEntity(anyString(), anyObject(), (Class<SalesForceBO>) any())).thenReturn(new ResponseEntity<>(salesForceBO, HttpStatus.BAD_REQUEST));
		boolean validationResponse = rbvdR408.executeConsumeDWPServiceForUpdateStatus(dwpConsumeDTO);
		Assert.assertFalse(validationResponse);
		Assert.assertEquals(0, context.getAdviceList().size());
	}
	
}
