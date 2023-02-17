package com.gaemanda.gaemanda.controller;


import com.gaemanda.gaemanda.Domain.DogDto;
import com.gaemanda.gaemanda.Domain.DogLikeDto;
import com.gaemanda.gaemanda.service.DogLikeService;
import com.gaemanda.gaemanda.service.DogService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dog")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DogController {

    private final DogService dogService;
    private final DogLikeService dogLikeService;

    
    //token은 헤더로 들어옴
    @PostMapping("/")
    public DogDto.SignupResponse signup(@RequestBody DogDto.SignupRequest signupRequest, @RequestHeader("id") Object token) {
        signupRequest.setToken((String) token);
        System.out.println(signupRequest);
        return dogService.signup(signupRequest);
    }

//    @GetMapping("/")
//    public List<DogDto.Info> getDogList() {
//        return dogService.getDogList();
//    }

//    @GetMapping("/")
//    public DogDto.Info getDog(@RequestHeader("Id") Object token) {
//        return dogService.getDogByToken((String) token);
//    }

    @GetMapping("/{id}")
    public DogDto.Info getDog(@PathVariable Integer id) {
        return dogService.getDog(id);
    }

    @GetMapping
    public List<DogDto.Info> getAllDogs() {
        return dogService.getDogList();
    }

    @PostMapping("/like")
    public DogLikeDto.putResponse putDogLike(@RequestBody Object targetDogId, @RequestHeader("id") Object token) {
        DogLikeDto.putResponse putResponse = dogLikeService.put(DogLikeDto.putRequest.builder()
                .targetDogId(parseTargetDogId(targetDogId))
                .token((String) token)
                .build());

        return putResponse;
    }

    @GetMapping("/like")
    public List<DogDto.Info> getLikedDogs(@RequestHeader("id") Object token) {
        List<DogDto.Info> result = dogLikeService.getLikedDogs((String) token);

        return result;
    }

    private static Integer parseTargetDogId(Object targetDogId) {
        String tmp = targetDogId.toString();
        tmp = tmp.substring(13);
        tmp = tmp.substring(0, tmp.length() - 1);
        return Integer.parseInt(tmp);
    }
}