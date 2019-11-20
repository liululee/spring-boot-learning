package com.developlee.springdocopenapi.controller;

import com.developlee.springdocopenapi.entity.Ball;
import com.developlee.springdocopenapi.except.BallNotFoundException;
import com.developlee.springdocopenapi.repository.BallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/ball")
public class BallController {

    @Autowired
    private BallRepository ballRepository;

    @GetMapping("/{id}")
    public Ball findById(@PathVariable long id) {
        return ballRepository.findById(id)
                .orElseThrow(() -> new BallNotFoundException());
    }

    @GetMapping("/")
    public List<Ball> findBalls() {
        return ballRepository.getBalls();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ball updateBall(@PathVariable("id") final String id, @RequestBody final Ball ball) {
        return ball;
    }
}