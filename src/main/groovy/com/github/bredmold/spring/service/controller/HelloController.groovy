package com.github.bredmold.spring.service.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/')
class HelloController {
    @GetMapping('hello')
    String hello() {
        return 'hello'
    }

    @GetMapping(path = 'json',
            produces = MediaType.APPLICATION_JSON_VALUE)
    json() {
        [
                hello: 'hello'
        ]
    }
}
