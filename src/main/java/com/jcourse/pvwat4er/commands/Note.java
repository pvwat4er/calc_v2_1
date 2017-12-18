package com.jcourse.pvwat4er.commands;


import com.jcourse.pvwat4er.Command;
import com.jcourse.pvwat4er.In;
import com.jcourse.pvwat4er.RType;

import java.util.Map;
import java.util.Stack;

public class Note implements Command {

    @In(type = RType.STACK)
    public Stack<Double> stack;
    @In(type = RType.DEFINITION)
    public Map<String, Double> define;
    @In(type = RType.ARGUMENT)
    public String[] arg;

    @Override
    public void execute() {
        System.out.println("comment");
    }
}