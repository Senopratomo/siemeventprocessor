package org.senolab.siemeventprocessor.model.wsajson;

import com.google.gson.annotations.SerializedName;

public class Report {
    @SerializedName("Report Header") ReportHeader reportHeader;
    @SerializedName("Report Data") WSAData[] wsaData;



}
