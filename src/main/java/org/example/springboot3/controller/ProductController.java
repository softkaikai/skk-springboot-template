package org.example.springboot3.controller;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.example.springboot3.entity.Product;
import org.example.springboot3.service.ProductService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Account {
    String name = "123";
}

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kaikai
 * @since 2026-04-23
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final RabbitTemplate rabbitTemplate;

    private final ProductService productService;

    private final StringRedisTemplate stringRedisTemplate;

    private final RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/list")
    private List<Product> list() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        HashOperations<String, Object, Object> opsHash = stringRedisTemplate.opsForHash();

        ValueOperations<String, Object> os = redisTemplate.opsForValue();

        Account c = new Account();

        System.out.println(redisTemplate.keys("*"));
        System.out.println(stringRedisTemplate.hasKey("acctount"));
        System.out.println(redisTemplate.type("acctount"));
        return productService.list();
    }

    @GetMapping("/rabbit")
    private String testRabbit() {
        String queue1 = "direct.queue1";
        String queue2 = "direct.queue1";
        String exchangeName = "directExchange";
        HashMap<String, String> message = new HashMap<>();
        message.put("name", "kaikai");
        message.put("age", "22");

        rabbitTemplate.convertAndSend(exchangeName, "red", message);

        return "rabbit";
    }
}
