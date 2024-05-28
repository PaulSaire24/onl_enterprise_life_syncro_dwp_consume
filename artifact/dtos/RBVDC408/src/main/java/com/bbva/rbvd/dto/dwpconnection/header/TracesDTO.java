package com.bbva.rbvd.dto.dwpconnection.header;

import java.io.Serializable;

public class TracesDTO implements Serializable {
    private String followsSpanId;
    private String parentSpanId;
    private String traceId;

    public String getFollowsSpanId() {
        return followsSpanId;
    }

    public void setFollowsSpanId(String followsSpanId) {
        this.followsSpanId = followsSpanId;
    }

    public String getParentSpanId() {
        return parentSpanId;
    }

    public void setParentSpanId(String parentSpanId) {
        this.parentSpanId = parentSpanId;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Override
    public String toString() {
        return "TracesDTO{" +
                "followsSpanId='" + followsSpanId + '\'' +
                ", parentSpanId='" + parentSpanId + '\'' +
                ", traceId='" + traceId + '\'' +
                '}';
    }
}