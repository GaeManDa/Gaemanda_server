package com.gaemanda.gaemanda.Domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
//키 몸무게 주소 나이 빼기
public class Dog {

    @Builder
    public Dog(String name, String address, LocalDate birth, String picture,
               String description, String breed, String gender,
               Integer age, Integer weight, Integer height, String token, boolean isNeutered, String dogMbti) {

        this.token = token;
        this.name = name;
        this.address = address;
        this.birth = birth;
        this.picture = picture;
        this.description = description;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.isNeutered = isNeutered;
        this.dogMbti = dogMbti;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", isNeutered=" + isNeutered +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", createdDate=" + createdDate +
                ", birth=" + birth +
                ", picture='" + picture + '\'' +
                ", description='" + description + '\'' +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", DoglikeList=" + DoglikeList +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private boolean isNeutered;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String dogMbti;

    @Column(nullable = false)
    private String address;

    @CreatedDate
    private LocalDateTime createdDate;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    @Column(nullable = false)
    private String picture;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private Integer height;

    @OneToMany(mappedBy = "dog", cascade = CascadeType.REMOVE)
    private List<DogLike> DoglikeList;
}
