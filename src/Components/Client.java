package Components;

public class Client extends User{
    private Address deliveryAddress;
    private String phoneNumber;

    public Client(String username, String emailAdress, Address deliveryAddress, String phoneNumber) {
        super(username, emailAdress);
        this.deliveryAddress = deliveryAddress;
        this.phoneNumber = phoneNumber;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
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
                "deliveryAddress=" + deliveryAddress +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                '}';
    }
}
