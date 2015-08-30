package com.trev.fizzbuzz.inject.spring.javaconf;

import java.util.stream.Stream;

public interface FizzBuzzNumberProvider
{

    Stream<Integer> getFizzBuzzNumbers();
}
