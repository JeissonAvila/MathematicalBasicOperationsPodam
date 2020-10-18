package com.mathematicaloperations;

import com.mathematicaloperations.podam.dto.Values;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.NestedServletException;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@WebMvcTest(value = OperationsController.class)
public class operationsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void additionTest() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        Values values = factory.manufacturePojo(Values.class);
        Integer sum = values.getNumber1() + values.getNumber2();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/addition?number1="+values.getNumber1()+"&number2="+values.getNumber2()).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{number1:"+values.getNumber1()+",number2:"+values.getNumber2()+",result:" +sum + "}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void subtractionTest() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        Values values = factory.manufacturePojo(Values.class);
        Integer subtraction = values.getNumber1() - values.getNumber2();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/subtraction?number1="+values.getNumber1()+"&number2="+values.getNumber2()).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{number1:"+values.getNumber1()+",number2:"+values.getNumber2()+",result:" +subtraction + "}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void multiplicationTest() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        Values values = factory.manufacturePojo(Values.class);
        Integer multiplication = values.getNumber1() * values.getNumber2();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/multiplication?number1="+values.getNumber1()+"&number2="+values.getNumber2()).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{number1:"+values.getNumber1()+",number2:"+values.getNumber2()+",result:" +multiplication + "}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void divisionTest() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        Values values = factory.manufacturePojo(Values.class);
        Integer division = values.getNumber1() / values.getNumber2();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/division?number1="+values.getNumber1()+"&number2="+values.getNumber2()).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{number1:"+values.getNumber1()+",number2:"+values.getNumber2()+",result:" +division + "}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void exceptionTest() {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fail?number1=15&number2=5").accept(MediaType.APPLICATION_JSON);
        Exception exception = assertThrows(NestedServletException.class, () ->
                mockMvc.perform(requestBuilder));
        assertEquals("Request processing failed; nested exception is com.mathematicaloperations.exception.ExceptionService: url not found: fail, Please provide valid operations: addition (+), subtraction (-), multiplication (*) or division (/)", exception.getMessage());
    }

}
