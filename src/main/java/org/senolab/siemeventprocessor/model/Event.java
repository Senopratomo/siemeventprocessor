package org.senolab.siemeventprocessor.model;

public class Event {
    String type;
    String format;
    String version;
    AttackData attackData;
    HttpMessage httpMessage;
    Geo geo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public AttackData getAttackData() {
        return attackData;
    }

    public void setAttackData(AttackData attackData) {
        this.attackData = attackData;
    }

    public HttpMessage getHttpMessage() {
        return httpMessage;
    }

    public void setHttpMessage(HttpMessage httpMessage) {
        this.httpMessage = httpMessage;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "Event{" +
                "type='" + type + '\'' +
                ", format='" + format + '\'' +
                ", version='" + version + '\'' +
                ", attackData=" + attackData +
                ", httpMessage=" + httpMessage +
                ", geo=" + geo +
                '}';
    }
}
