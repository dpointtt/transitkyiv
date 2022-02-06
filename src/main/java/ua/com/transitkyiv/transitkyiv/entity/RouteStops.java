package ua.com.transitkyiv.transitkyiv.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "route_stops")
public class RouteStops {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Routes route_;

    @ManyToOne
    @JoinColumn(name = "stop_id")
    private Stops stop_;

}
