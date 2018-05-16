package jsonpathrestclienttest.jsonpathrestclienttest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "WeatherDetails")
@EntityListeners(AuditingEntityListener.class)
public class WeatherDetail {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;

    @Column(name = "Description")
    @NotBlank
    private String Description;

    @Column(name = "MinTemperature")
    @NotBlank
    private Long MinTemperature;

    @Column(name = "MaxTemperature")
    @NotBlank
    private Long MaxTemperature;

    @Column(name = "Pressure")
    private Long Pressure;

    @Column(name = "Humidity")
    private Long Humidity;

    @Column(name = "Wind")
    private Long Wind;

}

