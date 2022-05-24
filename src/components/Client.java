package components;

public class Client extends User{
    private Integer deliveryAddressID;
    private String phoneNumber;

    public Client(String username, String emailAdress, Integer deliveryAddress, String phoneNumber) {
        super(username, emailAdress);
        this.deliveryAddressID = deliveryAddress;
        this.phoneNumber = phoneNumber;
    }

    public Integer getDeliveryAddressID() {
        return deliveryAddressID;
    }

    public void setDeliveryAddressID(Integer deliveryAddress) {
        this.deliveryAddressID = deliveryAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "deliveryAddress=" + deliveryAddressID +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                '}';
    }
}
