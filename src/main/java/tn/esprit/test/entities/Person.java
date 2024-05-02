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
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer personId;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Integer nbrMonthsTraining;
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Course> courses;


    @ManyToMany
    private List<Course> courses2;




}
