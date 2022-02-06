package ua.com.transitkyiv.transitkyiv.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "routes")
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int routeNumber;
    private int interval_;
    private Time timeStart;
    private Time timeEnd;
    private String schedule_;
    private String routeStart;
    private String routeEnd;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transports transports_;

    @OneToMany(mappedBy = "route_")
    private List<RouteStops> routeStopsList;

    @OneToOne
    @JoinColumn(name = "tk_driver_id", referencedColumnName = "id")
    private Drivers driver;

}
