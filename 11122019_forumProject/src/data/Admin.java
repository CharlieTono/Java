package data;

public class Admin extends User {

    public String password = "!=user";

    public Admin(String name, int age) {
        super(name, age);
    }

    public String getPassword() {
        return password;
    }

}
