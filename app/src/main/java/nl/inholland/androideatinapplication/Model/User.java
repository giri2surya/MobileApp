package nl.inholland.androideatinapplication.Model;

public class User {


    // this is to get the key value from the  database so we need to write in Model class
    private String Name="";
    private String Password="";

    public User(String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
    }

    public User() {

    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }
}
