package com.jcourse.pvwat4er.commands;

import com.jcourse.pvwat4er.Command;
import com.jcourse.pvwat4er.In;
import com.jcourse.pvwat4er.RType;

import java.util.Stack;
import java.util.Map;

public class Log implements Command {

    @In(type = RType.STACK)
    public Stack<Double> stack;
    @In(type = RType.DEFINITION)
    public Map<String, Double> define;
    @In(type = RType.ARGUMENT)
    public String[] arg;

    @Override
    public void execute(){

        if (stack.size() < 1){
            System.out.println("Невозможно выполнить команду! Стек должен содержать не менее одного элемента!");
        } else {
            stack.push(Math.log(stack.pop()));
        }

    };
}
