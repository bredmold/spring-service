package com.github.bredmold.spring.service.controller

import groovy.json.JsonSlurper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult

import static org.assertj.core.api.Assertions.assertThat
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloController.class)
class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc

    @Test
    void hello() {
        MvcResult result = mockMvc.perform(get('hello'))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()

        assertThat(result.response.getContentAsString()).isEqualTo('hello')
    }

    @Test
    void json() {
        MvcResult result = mockMvc.perform(get('json'))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()

        def body = new JsonSlurper().parse(result.response.contentAsByteArray)
        assertThat(body.hello as String).isEqualTo('hello')
    }
}