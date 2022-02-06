package ua.com.transitkyiv.transitkyiv.entity;

import lombok.*;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "transports")
public class Transports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transport;

    private String t_image;

    @OneToMany(mappedBy = "transports_")
    private List<Routes> routesList;
}
