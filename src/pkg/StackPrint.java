package pkg;

import java.util.Stack;

/**
 * Created by gimy on 3/10/2017.
 */
public class StackPrint implements Runnable {

  private Stack<Integer> MyStack = new Stack();
  private int size;

  public StackPrint(int n){
    this.size = n;
  }

  private void stackFill(Stack<Integer> myStack) {
    for (int i = 0; i < this.size; i++) {
      myStack.add((int)(Math.random()*100 + 1));
    }
  }

  @Override
  public void run() {

    long startTime = System.currentTimeMillis();
    stackFill(this.MyStack);
    for (int i = 0; i < this.size; i++) {
      System.out.print(MyStack.get(i) + " ");
    }
    System.out.println("");
    long endTime = System.currentTimeMillis();

    System.out.println("Time execution for printing " + this.size + " Elements from the stack is " + (endTime - startTime) + " Ms");
  }
}
