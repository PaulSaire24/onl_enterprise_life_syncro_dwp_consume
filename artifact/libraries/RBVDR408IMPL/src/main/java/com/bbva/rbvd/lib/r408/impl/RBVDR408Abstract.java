package com.bbva.rbvd.lib.r408.impl;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.elara.utility.api.connector.APIConnector;
import com.bbva.elara.utility.api.connector.APIConnectorBuilder;
import com.bbva.pdwy.lib.r008.PDWYR008;
import com.bbva.rbvd.lib.r408.RBVDR408;

/**
 * This class automatically defines the libraries and utilities that it will use.
 */
public abstract class RBVDR408Abstract extends AbstractLibrary implements RBVDR408 {

	protected ApplicationConfigurationService applicationConfigurationService;

	protected APIConnector externalApiConnector;

	protected APIConnectorBuilder apiConnectorBuilder;

	protected PDWYR008 pdwyR008;


	/**
	* @param applicationConfigurationService the this.applicationConfigurationService to set
	*/
	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

	/**
	* @param externalApiConnector the this.externalApiConnector to set
	*/
	public void setExternalApiConnector(APIConnector externalApiConnector) {
		this.externalApiConnector = externalApiConnector;
	}

	/**
	* @param apiConnectorBuilder the this.apiConnectorBuilder to set
	*/
	public void setApiConnectorBuilder(APIConnectorBuilder apiConnectorBuilder) {
		this.apiConnectorBuilder = apiConnectorBuilder;
	}

	/**
	* @param pdwyR008 the this.pdwyR008 to set
	*/
	public void setPdwyR008(PDWYR008 pdwyR008) {
		this.pdwyR008 = pdwyR008;
	}

}