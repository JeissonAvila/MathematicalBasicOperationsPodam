package com.mathematicaloperations;

import com.mathematicaloperations.exception.ExceptionService;
import org.springframework.web.bind.annotation.*;

@RestController
public class OperationsController {

    @GetMapping("/{operation}")
    public operationValues operations(@PathVariable(value = "operation") String operation, @RequestParam(value = "number1", defaultValue = "0") Integer number1, @RequestParam(value = "number2", defaultValue = "0") Integer number2){
        Integer result = 0;
        if (operation.equals("addition")){
            result = number1 + number2;
        }
        else if(operation.equals("subtraction")){
            result = number1 - number2;
        }
        else if(operation.equals("multiplication")){
            result = number1 * number2;
        }
        else if(operation.equals("division")){
            result = number1 / number2;
        }
        else{
            throw new ExceptionService(operation);
        }
        return new operationValues(number1, number2, result);
    }
}