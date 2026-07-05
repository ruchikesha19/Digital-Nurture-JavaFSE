package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Country {
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public Country(String code, String name) {
        LOGGER.debug("Inside Country Parameterized Constructor: {} - {}", code, name);
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        LOGGER.debug("Inside getCode.");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode: {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside getName.");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName: {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
