package org.senolab.siemeventprocessor.model.wsajson;

import com.google.gson.annotations.SerializedName;

public class WSAData {
    String Scheme;
    @SerializedName("End-User ASnum - Logtime") String endUserASNum;
    String Query;
    @SerializedName("Connecting Country/Area - Logtime") String connectingCountry;
    @SerializedName("Edge Server IP") String edgeServerIP;
    @SerializedName("End-User Country/Area - Logtime") String endUserCountry;
    @SerializedName("Connecting ASnum - Logtime") String connectingASnum;
    @SerializedName("User-Agent") String userAgent;
    @SerializedName("API Name") String apiName;
    @SerializedName("Action Applied") String actionApplied;
    @SerializedName("Protocol Negotiation") String protocolNegotiation;
    @SerializedName("End-User IP Subnet") String endUserIPSubnet;
    @SerializedName("API Key") String apiKey;
    @SerializedName("Connecting ISP Name - Current") String connectingISPName;
    @SerializedName("Reputation Scores") String reputationScores;
    @SerializedName("Network Type - Logtime") String networkType;
    @SerializedName("Connecting IP") String connectingIP;
    @SerializedName("Bundle ID") String bundleID;
    @SerializedName("Bot Score Response Segment") String botScoreResponse;
    @SerializedName("User Risk Level") String userRiskLevel;
    @SerializedName("End-User IP") String endUserIP;
    @SerializedName("Connecting Domain - Current") String connectingDomain;
    String Hostname;
    String Method;



}
