package com.hvacguardian.clientip.model;

public class ClientIp {

    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "ClientIP {ip=" + ip + "}";
    }

    public ClientIp(String ip) {
        this.ip = ip;
      }
}
