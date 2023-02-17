package com.gaemanda.gaemanda.service;


import com.gaemanda.gaemanda.Domain.Dog;
import com.gaemanda.gaemanda.Domain.DogDto;
import com.gaemanda.gaemanda.Domain.DogLike;
import com.gaemanda.gaemanda.Domain.DogLikeDto;
import com.gaemanda.gaemanda.repository.DogLikeRepository;
import com.gaemanda.gaemanda.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogLikeService {

    private final DogLikeRepository dogLikeRepository;
    private final DogRepository dogRepository;

    //id : 124125

    public DogLikeDto.putResponse put(DogLikeDto.putRequest putRequest) {
        Dog dog = dogRepository.findByToken(putRequest.getToken());
        System.out.println("put method : " + dog);
        DogLike result = dogLikeRepository.save(DogLike.builder()
                        .targetDogId(putRequest.getTargetDogId())
                        .dog(dog)
                        .build());

        return DogLikeDto.putResponse.builder().targetDogId(result.getTargetDogId()).build();
    }

    public List<DogDto.Info> getLikedDogs(String token) {
        Dog dog = dogRepository.findByToken(token);
        System.out.println("dog = " + dog);
        System.out.println("dog.getDoglikeList() = " + dog.getDoglikeList());
        List<DogLike> dogLikes = dogRepository.findByToken(token).getDoglikeList();
        List<DogDto.Info> result = new ArrayList<>();

        for (DogLike dogLike : dogLikes) {
            System.out.println(dogLike.getTargetDogId());
            Optional<Dog> tmpDogOption = dogRepository.findById(dogLike.getTargetDogId());
            Dog tmpDog = tmpDogOption.get();
            System.out.println("tmpDog = " + tmpDog);

            result.add(DogDto.Info.builder().
                    name(tmpDog.getName())
                    .address(tmpDog.getAddress())
                    .birth(tmpDog.getBirth())
                    .picture(tmpDog.getPicture())
                    .description(tmpDog.getDescription())
                    .breed(tmpDog.getBreed())
                    .gender(tmpDog.getGender())
                    .age(tmpDog.getAge())
                    .weight(tmpDog.getWeight())
                    .height(tmpDog.getHeight())
                    .build());
        }

        return result;
    }
}
