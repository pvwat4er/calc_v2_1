package com.jcourse.pvwat4er;

import java.util.Stack;

public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MyException(Stack<Double> stack) {
        if (stack.size() == 0) {
            System.out.println("Стэк пуст");
        } else if (stack.size() == 1) {
            System.out.println("В стэке один элемент");
        }

    }
}