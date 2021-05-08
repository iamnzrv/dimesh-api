package com.molvaoffice.dimesh_api.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "indian_name")
@NoArgsConstructor
public class IndianNameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "indianName", unique = true, nullable = false)
    private String indianName;

    @Column(name = "meaning", unique = true, nullable = false)
    private String meaning;

    public IndianNameEntity(String indianName, String meaning) {
        this.indianName = indianName;
        this.meaning = meaning;
    }
}
