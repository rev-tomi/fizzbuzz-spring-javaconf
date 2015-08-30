package com.trev.fizzbuzz.inject.spring.javaconf;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;

public class FizzBuzzTestConfig extends FizzBuzzConfig
{

    private final FizzBuzzPrinter fizzBuzzPrinter = Mockito.mock(FizzBuzzPrinter.class);

    private final FizzBuzzNumberProvider numberProvider = Mockito.mock(FizzBuzzNumberProvider.class);

    private final FizzBuzzTextProvider textProvider = Mockito.mock(FizzBuzzTextProvider.class);

    @Override
    @Bean
    public FizzBuzzPrinter fizzBuzzPrinter()
    {
        return fizzBuzzPrinter;
    }

    @Override
    @Bean
    public FizzBuzzNumberProvider numberProvider()
    {
        return numberProvider;
    }

    @Override
    @Bean
    public FizzBuzzTextProvider textProvider()
    {
        return textProvider;
    }

}
