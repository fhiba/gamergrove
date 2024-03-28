package ar.edu.itba.paw.models;

public class User {
    private String username;

    public String getUsername() {
        return username;
    }

    public long getId() {
        return id;
    }

    private long id;
    public User(String username, long id) {
        this.username = username;
        this.id = id;
    }


}
