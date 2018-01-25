package com.sd.campoc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @NotEmpty
    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @NotEmpty
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid Email")
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @JsonIgnore
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "IS_ACTIVE", columnDefinition = "boolean default true", nullable = false)
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return (id != null ? !id.equals(user.id) : user.id != null);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result;
        return result;
    }


    @Override
    public String toString() {
        return "user [id=" + id + ", userName=" + userName + ", isActive=" + isActive
                + ", role=" + this.role.getName() + "]";
    }


}