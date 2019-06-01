package com.github.bredmold.spring.service.controller

import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.Configuration

import javax.ws.rs.ApplicationPath

@Configuration
@ApplicationPath('/api')
class ResourceConfiguration extends ResourceConfig {
    ResourceConfiguration() {
        packages(getClass().package.name)
    }
}
