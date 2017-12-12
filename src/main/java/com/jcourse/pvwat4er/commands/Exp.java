package com.jcourse.pvwat4er.commands;

import com.jcourse.pvwat4er.Command;
import com.jcourse.pvwat4er.In;
import com.jcourse.pvwat4er.RType;

import java.util.Stack;
import java.util.Map;

public class Exp implements Command {

    @In(type = RType.STACK)
    private Stack<Double> stack;

    public void execute(Stack<Double> stack, Map<String, Double> define, String[] s){

        if (stack.size() < 1){
            System.out.println("Невозможно выполнить команду! Стек должен содержать не менее одного элемента!");
        } else {
            stack.push(Math.exp(stack.pop()));
        }

    };
}
