package tn.esprit.test.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long courseID;
    private Integer num ;
    private LocalDate date ;
    private Integer duration ;
    @Enumerated(EnumType.STRING)
    private Level level ;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany(mappedBy = "courses2")
    private List<Person> persons;


    @OneToMany(cascade = CascadeType.ALL)
  //  @JoinColumn(name = "course_id")
    private List<Exercice> exercices;
}
