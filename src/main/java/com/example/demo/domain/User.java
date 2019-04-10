package com.example.demo.domain;
//kullanıcı bilgilerini tanımlayıp yapılandırdığımız sınıf
import javax.persistence.*;
import java.util.Collection;
@Entity
@Table(name = "personal")
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
 
    @Column(name = "password")
    private String password;
 
    @Column(name = "first_name")
    private String firstName;
 
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "enabled")
 
    private boolean enabled;
    @Column(name = "username")
    private String username;
    //giriş işlemleri için rol model ile kullanıcıları bağlıyoruz
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
 
    private Collection<Role> roles;
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    } 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
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
 
    public boolean isEnabled() {
        return enabled;
    }
 
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public Collection<Role> getRoles() {
        return roles;
    }
 
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
 
}