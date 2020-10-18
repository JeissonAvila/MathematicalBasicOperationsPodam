package com.mathematicaloperations.podam.dto;

import uk.co.jemos.podam.common.PodamIntValue;
import uk.co.jemos.podam.common.PodamConstructor;

public class Values {

    private Integer number1;

    private Integer number2;

    public Integer getNumber1() {
        return number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    @PodamConstructor(comment = "Immutable-like POJOs must be annotated with @PodamConstructor")
    public Values(@PodamIntValue(maxValue = 10) Integer number1, @PodamIntValue(maxValue = 20) Integer number2){
        super();
        this.number1 = number1;
        this.number2 = number2;
    }
}
