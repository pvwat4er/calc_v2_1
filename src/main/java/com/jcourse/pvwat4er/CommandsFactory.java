package com.jcourse.pvwat4er;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class CommandsFactory{
    private final Map<String, Command> cmdMap = new HashMap<>();


    private final static CommandsFactory inst = new CommandsFactory();

    private CommandsFactory(){
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