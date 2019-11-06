package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object obj) {
        BigDecimal resp = BigDecimal.ZERO;
        BigDecimal valor;

        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Somar.class)) {
                    if (field.getType().getTypeName().equals("java.math.BigDecimal")) {
                        field.setAccessible(true);
                        valor = (BigDecimal) field.get(obj);
                        resp = resp.add(valor);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public BigDecimal subtrair(Object obj) {
        BigDecimal resp = BigDecimal.ZERO;
        BigDecimal valor;

        try {
            Field[] fields = obj.getClass().getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(Subtrair.class)){
                    if (field.getType().getTypeName().equals("java.math.BigDecimal")) {
                        field.setAccessible(true);
                        valor = (BigDecimal) field.get(obj);
                        resp = resp.add(valor);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return resp;
    }


    @Override
    public BigDecimal totalizar(Object obj) {
        BigDecimal resp = BigDecimal.ZERO;
        BigDecimal valor;

        try {
            Field[] fields = obj.getClass().getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(Somar.class) || field.isAnnotationPresent(Subtrair.class)) {
                    if (field.getType().getTypeName().equals("java.math.BigDecimal")) {
                        field.setAccessible(true);
                        valor = (BigDecimal) field.get(obj);
                        if (field.isAnnotationPresent(Somar.class))
                            resp = resp.add(valor);
                        else
                            resp = resp.subtract(valor);

                    } else return BigDecimal.ZERO;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return resp;
    }
}
