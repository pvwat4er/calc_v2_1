package com.jcourse.pvwat4er;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.*;


public class CommandsFactory{

    Stack<Double> stack;
    Map<String, Double> define;
    String[] arg;

    private final Map<String, Command> cmdMap = new HashMap<>();


    private final static CommandsFactory inst = new CommandsFactory();

    private CommandsFactory(){

        this.stack = stack;
        this.define = define;
        this.arg = arg;

        Properties properties = new Properties();

        try(
                InputStream in = CommandsFactory.class.getClassLoader().getResourceAsStream("commands.properties")) {
            properties.load(in);
        }
        catch (IOException e){
            System.out.println("Чтение файла commands.properties завершилось с ошибкой!");
        }

        for (String key : properties.stringPropertyNames()){
            properties.get(key);
            try{
                Class cl = Class.forName(properties.getProperty(key));

                Constructor constructor = cl.getConstructor();

                Command obj = (Command) constructor.newInstance();

                Field[] fields = cl.getDeclaredFields();

                if (fields != null) {

                    for (Field field : fields) {

                        if (field.isAnnotationPresent(In.class)) {

                            In ann = field.getAnnotation(In.class);

                            RType annType = ann.type();

                            switch (annType) {

                                case STACK:
                                field.setAccessible(true);
                                field.set(obj, stack);
                                break;

                                case DEFINITION:
                                field.setAccessible(true);
                                field.set(obj, define);
                                break;

                                case ARGUMENT:
                                    field.setAccessible(true);
                                    field.set(obj, arg);
                                    break;

                                default:

                                    throw new RuntimeException("Unexpected anno: " + annType);

                            }
                        }
                    }
                }

               // cmdMap.put(mathOperator, obj);

                cmdMap.put(key, (Command) cl.newInstance());
            } catch (Exception e) {
                System.out.println("Не удалось прочитать класс: " + key );
            }
        }
    }

    public Command getCommandByName (String commandName){
        return cmdMap.get(commandName);
    }

    public static CommandsFactory getInst(){
        return inst;
    }
}