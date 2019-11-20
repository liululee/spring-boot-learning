package com.developlee.springdocopenapi.repository;

import com.developlee.springdocopenapi.entity.Ball;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BallRepository extends PagingAndSortingRepository<Ball, Long> {
    List<Ball> getBalls();

}
