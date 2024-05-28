package com.bbva.rbvd.dto.dwpconnection.header;

import java.io.Serializable;

public class DwpConsumeHeaderDTO implements Serializable {
    private EventDTO event;
    private FlagDTO flag;
    private OriginDTO origin;
    private ResultDTO result;
    private TracesDTO traces;
    private String version;

    // getters and setters for the new fields

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public FlagDTO getFlag() {
        return flag;
    }

    public void setFlag(FlagDTO flag) {
        this.flag = flag;
    }

    public OriginDTO getOrigin() {
        return origin;
    }

    public void setOrigin(OriginDTO origin) {
        this.origin = origin;
    }

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }

    public TracesDTO getTraces() {
        return traces;
    }

    public void setTraces(TracesDTO traces) {
        this.traces = traces;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "DwpConsumeHeaderDTO{" +
                "event=" + event +
                ", flag=" + flag +
                ", origin=" + origin +
                ", result=" + result +
                ", traces=" + traces +
                ", version='" + version + '\'' +
                '}';
    }
}