package com.neilist.mrs.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "host")
    private Boolean host;
    @Column(name = "volunteer")
    private Boolean volunteer;
    @Column(name = "email")
    @Email(message = "Invalid email.")
    @NotEmpty(message = "Email is required.")
    private String email;
    @Column(name = "name")
    @NotEmpty(message = "Name is required.")
    private String name;
    @Transient
    private String password;
    @Transient
    private String password2;
    @Column(name = "phone")
    @NotEmpty(message = "Phone is required.")
    private String phone;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "city")
    @NotEmpty(message = "City is required.")
    private String city;
    @Column(name = "state")
    @NotEmpty(message = "State is required.")
    private String state;
    @Column(name = "zipcode")
    @NotEmpty(message = "Zip code is required.")
    private String zipcode;
    @Column(name = "travel_range")
    private Integer travelRange;
    @Column(name = "sobriety_date")
    private Date sobrietyDate;
    @Column(name = "auth_token")
    private String authToken;
    @Column(name = "auth_expiration")
    private Date authExpiration;

    public User() {
    }

    public User(Long id, Boolean host, Boolean volunteer, String email, String name, String password, String password2, String phone, String address1, String address2, String city, String state, String zipcode, Integer travelRange, Date sobrietyDate, String authToken, Date authExpiration) {
        this.id = id;
        this.host = host;
        this.volunteer = volunteer;
        this.email = email;
        this.name = name;
        this.password = password;
        this.password2 = password2;
        this.phone = phone;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.travelRange = travelRange;
        this.sobrietyDate = sobrietyDate;
        this.authToken = authToken;
        this.authExpiration = authExpiration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getHost() {
        return host;
    }

    public void setHost(Boolean host) {
        this.host = host;
    }

    public Boolean getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Boolean volunteer) {
        this.volunteer = volunteer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getTravelRange() {
        return travelRange;
    }

    public void setTravelRange(Integer travelRange) {
        this.travelRange = travelRange;
    }

    public Date getSobrietyDate() {
        return sobrietyDate;
    }

    public void setSobrietyDate(Date sobrietyDate) {
        this.sobrietyDate = sobrietyDate;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Date getAuthExpiration() {
        return authExpiration;
    }

    public void setAuthExpiration(Date authExpiration) {
        this.authExpiration = authExpiration;
    }
}
