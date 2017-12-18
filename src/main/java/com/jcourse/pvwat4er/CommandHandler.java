package com.jcourse.pvwat4er;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class CommandHandler implements InvocationHandler{

    private static final Logger log = Logger.getLogger(CommandHandler.class);
    private Object obj;

    public CommandHandler(Object obj){
        this.obj = obj;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoke " + method.getName());
        log.debug("Start processing");

        if (log.isDebugEnabled()) {
            log.debug("Result: "+obj);
        }

        try {

        } catch (Exception e) {
            log.error("Something failed", e);
        }

        log.debug("done");
        return method.invoke(obj,args);
    }
}