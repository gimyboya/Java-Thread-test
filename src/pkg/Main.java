package pkg;

public class Main {

    public static void main(String[] args) {
	// write your code here
      StackPrint taskTwo = new StackPrint(100);
      AddTwoArrays taskThree = new AddTwoArrays(20);

      Thread threadTwo = new Thread(taskTwo);
      Thread threadThree = new Thread(taskThree);

      threadTwo.start();
      threadThree.start();
    }
}
