package pkg;

import java.util.LinkedList;

/**
 * Created by gimy on 3/11/2017.
 */
public class LinkedListSort implements Runnable {

  private int size;
  private LinkedList<Integer> MyLinkedList;

  public LinkedListSort(int n){
    this.size = n;
    this.MyLinkedList = new LinkedList<Integer>();

    linkedListFill(this.MyLinkedList);
  }

  private void linkedListFill(LinkedList<Integer> myLinkedList) {
    for (int i = 0; i < this.size; i++) {
      myLinkedList.add((int)(Math.random()*100 + 1));
    }
  }

  private void swap(LinkedList<Integer> myLinkedList, int i, int j){

    int temp = myLinkedList.get(i);
    myLinkedList.set(i, myLinkedList.get(j));
    myLinkedList.set(j, temp);

  }

  private void quickSort(LinkedList<Integer> myLinkedList, int start, int end){
    int left = start-1;
    int right = end+1;
    final int pivot = myLinkedList.get(start);

    if(start >= end)
      return;
    while (true){
      do right--;while (myLinkedList.get(right) > pivot);
      do left++;while (myLinkedList.get(left) < pivot);

      if(left < right)
        swap(myLinkedList, left, right);
      else break;
    }

    quickSort(myLinkedList, start, right);
    quickSort(myLinkedList, right+1, end);
  }

  @Override
  public void run() {
    long startTime = System.currentTimeMillis();
    quickSort(MyLinkedList, 0, this.size-1);
    long endTime = System.currentTimeMillis();

    System.out.println("Time execution to sort " + this.size + " items for a linked-list using quick sort algorithm is " + (endTime - startTime) + " Ms");
  }
}
