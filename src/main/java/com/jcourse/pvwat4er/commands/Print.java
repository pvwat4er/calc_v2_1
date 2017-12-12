package com.jcourse.pvwat4er.commands;

import com.jcourse.pvwat4er.Command;
import com.jcourse.pvwat4er.In;
import com.jcourse.pvwat4er.RType;

import java.util.Stack;
import java.util.Map;

public class Print implements Command {

    @In(type = RType.STACK)
    private Stack<Double> stack;

    public void execute(Stack<Double> stack, Map<String, Double> define, String[] s){

        System.out.println(stack.peek());

    };

}
