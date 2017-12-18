package com.jcourse.pvwat4er;

public class CommandFactoryException extends Exception {
    private String command;

    CommandFactoryException(String message, String command) {
        super(message);
        this.command = command;
    }

    public String getCommandName () {
        return command;
    }

}