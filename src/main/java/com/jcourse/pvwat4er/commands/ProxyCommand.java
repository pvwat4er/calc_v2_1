package com.jcourse.pvwat4er.commands;

import com.jcourse.pvwat4er.Command;
import com.jcourse.pvwat4er.In;
import com.jcourse.pvwat4er.RType;

import java.util.Map;
import java.util.Stack;

public class ProxyCommand implements Command{
    private Stack<Double> stack;
    private Map<String, Double> define;
    private Command cmd;

    public ProxyCommand(Command cmd) {
        this.stack = stack;
        this.define = define;
        this.cmd = cmd;
    }

    @Override
    public void execute() {
     //   System.out.println("Stack before: ");
        cmd.execute();
      //  System.out.println("Stack after: ");
    }
}
