package com.gaemanda.gaemanda.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class DogLikeDto {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class putRequest {
        private Integer targetDogId;
        private String token;

        public DogLike toEntity(Dog dog) {
            return DogLike.builder()
                    .dog(dog)
                    .targetDogId(targetDogId)
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class putResponse {
        private Integer targetDogId;
    }


}
