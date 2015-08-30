package com.trev.fizzbuzz.inject.spring.javaconf;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FizzBuzzIntegrationTest
{

    private FizzBuzzPrinter printer;

    private FizzBuzzTextProvider textProvider;

    private FizzBuzzNumberProvider numberProvider;

    @Autowired
    @Qualifier("fizzBuzz")
    private FizzBuzzService sut;

    @BeforeMethod
    void setUp()
    {
        //        config = new FizzBuzzTestConfig();
        //        printer = config.fizzBuzzPrinter();
        //        textProvider = config.textProvider();
        //        numberProvider = config.numberProvider();
        try (final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(FizzBuzzTestConfig.class))
        {
            sut = context.getBean(FizzBuzzService.class);
            printer = context.getBean(FizzBuzzPrinter.class);
            textProvider = context.getBean(FizzBuzzTextProvider.class);
            numberProvider = context.getBean(FizzBuzzNumberProvider.class);
        }
    }

    @Test
    public void testFizzBuzz()
    {
        // GIVEN
        when(numberProvider.getFizzBuzzNumbers()).thenReturn(IntStream.of(1, 2, 3).boxed());
        when(textProvider.getFizzBuzzText(eq(1))).thenReturn("TEST-1");
        when(textProvider.getFizzBuzzText(eq(2))).thenReturn("TEST-2");
        when(textProvider.getFizzBuzzText(eq(3))).thenReturn("TEST-3");

        // WHEN
        sut.doFizzBuzz();

        // THEN
        verify(numberProvider).getFizzBuzzNumbers();

        verify(textProvider).getFizzBuzzText(1);
        verify(printer).printFizzBuzz("TEST-1");

        verify(textProvider).getFizzBuzzText(2);
        verify(printer).printFizzBuzz("TEST-2");

        verify(textProvider).getFizzBuzzText(3);
        verify(printer).printFizzBuzz("TEST-3");
    }

}
