package com.gaemanda.gaemanda.Domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DogLike {

    @Builder
    public DogLike(Integer targetDogId, Dog dog) {
        this.targetDogId = targetDogId;
        this.dog = dog;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer targetDogId;

    @ManyToOne
    private Dog dog;
}
