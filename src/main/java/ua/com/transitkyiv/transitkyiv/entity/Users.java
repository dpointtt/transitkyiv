package ua.com.transitkyiv.transitkyiv.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tk_user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String firstName;

    private String lastName;

    private String tkpassword;

    @OneToMany(mappedBy = "tkuser")
    private List<UserRoles> userRolesList;

    public Users(String userName, String firstName, String lastName, String userPassword) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tkpassword = userPassword;
    }
}
