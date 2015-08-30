package com.trev.fizzbuzz.inject.spring.javaconf;

import org.springframework.beans.factory.annotation.Autowired;

public class FizzBuzzService
{

    @Autowired
    private FizzBuzzNumberProvider numberProvider;

    @Autowired
    private FizzBuzzTextProvider textProvider;

    @Autowired
    private FizzBuzzPrinter printer;

    public void doFizzBuzz()
    {
        numberProvider.getFizzBuzzNumbers().forEach(num ->
        {
            final String msg = textProvider.getFizzBuzzText(num);
            printer.printFizzBuzz(msg);
        });
    }

    public void setNumberProvider(final FizzBuzzNumberProvider numberProvider)
    {
        this.numberProvider = numberProvider;
    }

    public void setTextProvider(final FizzBuzzTextProvider textProvider)
    {
        this.textProvider = textProvider;
    }

    public void setPrinter(final FizzBuzzPrinter printer)
    {
        this.printer = printer;
    }

}
