package com.sap.core.odata.ref.model;

public class City {

  private String postalCode;
  private String cityName;

  public City() {
    this(null, null);
  }

  public City(final String postalCode, final String name) {
    this.postalCode = postalCode;
    cityName = name;
  }

  public void setPostalCode(final String postalCode) {
    this.postalCode = postalCode;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setCityName(final String cityName) {
    this.cityName = cityName;
  }

  public String getCityName() {
    return cityName;
  }

  @Override
  public String toString() {
    return String.format("%s, %s ", cityName, postalCode);
  }

}
