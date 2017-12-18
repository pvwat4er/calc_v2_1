package com.jcourse.pvwat4er;

import java.io.*;
import java.util.Map;
import java.util.Stack;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Class.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        String string;
        CommandsFactory commandFactory = new CommandsFactory ();

        while (scanner.hasNextLine()) {

            string = scanner.nextLine();

            String[] strings = string.split(" ");
          //  Command com = commandFactory.getCommand(strings);

          //  if (com != null) {
          //      try {com.execute();
          //      } catch (NumberFormatException e) {System.out.println("Введена не известная команда");
          //      }

         //   }

            try {
                commandFactory.getProxy(strings);
            } catch (MyException e) {
                e.printStackTrace();
            }

        }

    }
}