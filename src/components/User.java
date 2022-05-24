package components;

public abstract class User extends Identity{
    protected String username, emailAdress;
    static Integer ID = 0;

    public User(String username, String emailAdress) {
        super(ID);
        ID += 1;

        this.username = username;
        this.emailAdress = emailAdress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", emailAdress='" + emailAdress +
                '}';
    }
}
