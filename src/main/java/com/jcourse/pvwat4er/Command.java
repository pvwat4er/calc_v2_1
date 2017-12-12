package com.jcourse.pvwat4er;

import java.util.Stack;
import java.util.Map;

public interface Command {

    public abstract void execute(Stack<Double> stack, Map<String, Double> define, String[] s);
}