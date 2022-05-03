package Components;

public class Restaurant extends User{
    private Address restaurantAddress;
    private String phoneNumber, typeOfCuisine;
    private Integer waitingTime;

    public Restaurant(String username, String emailAdress, Address restaurantAddress, String phoneNumber, String typeOfCuisine, Integer waitingTime) {
        super(username, emailAdress);
        this.restaurantAddress = restaurantAddress;
        this.phoneNumber = phoneNumber;
        this.typeOfCuisine = typeOfCuisine;
        this.waitingTime = waitingTime;
    }

    public Address getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(Address restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTypeOfCuisine() {
        return typeOfCuisine;
    }

    public void setTypeOfCuisine(String typeOfCuisine) {
        this.typeOfCuisine = typeOfCuisine;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Integer waitingTime) {
        this.waitingTime = waitingTime;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", restaurantAddress=" + restaurantAddress +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", typeOfCuisine='" + typeOfCuisine + '\'' +
                ", waitingTime=" + waitingTime +
                ", username='" + username + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                '}';
    }
}
