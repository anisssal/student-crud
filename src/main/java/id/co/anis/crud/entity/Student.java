package id.co.anis.crud.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Created By Anis
 * created on 3/28/2020 - 10:50 AM on crud
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "name is required")
    @Column(name = "name")
    private String name ;

    public Student() {
    }

    @NotBlank(message = "Email is required")
    @Column(name = "email")
    private String email ;

//    @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Must Be Number!!")

    @Column(name = "phone_no")
    private long phoneNo ;


    public Student(/*@NotBlank(message = "name is required") */String name,/* @NotBlank(message = "Email is required") */String email) {
        this.name = name;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getPhoneNo() {
        return phoneNo;
    }
}
