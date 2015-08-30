package com.trev.fizzbuzz.inject.spring.javaconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FizzBuzzConfig
{

    @Bean
    public FizzBuzzPrinter fizzBuzzPrinter()
    {
        return new DefaultFizzBuzzPrinter();
    }

    @Bean
    public FizzBuzzNumberProvider numberProvider()
    {
        return new DefaultNumberProvider();
    }

    @Bean
    public FizzBuzzTextProvider textProvider()
    {
        return new DefaultTextProvider();
    }

    @Bean
    public FizzBuzzService fizzBuzz()
    {
        return new FizzBuzzService();
    }

}
