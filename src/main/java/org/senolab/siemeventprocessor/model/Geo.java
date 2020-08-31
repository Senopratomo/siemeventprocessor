package org.senolab.siemeventprocessor.model;

public class Geo {
    String continent;
    String country;
    String city;
    String regionCode;
    String asn;

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getAsn() {
        return asn;
    }

    public void setAsn(String asn) {
        this.asn = asn;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "continent='" + continent + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", asn='" + asn + '\'' +
                '}';
    }
}
