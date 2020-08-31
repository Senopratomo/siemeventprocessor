package org.senolab.siemeventprocessor.model;

public class AttackData {
    String configId;
    String policyId;
    String clientIP;
    String rules;
    String ruleVersions;
    String ruleMessages;
    String ruleTags;
    String ruleData;
    String ruleSelectors;
    String ruleActions;
    String apiId;
    String apiKey;

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String confidId) {
        this.configId = confidId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getRuleVersions() {
        return ruleVersions;
    }

    public void setRuleVersions(String ruleVersions) {
        this.ruleVersions = ruleVersions;
    }

    public String getRuleMessages() {
        return ruleMessages;
    }

    public void setRuleMessages(String ruleMessages) {
        this.ruleMessages = ruleMessages;
    }

    public String getRuleTags() {
        return ruleTags;
    }

    public void setRuleTags(String ruleTags) {
        this.ruleTags = ruleTags;
    }

    public String getRuleData() {
        return ruleData;
    }

    public void setRuleData(String ruleData) {
        this.ruleData = ruleData;
    }

    public String getRuleSelectors() {
        return ruleSelectors;
    }

    public void setRuleSelectors(String ruleSelectors) {
        this.ruleSelectors = ruleSelectors;
    }

    public String getRuleActions() {
        return ruleActions;
    }

    public void setRuleActions(String ruleActions) {
        this.ruleActions = ruleActions;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String toString() {
        return "AttackData{" +
                "configId='" + configId + '\'' +
                ", policyId='" + policyId + '\'' +
                ", clientIP='" + clientIP + '\'' +
                ", rules='" + rules + '\'' +
                ", ruleVersions='" + ruleVersions + '\'' +
                ", ruleMessages='" + ruleMessages + '\'' +
                ", ruleTags='" + ruleTags + '\'' +
                ", ruleData='" + ruleData + '\'' +
                ", ruleSelectors='" + ruleSelectors + '\'' +
                ", ruleActions='" + ruleActions + '\'' +
                ", apiId='" + apiId + '\'' +
                ", apiKey='" + apiKey + '\'' +
                '}';
    }
}
