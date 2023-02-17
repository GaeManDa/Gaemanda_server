package com.gaemanda.gaemanda.service;


import com.gaemanda.gaemanda.Domain.Dog;
import com.gaemanda.gaemanda.Domain.DogDto;
import com.gaemanda.gaemanda.Domain.DogMbtiType;
import com.gaemanda.gaemanda.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class DogService {

    private final DogRepository dogRepository;

    public List<DogDto.Info> getDogList() {
        List<Dog> dogList = dogRepository.findAll();
        List<DogDto.Info> infoList = new ArrayList<>();
        for (Dog dog : dogList) {
            infoList.add(DogDto.Info.builder().
                    name(dog.getName())
                    .address(dog.getAddress())
                    .birth(dog.getBirth())
                    .picture(dog.getPicture())
                    .description(dog.getDescription())
                    .breed(dog.getBreed())
                    .gender(dog.getGender())
                    .age(dog.getAge())
                    .weight(dog.getWeight())
                            .id(dog.getId())
                    .height(dog.getHeight()).build());
        }
        return infoList;
    }

    public DogDto.SignupResponse signup(DogDto.SignupRequest signupRequest) {
        Dog dog = signupRequest.toEntity();
        Dog result = dogRepository.save(dog);
        DogMbtiType dogMbtiType = DogMbtiType.valueOf(dog.getDogMbti());

        return DogDto.SignupResponse.builder()
                .createdDate(result.getCreatedDate())
                .token(result.getToken())
                .id(result.getId())
                .dogMbti(dog.getDogMbti())
                .dogMbtiDescription(dogMbtiType.getDescription())
                .dogMbtiTitle(dogMbtiType.getTitle())
                .build();
    }

    public DogDto.Info getDog(Integer id) {
        Optional<Dog> dogOptional = dogRepository.findById(id);
        Dog dog = dogOptional.get();
        return DogDto.Info.builder().
                name(dog.getName())
                .address(dog.getAddress())
                .birth(dog.getBirth())
                .picture(dog.getPicture())
                .description(dog.getDescription())
                .breed(dog.getBreed())
                .gender(dog.getGender())
                .age(dog.getAge())
                .weight(dog.getWeight())
                .height(dog.getHeight())
                .id(id)
                .build();
    }
    public DogDto.Info getDogByToken(String token) {
        Dog dog = dogRepository.findByToken(token);

        return DogDto.Info.builder().
                name(dog.getName())
                .address(dog.getAddress())
                .birth(dog.getBirth())
                .picture(dog.getPicture())
                .description(dog.getDescription())
                .breed(dog.getBreed())
                .gender(dog.getGender())
                .age(dog.getAge())
                .weight(dog.getWeight())
                .height(dog.getHeight())
                .dogMbti(dog.getDogMbti())
                .build();
    }

}
