package com.frank0631.huginn;

import com.frank0631.huginn.customer.CustomerEntity;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by frank0631 on 7/20/15.
 */
@Component
public class RestConfiguration extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(CustomerEntity.class);
        config.setReturnBodyOnCreate(true);
        config.setReturnBodyOnUpdate(true);
        config.setBasePath("data/");
    }

    @Override
    public void configureJacksonObjectMapper(ObjectMapper objectMapper) {
        objectMapper.setVisibility(objectMapper.getSerializationConfig()
        .getDefaultVisibilityChecker()
        .withFieldVisibility(Visibility.ANY)
        .withGetterVisibility(Visibility.NONE)
        .withIsGetterVisibility(Visibility.NONE));
    }

}
