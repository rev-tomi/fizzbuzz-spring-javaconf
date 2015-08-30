package com.trev.fizzbuzz.inject.spring.javaconf.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.trev.fizzbuzz.inject.spring.javaconf.FizzBuzzConfig;
import com.trev.fizzbuzz.inject.spring.javaconf.FizzBuzzService;

public class Main
{

    public static void main(final String[] args)
    {
        try (final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(FizzBuzzConfig.class))
        {
            final FizzBuzzService fizzBuzz = context.getBean(FizzBuzzService.class);
            fizzBuzz.doFizzBuzz();
        }
    }

}
