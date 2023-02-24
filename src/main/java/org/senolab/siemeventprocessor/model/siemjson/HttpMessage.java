package org.senolab.siemeventprocessor.model.siemjson;

public class HttpMessage {
    String requestId;
    String start;
    String protocol;
    String tls;
    String method;
    String host;
    String port;
    String path;
    String query;
    String requestHeaders;
    String status;
    String bytes;
    String responseHeaders;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getTls() {
        return tls;
    }

    public void setTls(String tls) {
        this.tls = tls;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(String requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }

    public String getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(String responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    @Override
    public String toString() {
        return "HttpMessage{" +
                "requestId='" + requestId + '\'' +
                ", start='" + start + '\'' +
                ", protocol='" + protocol + '\'' +
                ", tls='" + tls + '\'' +
                ", method='" + method + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", path='" + path + '\'' +
                ", query='" + query + '\'' +
                ", requestHeaders='" + requestHeaders + '\'' +
                ", status='" + status + '\'' +
                ", bytes='" + bytes + '\'' +
                ", responseHeaders='" + responseHeaders + '\'' +
                '}';
    }
}
