package pkg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by gimy on 3/10/2017.
 */
public class FileHandler {

  private String fileName;
  private Formatter Pen;
  private Scanner Reader;
  private File file;



  public FileHandler(String fileName){
    this.fileName = fileName;
    this.file = new File(this.fileName);
  }

  public void WriteToFile(int items) {
    for (int i = 0; i < items; i++) {
      Pen.format("%d ", (int)(Math.random() * 1000 + i));//format("%s,%s,%.0f\n",order.getDescription(),order.getDate(),order.getSales())
    }
    Pen.close();
  }

  public int readFromFile(){
    int number = 0;
    this.Reader.useDelimiter(" ");

    try{
      number = this.Reader.nextInt();
    }
    catch (IndexOutOfBoundsException e){
      return -1;
    }

    return number;
  }

  public void OpenFileForRead(){
    try{
      if (this.file.createNewFile()){
        System.out.println("Warning! File doesn't exist. A blank file has been created!");
      }else{
        System.out.println("File open for read successfully!.");
      }

      this.Reader = new Scanner(file);
    }
    catch (IOException e){}
  }

  public void OpenFileForWrite(){
    try{
      Pen = new Formatter(new BufferedWriter(new FileWriter(this.fileName, true)));
    }
    catch (Exception e){

      System.out.println("Warning! File doesn't exist.");
    }

  }

  public void closeFile (){
    this.Reader.close();
  }
}
