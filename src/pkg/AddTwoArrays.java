package pkg;

/**
 * Created by gimy on 3/10/2017.
 */
public class AddTwoArrays implements Runnable {

  private int[] ArrayOne;
  private int[] ArrayTwo;
  private int size;

  AddTwoArrays(int size){
    this.size = size;
    ArrayOne = new int[this.size];
    ArrayTwo = new int[this.size];
  }

  private void initializeArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      array[i] = (int)(Math.random() * 100 + 1);
    }
  }

  @Override
  public void run() {
    long startTime = System.currentTimeMillis();

    initializeArray(ArrayOne);
    initializeArray(ArrayTwo);

    int[] resultArray = new int[this.size];

    for (int i = 0; i < this.size; i++) {
      resultArray[i] = this.ArrayOne[i] + this.ArrayTwo[i];
      //System.out.print("(" + ArrayOne[i] + " + " + ArrayTwo[i] + ") = " + resultArray[i] + " ");
    }

    //System.out.println("");

    long endTime = System.currentTimeMillis();

    System.out.println("Time execution for adding two one dimensional arrays with the size " + this.size + " is " + (endTime - startTime) + " Ms");
  }
}
