package com.bbva.rbvd;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.rbvd.dto.dwpconnection.AuditUserDTO;
import com.bbva.rbvd.dto.dwpconnection.StatusDTO;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractRBVDT40801PETransaction extends AbstractTransaction {

	public AbstractRBVDT40801PETransaction(){
	}


	/**
	 * Return value for input parameter customerId
	 */
	protected String getCustomerid(){
		return (String)this.getParameter("customerId");
	}

	/**
	 * Return value for input parameter quotationId
	 */
	protected String getQuotationid(){
		return (String)this.getParameter("quotationId");
	}

	/**
	 * Return value for input parameter productId
	 */
	protected String getProductid(){
		return (String)this.getParameter("productId");
	}

	/**
	 * Return value for input parameter status
	 */
	protected StatusDTO getStatus(){
		return (StatusDTO)this.getParameter("status");
	}

	/**
	 * Return value for input parameter source
	 */
	protected String getSource(){
		return (String)this.getParameter("source");
	}

	/**
	 * Return value for input parameter auditUser
	 */
	protected AuditUserDTO getAudituser(){
		return (AuditUserDTO)this.getParameter("auditUser");
	}
}
