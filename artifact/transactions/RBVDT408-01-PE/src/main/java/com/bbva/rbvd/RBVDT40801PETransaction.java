package com.bbva.rbvd;

import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;
import com.bbva.rbvd.dto.dwpconnection.DwpConsumeDTO;
import com.bbva.rbvd.lib.r408.RBVDR408;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Trx to consume messages from event to update DWP status.
 *
 */
public class RBVDT40801PETransaction extends AbstractRBVDT40801PETransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(RBVDT40801PETransaction.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		RBVDR408 rbvdR408 = this.getServiceLibrary(RBVDR408.class);
		// TODO - Implementation of business logic
		DwpConsumeDTO requestEventBody;
		requestEventBody = this.getInsuranceStatusUpdated();

		boolean response = rbvdR408.executeConsumeDWPServiceForUpdateStatus(requestEventBody);

		if(response){
			LOGGER.info("[RBVDT40801PE] Excecuting OK ...");
			this.setHttpResponseCode(HttpResponseCode.HTTP_CODE_200, Severity.OK);
		}else{
			this.setSeverity(Severity.ENR);
		}
	}

}
