package org.senolab.siemeventprocessor.model.wsajson;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class ReportHeader {
    @SerializedName("Account ID") String accountId;
    String account;
    @SerializedName("Security Configuration") String securityConfiguration;
    String Generated;
    String Start;
    String[] Filter;
    int Results;
    @SerializedName("Report Type") String reportType;
    String End;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSecurityConfiguration() {
        return securityConfiguration;
    }

    public void setSecurityConfiguration(String securityConfiguration) {
        this.securityConfiguration = securityConfiguration;
    }

    public String getGenerated() {
        return Generated;
    }

    public void setGenerated(String generated) {
        Generated = generated;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String[] getFilter() {
        return Filter;
    }

    public void setFilter(String[] filter) {
        Filter = filter;
    }

    public int getResults() {
        return Results;
    }

    public void setResults(int results) {
        Results = results;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    @Override
    public String toString() {
        return "ReportHeader{" +
                "accountId='" + accountId + '\'' +
                ", account='" + account + '\'' +
                ", securityConfiguration='" + securityConfiguration + '\'' +
                ", Generated='" + Generated + '\'' +
                ", Start='" + Start + '\'' +
                ", Filter=" + Arrays.toString(Filter) +
                ", Results=" + Results +
                ", reportType='" + reportType + '\'' +
                ", End='" + End + '\'' +
                '}';
    }
}
