package com.molvaoffice.dimesh_api.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "indian_surname")
@NoArgsConstructor
public class IndianSurnameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "indianSurname", unique = true, nullable = false)
    private String indianSurname;

    @Column(name = "meaning", unique = true, nullable = false)
    private String meaning;

    public IndianSurnameEntity(String indianSurname, String meaning) {
        this.indianSurname = indianSurname;
        this.meaning = meaning;
    }
}
