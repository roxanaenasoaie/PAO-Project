package components;

public class Identity {
    protected Integer id;

    public Identity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "id=" + id +
                '}';
    }
}
