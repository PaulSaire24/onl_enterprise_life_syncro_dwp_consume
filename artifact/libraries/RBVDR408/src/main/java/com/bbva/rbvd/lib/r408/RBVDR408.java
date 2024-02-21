package com.bbva.rbvd.lib.r408;

import com.bbva.rbvd.dto.dwpconnection.DwpConsumeDTO;

/**
 * The  interface RBVDR408 class...
 */
public interface RBVDR408 {

	/**
	 * The execute method...
	 */
	boolean executeConsumeDWPServiceForUpdateStatus(DwpConsumeDTO requestBody);

}
