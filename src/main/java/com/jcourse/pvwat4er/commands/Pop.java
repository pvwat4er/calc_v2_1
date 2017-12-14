package com.jcourse.pvwat4er.commands;

import com.jcourse.pvwat4er.Command;
import com.jcourse.pvwat4er.In;
import com.jcourse.pvwat4er.RType;

import java.util.Stack;
import java.util.Map;

public class Pop implements Command {

    //  @In(type = RType.STACK)
    //  private Stack<Double> stack;

    //   STACK, DEFINITIION, ARGUMENT;

    @In(type = RType.STACK)
    private Stack<Double> stack;
    @In(type = RType.DEFINITION)
    private Map<String, Double> define;
    @In(type = RType.ARGUMENT)
    private String[] arg;

    @Override
    public void execute(
           // Stack<Double> stack, Map<String, Double> define, String[] s
    ){
        stack.pop();

    }
}
