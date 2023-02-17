package com.gaemanda.gaemanda.repository;

import com.gaemanda.gaemanda.Domain.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {
    public Dog findByToken(String token);
}
