package com.trev.fizzbuzz.inject.spring.javaconf;

public class DefaultFizzBuzzPrinter implements FizzBuzzPrinter
{

    @Override
    public void printFizzBuzz(final String msg)
    {
        System.out.println(msg);
    }

}
