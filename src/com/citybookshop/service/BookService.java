package com.citybookshop.service;

import com.citybookshop.model.Book;
import java.util.ArrayList;
import java.util.List;
public class BookService {
    private static final String FILE_PATH="src/data/books.txt";
    private FileHandler fileHandler;
    public BookService(){
        this.fileHandler=new FileHandler();
    }
    public List<Book> getAllBooks(){
        List<Book> books= new ArrayList<>();
        List<String> lines=fileHandler.readline(FILE_PATH);

        for(String line:lines){
            Book book = lineToBook(line);
            if(book!=null){
                books.add(book);
            }
        }
        return books;
    }
    public boolean addBook(String title,String author,double price,int quantity,String categoryName){
        if(bookExists(title)){
            return false;
        }
        String newId=generateId();
        String newLine=newId+"|"+title+"|"+author+"|"+price+"|"+quantity+"|"+categoryName;
        fileHandler.appendLine(FILE_PATH,newLine);
        return true;
    }

    private String generateId() {
        List<String> lines=fileHandler.readline(FILE_PATH);
        int count=lines.size()+1;
        return String.format("BK%03d",count);
    }

    private boolean bookExists(String title) {
        for(Book book :getAllBooks()){
            if(book.getTitle().equalsIgnoreCase(title)){
                return true;
            }
        }
        return false;
    }

    private Book lineToBook(String line) {
        try{
            String[] parts=line.split("\\|");
            if(parts.length==6){
                String bookId=parts[0];
                String title=parts[1];
                String author=parts[2];
                double price= Double.parseDouble(parts[3]);
                int quantity=Integer.parseInt(parts[4]);
                String categoryName=parts[5];
                return new Book(bookId,title,author,price,quantity,categoryName);
            }
        }catch(Exception e){
            System.out.println("Error reading file: "+FILE_PATH);
        }
        return null;
    }
    public List<Book> searchByTitle(String title){
        List<Book> results=new ArrayList<>();
        for(Book book:getAllBooks()){
            if(book.getTitle().equalsIgnoreCase(title)){
                results.add(book);
            }
        }
        return results;
    }
    public List<Book> searchByCategory(String categoryName){
        List<Book> results=new ArrayList<>();
        for(Book book:getAllBooks()){
            if(book.getCategoryName().equalsIgnoreCase(categoryName)){
                results.add(book);
            }
        }
        return results;
    }
    public List<Book> getLowStock(){
        List<Book> results=new ArrayList<>();
        for(Book book: getAllBooks()){
            if(book.getQuantity()<=5){
                results.add(book);
            }
        }
        return results;
    }
}
