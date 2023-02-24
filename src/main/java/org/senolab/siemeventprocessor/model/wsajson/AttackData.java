package org.senolab.siemeventprocessor.model.wsajson;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class AttackData {
    @SerializedName("User Risk") String[] userRisk;
    @SerializedName("IP/Geo Firewall") String[] ipGeoFirewall;
    String[] Unclassified;
    @SerializedName("Bot Management") String[] botManagement;
    @SerializedName("Custom Rules") String[] customRules;
    @SerializedName("DoS Protection") String[] dosProtection;
    @SerializedName("Client Reputation") String[] clientReputation;
    @SerializedName("Web Application Firewall") String[] waf;

    public String[] getUserRisk() {
        return userRisk;
    }

    public void setUserRisk(String[] userRisk) {
        this.userRisk = userRisk;
    }

    public String[] getIpGeoFirewall() {
        return ipGeoFirewall;
    }

    public void setIpGeoFirewall(String[] ipGeoFirewall) {
        this.ipGeoFirewall = ipGeoFirewall;
    }

    public String[] getUnclassified() {
        return Unclassified;
    }

    public void setUnclassified(String[] unclassified) {
        Unclassified = unclassified;
    }

    public String[] getBotManagement() {
        return botManagement;
    }

    public void setBotManagement(String[] botManagement) {
        this.botManagement = botManagement;
    }

    public String[] getCustomRules() {
        return customRules;
    }

    public void setCustomRules(String[] customRules) {
        this.customRules = customRules;
    }

    public String[] getDosProtection() {
        return dosProtection;
    }

    public void setDosProtection(String[] dosProtection) {
        this.dosProtection = dosProtection;
    }

    public String[] getClientReputation() {
        return clientReputation;
    }

    public void setClientReputation(String[] clientReputation) {
        this.clientReputation = clientReputation;
    }

    public String[] getWaf() {
        return waf;
    }

    public void setWaf(String[] waf) {
        this.waf = waf;
    }

    @Override
    public String toString() {
        return "AttackData{" +
                "userRisk=" + Arrays.toString(userRisk) +
                ", ipGeoFirewall=" + Arrays.toString(ipGeoFirewall) +
                ", Unclassified=" + Arrays.toString(Unclassified) +
                ", botManagement=" + Arrays.toString(botManagement) +
                ", customRules=" + Arrays.toString(customRules) +
                ", dosProtection=" + Arrays.toString(dosProtection) +
                ", clientReputation=" + Arrays.toString(clientReputation) +
                ", waf=" + Arrays.toString(waf) +
                '}';
    }
}
