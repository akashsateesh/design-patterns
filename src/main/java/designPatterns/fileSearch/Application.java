package designPatterns.fileSearch;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
//        String fileName = "file.txt";
//        FileOutputStream file = new FileOutputStream(fileName);
//        ObjectOutputStream out = new ObjectOutputStream(file);
//        
//        Directory directory = new Directory("d-1",20);
//        
//        out.writeObject(directory);
//    
//        out.close();
//        file.close();
//    
//        FileInputStream file2 = new FileInputStream(fileName);
//        ObjectInputStream in = new ObjectInputStream(file2);
//    
//        Directory directory1 = (Directory)in.readObject();
//        
//        
        
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("cshdghd");
    
        Set<String> set = new HashSet<>();
        set.add("cshdghd");
        
        Integer a = 34;
        
        
        if(set.contains(stringBuilder)){
            System.out.println("yo");
        }
        
        System.out.println("Hello World");
    }
}
