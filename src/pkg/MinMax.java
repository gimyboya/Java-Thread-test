package pkg;

/**
 * Created by gimy on 3/11/2017.
 */
public class MinMax implements Runnable {

  private int max;
  private int min;
  private int items;
  private String fileName;
  private FileHandler fileHandler;

  public MinMax(String fileName, int items){
    this.items = items;
    this.fileName = fileName;
    fileHandler = new FileHandler(fileName);

    fileHandler.OpenFileForWrite();
    fileHandler.WriteToFile(items);
  }
  @Override
  public void run() {
    long startTime = System.currentTimeMillis();
    int temp;
    max = 0;
    min = 0;
    fileHandler.OpenFileForRead();
    for (int i = 0; i < items; i++) {

      if(i == 0){
        max = fileHandler.readFromFile();
        min = fileHandler.readFromFile();
      }else{
        temp = fileHandler.readFromFile();
        if(temp > max){
          max = temp;
        }

        if(temp < min){
          min = temp;
        }
      }
    }
    fileHandler.closeFile();
    System.out.println("The largest number in the file " + this.fileName + " is: " + max + " and the smallest number is: " + min);
    long endTime = System.currentTimeMillis();
    System.out.println("Time execution for reading " + this.items + " numbers and finding the max and min is " + (endTime - startTime) + " Ms");
  }
}
