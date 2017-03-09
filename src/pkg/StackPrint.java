package pkg;

import java.util.Stack;

/**
 * Created by gimy on 3/10/2017.
 */
public class StackPrint implements Runnable {

  private Stack<Integer> MyStack = new Stack();

  public StackPrint(){
    stackFill(this.MyStack);
  }

  private void stackFill(Stack<Integer> myStack) {
    for (int i = 0; i < 100; i++) {
      myStack.add((int)(Math.random()*100 + 1));
    }
  }

  @Override
  public void run() {

    for (int i = 0; i < 100; i++) {
      System.out.println(MyStack.get(i));
    }

  }
}
