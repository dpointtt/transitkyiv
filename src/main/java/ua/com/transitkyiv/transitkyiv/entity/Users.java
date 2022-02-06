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

    private String password;

    @OneToMany(mappedBy = "tkuser")
    private List<UserRoles> userRolesList;

}
