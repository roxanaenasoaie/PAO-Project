package components;

public class Courier extends User{
    private Float workedHours, eurPerHour;

    public Courier(String username, String emailAdress, Float workedHours, Float eurPerHour) {
        super(username, emailAdress);
        this.workedHours = workedHours;
        this.eurPerHour = eurPerHour;
    }

    public Float getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Float workedHours) {
        this.workedHours = workedHours;
    }

    public Float getEurPerHour() {
        return eurPerHour;
    }

    public void setEurPerHour(Float eurPerHour) {
        this.eurPerHour = eurPerHour;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "workedHours=" + workedHours +
                ", eurPerHour=" + eurPerHour +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                '}';
    }
}
