package com.citybookshop.service;
import com.citybookshop.model.Category;
import java.util.List;
import java.util.ArrayList;
public class CategoryService {
    private static final String FILE_PATH="src/data/categories";
    private FileHandler fileHandler;
    public CategoryService(){
        fileHandler=new FileHandler();
    }
    public List<Category> getAllCategory(){
        List<Category> categories=new ArrayList<>();
        List<String> lines=fileHandler.readline(FILE_PATH);
        for(String line:lines){
            Category category=lineToCategory(line);
            if(category!=null){
                categories.add(category);
            }
        }
        return categories;
    }

    private Category lineToCategory(String line) {
        try{
            String[] parts=line.split("\\|");
            if(parts.length==3){
                String categoryId=parts[0];
                String categoryName=parts[1];
                String description=parts[2];
                return new Category(categoryId,categoryName,description);
            }
        }catch(Exception e){
            System.out.println("Error Reading File: "+FILE_PATH);
        }
        return null;
    }
    public List<String> getCategoryName(){
        List<String> names=new ArrayList<>();
        for(Category category:getAllCategory()){
            names.add(category.getCategoryName());
        }
        return names;
    }
    public boolean addCategory(String name,String description){
        if(categoryExists(name)){
            return false;
        }
        String newId=generateId();
        String newLine=newId+"|"+name+"|"+description;
        fileHandler.appendLine(FILE_PATH,newLine);
        return true;
    }

    public Category searchByName(String name){
        for(Category category:getAllCategory()){
            if(category.getCategoryName().equalsIgnoreCase(name)){
                return category;
            }
        }
        return null;
    }
    private String generateId() {
        List<String> lines=fileHandler.readline(FILE_PATH);
        int count=lines.size()+1;
        return String.format("CA%03d",count);
    }

    private boolean categoryExists(String name) {
        for(Category category:getAllCategory()){
            if(category.getCategoryName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
}
