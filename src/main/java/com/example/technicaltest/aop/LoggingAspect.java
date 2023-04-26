package com.example.technicaltest.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    @Around("execution(* com.example..*(..)))")
    public Object logMethodDetails(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        final StopWatch stopWatch = new StopWatch();

        // Calculate method execution time

        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        LOGGER.info("----------------------------------------- Spring Boot Logging AOP -----------------------------------------");

        // Log method name

        LOGGER.info(
                "Method name: "
               + methodSignature.getDeclaringType().getSimpleName() // Class Name
                + "." + methodSignature.getName() + " " // Method Name


        );


        //Log method execution time

        LOGGER.info(
                 "Execution time: " + stopWatch.getTotalTimeMillis() + " ms "
        );

        // Log method inputs

        String[] parameterNames=methodSignature.getParameterNames();
        Class[] parameterTypes=methodSignature.getParameterTypes();
        Object[] parameterValues=proceedingJoinPoint.getArgs();

        LOGGER.info("Inputs: ");
        for (int i=0;i<parameterNames.length;i++){
            LOGGER.info(
                "name: "+ parameterNames[i]
                + " ,type: "+ parameterTypes[i].getTypeName()
                + " ,value: " + parameterValues[i]
            );
        }

        // Log method output

        Object returnType=methodSignature.getReturnType().getTypeName();

        LOGGER.info("Output: ");
        LOGGER.info(
                "type: " + returnType
                +" ,value: "+result
        );

        return result;
    }


}