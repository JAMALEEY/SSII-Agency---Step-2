package ma.youcode.ssagencyspring.entity;

import javax.persistence.*;

//in this entity I map the employee java class to the employee table in db

@Entity
@Table(name="admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "emailAdress")
    private String emailAdress;
    @Column(name = "password")
    private String password;



    //    default constructor
    public Admin() {
    }

    //    Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", emailAdress='" + emailAdress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
