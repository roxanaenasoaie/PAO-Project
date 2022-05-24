package components;

public class Restaurant extends User{
    private Integer restaurantAddressID;
    private String phoneNumber, typeOfCuisine;
    private Long waitingTime;

    public Restaurant(String username, String emailAdress, Integer restaurantAddress, String phoneNumber, String typeOfCuisine, Long waitingTime) {
        super(username, emailAdress);
        this.restaurantAddressID = restaurantAddress;
        this.phoneNumber = phoneNumber;
        this.typeOfCuisine = typeOfCuisine;
        this.waitingTime = waitingTime;
    }

    public Integer getRestaurantAddress() {
        return restaurantAddressID;
    }

    public void setRestaurantAddress(Integer restaurantAddress) {
        this.restaurantAddressID = restaurantAddress;
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

    public Long getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Long waitingTime) {
        this.waitingTime = waitingTime;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", restaurantAddress=" + restaurantAddressID +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", typeOfCuisine='" + typeOfCuisine + '\'' +
                ", waitingTime=" + waitingTime +
                ", username='" + username + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                '}';
    }
}
