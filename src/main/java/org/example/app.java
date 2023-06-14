package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.*;

public class app {
    public static void main(String []args) throws IOException, InvalidPathException {
        BufferedReader restroData=Files.newBufferedReader(Paths.get("C:\\Users\\sudhanshu\\IdeaProjects\\shardaswiggy\\data\\restro.csv"));
        String lines=null;
        for(int i=0;(lines=restroData.readLine())!=null;i++){
            String[] data=lines.split(",");
            for(String part:data){
                System.out.print(part+" ");
            }
            System.out.println();
        }

        BufferedReader locationData=Files.newBufferedReader(Paths.get("C:\\Users\\sudhanshu\\IdeaProjects\\shardaswiggy\\data\\location.csv"));
        String line=null;
        while((line=locationData.readLine())!=null){
            String[] data=line.split(",");
            for(String part:data){
                System.out.print(part+" ");
            }
            System.out.println();
        }
    }
}
