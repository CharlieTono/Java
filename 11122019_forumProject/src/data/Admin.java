package data;

public class Admin extends User {

    private String password;

    public Admin(String name, int age, Status status, String password) {
        super(name, age, status);
        this.password = password;
    }

    public String getPassword() { return password; }

}
