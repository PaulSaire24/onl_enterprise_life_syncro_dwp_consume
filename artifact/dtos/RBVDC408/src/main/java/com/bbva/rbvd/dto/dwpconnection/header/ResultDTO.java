package com.bbva.rbvd.dto.dwpconnection.header;

import java.io.Serializable;

public class ResultDTO implements Serializable {
    private String returnCode;
    private String returnDefinition;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnDefinition() {
        return returnDefinition;
    }

    public void setReturnDefinition(String returnDefinition) {
        this.returnDefinition = returnDefinition;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "returnCode='" + returnCode + '\'' +
                ", returnDefinition='" + returnDefinition + '\'' +
                '}';
    }
}