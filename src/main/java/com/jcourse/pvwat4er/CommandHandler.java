package com.jcourse.pvwat4er;

public class CommandHandler implements java.lang.reflect.InvocationHandler{
    private Object obj;

    public CommandHandler (Object f1){ obj = f1; }

    public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args)
            throws Throwable {
        System.out.println("CommandHandler invoke : " + method.getName());
        return method.invoke(obj, args) ;
    }
}
