package com.bbva.rbvd.dto.dwpconnection.header;

import java.io.Serializable;

public class FlagDTO implements Serializable {
    private String debug;
    private String test;

    public String getDebug() {
        return debug;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "FlagDTO{" +
                "debug='" + debug + '\'' +
                ", test='" + test + '\'' +
                '}';
    }
}