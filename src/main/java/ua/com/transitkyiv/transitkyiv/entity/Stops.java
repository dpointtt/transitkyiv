package ua.com.transitkyiv.transitkyiv.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "stops")
public class Stops {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stopAddress;

    @OneToMany(mappedBy = "stop_")
    private List<RouteStops> routeStopsList;

}
