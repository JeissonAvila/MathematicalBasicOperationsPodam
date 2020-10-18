//package com.mathematicaloperations.podam.dto;
//
//import com.mathematicaloperations.operationValues;
//import uk.co.jemos.podam.api.AbstractRandomDataProviderStrategy;
//import uk.co.jemos.podam.api.AttributeMetadata;
//
//import java.util.Random;
//
//public class ValuesDataProviderStrategy extends AbstractRandomDataProviderStrategy {
//
//    private static final Random random = new Random(System.currentTimeMillis());
//
//    public ValuesDataProviderStrategy(){
//        super();
//    }
//
//    @Override
//    public Integer getMaxDepth(Integer number){
//
//        if(operationValues.class.equals(attributeMetadata.getPojoClass())){
//            if("number1".equals(attributeMetadata.getAttributeName())) {
//                return 0 + random.nextInt(10);
//            }
//        }
//        return super.getStrategyForAnnotation(number);
//    }
//
//}