package com.jcourse.pvwat4er;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.*;


public class CommandsFactory {

    Stack<Double> stack = new Stack<>();
    Map<String, Double> define = new HashMap<>();
    String[] arg;

    Properties properties = new Properties();

    public CommandsFactory() {

        try (
                InputStream in = CommandsFactory.class.getClassLoader().getResourceAsStream("commands.properties")) {
            properties.load(in);
        } catch (IOException e) {
            System.out.println("Чтение файла commands.properties завершилось с ошибкой!");
        }
    }

    public Command getCommand(String[] calledCommand) {

        arg = calledCommand;
        String prop = properties.getProperty(arg[0]);
        Command command = null;

        try {
            Class<?> cl = Class.forName(prop);
            Object o = cl.newInstance();
            Field[] declaredFields = cl.getDeclaredFields();
            command = (Command) o;

            //annottions
            for (Field field : declaredFields) {



                In annotation = field.getAnnotation(In.class);


                if (annotation != null) {

                    field.setAccessible(true);
                    if (annotation.type() == RType.STACK) {
                        field.set(o, stack);


                    } else if (annotation.type() == RType.DEFINITION) {
                        field.set(o, define);

                    } else if (annotation.type() == RType.ARGUMENT) {
                        field.set(o, arg);
                    }
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (NullPointerException e) {
            e.getMessage();
            System.out.println("Команда не определена!");
        }

        return command;
    }

    public Command getProxy(String[] calledCommand) throws MyException {

        Command userProxy = (Command) Proxy.newProxyInstance(Command.class.getClassLoader(), new Class[]{Command.class}, new CommandHandler(getCommand(calledCommand)));
        userProxy.execute();

        return userProxy;
    }

}


