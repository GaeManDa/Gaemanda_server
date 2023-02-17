package com.gaemanda.gaemanda.Domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DogDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class SignupRequest {
        private String token;
        private boolean isNeutered;
        private String name;
        private String address;
        private LocalDate birth;
        private String picture;
        private String description;
        private String breed;
        private String gender;
        private Integer age;
        private Integer weight;
        private Integer height;
        private String dogMbti;

        @Override
        public String toString() {
            return "SignupRequest{" +
                    "token='" + token + '\'' +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", birth=" + birth +
                    ", picture='" + picture + '\'' +
                    ", description='" + description + '\'' +
                    ", breed='" + breed + '\'' +
                    ", gender='" + gender + '\'' +
                    ", age=" + age +
                    ", weight=" + weight +
                    ", height=" + height + ", isNeutered=" + isNeutered+
                    '}';
        }

        public Dog toEntity() {
            return Dog.builder().
                    token(token).
                    name(name)
                    .address(address)
                    .birth(birth)
                    .picture(picture)
                    .description(description)
                    .breed(breed)
                    .gender(gender)
                    .age(age)
                    .weight(weight)
                    .height(height)
                    .isNeutered(isNeutered)
                    .dogMbti(dogMbti)
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Info {
        private String name;
        private String address;
        private LocalDate birth;
        private String picture;
        private String description;
        private String breed;
        private boolean isNeutered;
        private String gender;
        private Integer age;
        private Integer weight;
        private Integer height;
        private String dogMbti;

        public Dog toEntity() {
            return Dog.builder().
                    name(name)
                    .address(address)
                    .birth(birth)
                    .picture(picture)
                    .description(description)
                    .breed(breed)
                    .gender(gender)
                    .age(age)
                    .weight(weight)
                    .height(height)
                    .isNeutered(isNeutered)
                    .dogMbti(dogMbti)
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class SignupResponse {
        private LocalDateTime createdDate;
        private Integer id;
        private String token;
        private String dogMbti;
        private String dogMbtiTitle;
        private String dogMbtiDescription;
    }
}
