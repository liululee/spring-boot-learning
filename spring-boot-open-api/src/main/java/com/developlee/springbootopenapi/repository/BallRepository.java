package com.developlee.springbootopenapi.repository;

import com.developlee.springbootopenapi.entity.Ball;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BallRepository {

    /**
     * 模拟存储在数据库中
     */
    private static Map<Long, Ball> balls = new HashMap<>();


    public Optional<Ball> findById(long id) {
        return Optional.ofNullable(balls.get(id));
    }

    public void addBall(Ball ball){
        balls.put(ball.getId(), ball);
    }

    public Collection<Ball> getBalls() {
        return balls.values();
    }
}
