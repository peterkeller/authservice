package ch.kellerbaur.model;

public class AdapterUser {

    private String id;

    private String name;

    private String pwd;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(final String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return id + " (name = " + name + ")";
    }

}
