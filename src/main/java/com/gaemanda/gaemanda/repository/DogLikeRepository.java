package com.gaemanda.gaemanda.repository;


import com.gaemanda.gaemanda.Domain.DogLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogLikeRepository extends JpaRepository<DogLike, Integer> {
}
