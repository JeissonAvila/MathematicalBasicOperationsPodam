package com.mathematicaloperations;

import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;

public class operationValues {

    private final Integer number1;

    private final Integer number2;

    private final Integer result;

    public operationValues(Integer number1, Integer number2, Integer result){
        this.number1 = number1;
        this.number2 = number2;
        this.result = result;
    }

    public Integer getNumber1(){
        return number1;
    }

    public Integer getNumber2(){
        return number2;
    }

    public Integer getResult(){
        return result;
    }

}
