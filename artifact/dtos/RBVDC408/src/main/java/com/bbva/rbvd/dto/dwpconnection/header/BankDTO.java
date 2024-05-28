package com.bbva.rbvd.dto.dwpconnection.header;

import java.io.Serializable;

public class BankDTO implements Serializable {
    private String bankId;
    private BranchDTO branch;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public BranchDTO getBranch() {
        return branch;
    }

    public void setBranch(BranchDTO branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "BankDTO{" +
                "bankId='" + bankId + '\'' +
                ", branch=" + branch +
                '}';
    }
}