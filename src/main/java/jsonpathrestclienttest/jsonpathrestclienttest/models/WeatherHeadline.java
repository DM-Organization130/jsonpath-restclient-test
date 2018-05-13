package jsonpathrestclienttest.jsonpathrestclienttest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "WeatherHeadlines")
@EntityListeners(AuditingEntityListener.class)


public class WeatherHeadline {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;

    @NotBlank
    @OneToMany
    @JoinColumn(name = "WeatherHeadlineId", nullable = false)
    private List<WeatherDetail> weatherDetails;

    @Column(name = "QueryType")
    @NotBlank
    private byte QueryType;

    @NotBlank
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "QueryDate")
    private Date QueryDate;



}
