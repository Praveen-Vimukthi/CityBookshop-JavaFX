package com.citybookshop.service;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class FileHandler {

    public List<String> readline(String filePath) {
        List<String> lines = new ArrayList<>();
        try{
            File file=new File(filePath);
            if(!file.exists()){
                return lines;
            }
            BufferedReader reader=new BufferedReader(new FileReader(file));

            String line;
            while((line=reader.readLine())!=null){
                if(!line.trim().isEmpty()){
                    lines.add(line);
                }
            }
            reader.close();
        }catch (IOException e) {
            System.out.println("Error Reading File: "+filePath);
            e.printStackTrace();;
        }
        return lines;
    }

    public void appendLine(String filePath, String newLine) {
        try{
            File file =new File(filePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
            writer.write(newLine);
            writer.newLine();
            writer.close();
            
        }catch(IOException e){
            System.out.println("Error File append: "+filePath);
            e.printStackTrace();
        }
    }
    public void writeLines(String filePath, List<String> lines){
        try{
            File file=new File(filePath);
            BufferedWriter writer=new BufferedWriter(new FileWriter(filePath,false));
            for(String line:lines){
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Error Writing File: "+filePath);
            e.printStackTrace();
        }
    }
}
