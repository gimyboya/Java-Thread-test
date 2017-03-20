package pkg;

public class Main {

    public static void main(String[] args) {
	// write your code here
      LinkedListSort taskOne = new LinkedListSort(100);
      StackPrint taskTwo = new StackPrint(100);
      AddTwoArrays taskThree = new AddTwoArrays(20);
      MinMax taskFour = new MinMax("greatNumbers.txt", 100);

      Thread threadOne = new Thread(taskOne);
      Thread threadTwo = new Thread(taskTwo);
      Thread threadThree = new Thread(taskThree);
      Thread threadFour = new Thread(taskFour);

      threadOne.start();
      threadTwo.start();
      threadThree.start();
      threadFour.start();
    }
}
