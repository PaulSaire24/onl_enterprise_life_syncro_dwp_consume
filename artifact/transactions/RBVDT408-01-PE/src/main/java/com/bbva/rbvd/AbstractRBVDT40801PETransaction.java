package com.bbva.rbvd;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.rbvd.dto.dwpconnection.DwpConsumeDTO;
import com.bbva.rbvd.dto.dwpconnection.header.DwpConsumeHeaderDTO;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractRBVDT40801PETransaction extends AbstractTransaction {

	public AbstractRBVDT40801PETransaction(){
	}


	/**
	 * Return value for input parameter header
	 */
	protected DwpConsumeHeaderDTO getHeader() { return (DwpConsumeHeaderDTO)this.getParameter("header");}

	/**
	 * Return value for input parameter insuranceStatusUpdated
	 */
	protected DwpConsumeDTO getInsuranceStatusUpdated() {return (DwpConsumeDTO)this.getParameter("insuranceStatusUpdated");}
}
