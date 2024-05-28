package com.bbva.rbvd.dto.dwpconnection.header;

import java.io.Serializable;

public class BranchDTO implements Serializable {
    private String branchId;

    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
    @Override
    public String toString() {
        return "BranchDTO{" +
                "branchId='" + branchId + '\'' +
                '}';
    }

}