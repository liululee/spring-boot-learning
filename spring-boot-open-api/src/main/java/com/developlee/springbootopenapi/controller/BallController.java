package com.developlee.springbootopenapi.controller;

import com.developlee.springbootopenapi.entity.Ball;
import com.developlee.springbootopenapi.except.BallNotFoundException;
import com.developlee.springbootopenapi.repository.BallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
    public Collection<Ball> findBalls() {
        return ballRepository.getBalls();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ball updateBall(@PathVariable("id") final String id, @RequestBody final Ball ball) {
        return ball;
    }
}