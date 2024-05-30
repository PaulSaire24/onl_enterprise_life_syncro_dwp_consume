package com.bbva.rbvd;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.rbvd.dto.payroll.upsilon.body.DwpConsumeBodyDTO;
import com.bbva.rbvd.dto.payroll.upsilon.header.DwpConsumeHeaderDTO;

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
	protected DwpConsumeBodyDTO getInsuranceStatusUpdated() {return (DwpConsumeBodyDTO)this.getParameter("insuranceStatusUpdated");}
}
