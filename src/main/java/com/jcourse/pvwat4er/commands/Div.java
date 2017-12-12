package com.jcourse.pvwat4er.commands;

import com.jcourse.pvwat4er.Command;
import com.jcourse.pvwat4er.In;
import com.jcourse.pvwat4er.RType;

import java.util.Stack;
import java.util.Map;

public class Div implements Command {

    @In(type = RType.STACK)
    private Stack<Double> stack;

    public void execute(Stack<Double> stack, Map<String, Double> define, String[] s){

        if (stack.size() < 2){
            System.out.println("Невозможно выполнить команду! Стек должен содержать более одного элемента!");
        } else {
            stack.push(stack.pop() / stack.pop());
        }

    };

}
