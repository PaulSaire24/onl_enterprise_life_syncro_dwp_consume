package com.bbva.rbvd;

import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.TransactionParameter;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.body.CommonRequestBody;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;
import com.bbva.elara.test.osgi.DummyBundleContext;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import com.bbva.rbvd.lib.r408.RBVDR408;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Test for transaction RBVDT40801PETransaction
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/elara-test.xml",
		"classpath:/META-INF/spring/RBVDT40801PETest.xml" })
public class RBVDT40801PETransactionTest {

	@Autowired
	private RBVDT40801PETransaction transaction;

	@Resource(name = "dummyBundleContext")
	private DummyBundleContext bundleContext;

	@Mock
	private CommonRequestHeader header;

	@Mock
	private TransactionRequest transactionRequest;

	@Resource(name = "rbvdR408")
	private RBVDR408 rbvdr408;

	@Before
	public void initializeClass() throws Exception {
		// Initializing mocks
		MockitoAnnotations.initMocks(this);
		// Start BundleContext
		this.transaction.start(bundleContext);
		// Setting Context
		this.transaction.setContext(new Context());
		// Set Body
		CommonRequestBody commonRequestBody = new CommonRequestBody();
		commonRequestBody.setTransactionParameters(new ArrayList<>());
		this.transactionRequest.setBody(commonRequestBody);
		// Set Header Mock
		this.transactionRequest.setHeader(header);
		// Set TransactionRequest
		this.transaction.getContext().setTransactionRequest(transactionRequest);
	}

	@Test
	public void testNotNull(){
	    // Example to Mock the Header
		// Mockito.doReturn("ES").when(header).getHeaderParameter(RequestHeaderParamsName.COUNTRYCODE);
		Assert.assertNotNull(this.transaction);
		this.transaction.execute();
	}

	@Test
	public void executeTestOk(){
		Mockito.when(rbvdr408.executeConsumeDWPServiceForUpdateStatus(Mockito.anyObject())).thenReturn(true);
		this.transaction.execute();
		Assert.assertEquals(Severity.OK.getValue(),this.transaction.getContext().getSeverity().getValue());
		Assert.assertNotNull(this.transaction);
	}

	@Test
	public void executeTestError(){
		Mockito.when(rbvdr408.executeConsumeDWPServiceForUpdateStatus(Mockito.anyObject())).thenReturn(false);
		this.transaction.execute();
		assertEquals(Severity.ENR.getValue(), this.transaction.getSeverity().getValue());
	}

	// Add Parameter to Transaction
	private void addParameter(final String parameter, final Object value) {
		final TransactionParameter tParameter = new TransactionParameter(parameter, value);
		transaction.getContext().getParameterList().put(parameter, tParameter);
	}

	// Get Parameter from Transaction
	private Object getParameter(final String parameter) {
		final TransactionParameter param = transaction.getContext().getParameterList().get(parameter);
		return param != null ? param.getValue() : null;
	}
}
