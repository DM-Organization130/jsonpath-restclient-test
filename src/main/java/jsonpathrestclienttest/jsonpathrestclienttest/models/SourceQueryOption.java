package jsonpathrestclienttest.jsonpathrestclienttest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@lombok.Setter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "SourceQueryOptions")
public class SourceQueryOption {
    @javax.persistence.Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "QueryDescription")
    private String QueryDescription;

    @JsonIgnoreProperties
    @Column(name = "RequestPath")
    private String RequestPath;

    @JsonIgnoreProperties
    @Column(name = "RequestParameters")
    private String RequestParameters;

    @Column(name = "ResponsePath")
    private String ResponsePath ;

    @Column(name = "ResponseMapping")
    private String ResponseMapping ;
}

