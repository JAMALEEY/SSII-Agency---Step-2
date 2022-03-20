package ma.youcode.ssagencyspring.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//in this entity I map the employee java class to the employee table in db

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    @Pattern(regexp="^[A-Za-z]{3,25}$",message="First name couldn't have numbers or special characters... ")
    @NotNull(message = "this field is blank, fill the form please")
    @Size(min = 1, message = "this field is required ")
    private String firstName;

    @Column(name = "lastName")
    @Pattern(regexp="^[A-Za-z]{3,25}$",message="Last name couldn't have numbers or special characters... ")
    @NotNull(message = "this field is blank, fill the form please")
    @Size(min = 1, message = "this field is required ")
    private String lastName;

    @Column(name = "email")
    @NotNull(message = "this field is blank, fill the form please")
    @Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$",message="E-mail error: xyz@example.com (special characters are not allowed except '-' '_' and '.' )")
    @Size(min = 1, message = "this field is required ")
    private String email;


//    default constructor
    public Employee() {
    }

//    Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
