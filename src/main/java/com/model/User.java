package com.model;

import com.enums.UserType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "dataOfBirthday")
    private String dataOfBirthday;

    @Enumerated(EnumType.STRING)
    @Column(name = "userType")
    private UserType userType;

    @Column(name = "photo")
    private String photo;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cart",
            joinColumns = {@JoinColumn(name = "userId")},
          inverseJoinColumns = {@JoinColumn(name = "productId")}
    )
     private List<Product> productList = new LinkedList<>();

    public User() {
    }

    public User(int id, String firstname, String lastname, String password, String email,
                String phoneNumber, String dataOfBirthday, UserType userType, String photo) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dataOfBirthday = dataOfBirthday;
        this.userType = userType;
        this.photo = photo;
    }

    public User(String firstname, String lastname, String password, String email, String phoneNumber,
                String dataOfBirthday, UserType userType, String photo, List<Product> productList) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dataOfBirthday = dataOfBirthday;
        this.userType = userType;
        this.photo = photo;
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDataOfBirthday() {
        return dataOfBirthday;
    }

    public void setDataOfBirthday(String dataOfBirthday) {
        this.dataOfBirthday = dataOfBirthday;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, email, phoneNumber);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dataOfBirthday='" + dataOfBirthday + '\'' +
                ", userType='" + userType + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
