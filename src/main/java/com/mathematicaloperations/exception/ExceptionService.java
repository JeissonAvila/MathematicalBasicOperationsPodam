package com.mathematicaloperations.exception;

public class ExceptionService extends RuntimeException {

    public ExceptionService(String url){
            super("url not found: " + url + ", Please provide valid operations: addition (+), subtraction (-), multiplication (*) or division (/)");
    }

}
