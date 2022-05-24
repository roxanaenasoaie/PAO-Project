package components;

public class Address {
    private Integer addressID = 0;
    private String street, city, county, country, buildingID;
    private Integer streetNumber, floorNumber, apartmentNumber;

    public Address() {

    }

    public Address(Integer id, String street, String city, String county, String country, String buildingID, Integer streetNumber, Integer floorNumber, Integer apartmentNumber) {
        this.addressID = id;
        this.street = street;
        this.city = city;
        this.county = county;
        this.country = country;
        this.buildingID = buildingID;
        this.streetNumber = streetNumber;
        this.floorNumber = floorNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", country='" + country + '\'' +
                ", buildingID='" + buildingID + '\'' +
                ", streetNumber=" + streetNumber +
                ", floorNumber=" + floorNumber +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
