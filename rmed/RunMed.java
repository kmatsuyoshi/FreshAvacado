//FreshAvacado ( Fiona Cai, Kendrick Liang, Kayli Matsuyoshi )
//APCS2 pd1
//HW50 -- Run Run Run
//2018-05-18f
/*****************************************************
* 1. Add the inputted data to one of two Heaps, a MinHeap and a MaxHeap.
*	  If there are no values in either heap, or if the new value is less than the maximum of the smaller values stored in the MaxHeap, then the value will be added to the MaxHeap.
*	  If otherwise, then the value is instead added to the MinHeap.
* 2. Balance the Heaps
*	  This is accomplished by removing minimum or maximum values and adding them onto the other heap to ensure that the heaps do not exceed each other in size by 2 or more elements.
* 3. The median is obtained
*	  If there is only one value stored, the only value in the MaxHeap is returned.
*	  If the heaps are equal in size, then the mean of the minimum of the heap of larger values and the maximum of the heap with smaller values is returned.
*	  If the size of the heap with larger values is greater, then the minimum of that heap is returned.
*	  And if otherwise, the maximum of the heap with smaller values is returned.
 *****************************************************/
import java.util.NoSuchElementException;

public class RunMed{
  //instance vars
  private ALHeapMax bigVals;
  private ALHeapMin lilVals;

  //constructor
  public RunMed(){
    bigVals = new ALHeapMax();
    lilVals = new ALHeapMin();
  }


  /*****************************************************
   * double getMedian()
   * Returns running median of numbers inputted
   * throws NoSuchElementException() if heaps are empty
   *****************************************************/
  public double getMedian(){
    if(lilVals.isEmpty() && bigVals.isEmpty()){ //
      throw new NoSuchElementException();
    }
    else if(lilVals.isEmpty()){ //only one item
      return bigVals.peekMax();
    }

    if(bigVals.size() == lilVals.size()){ //heaps are same size, take avg of max and min
      return ((bigVals.peekMax() + lilVals.peekMin()) / 2.0);
    }
    else if (lilVals.size() > bigVals.size()){ //median is the max or min of heap that has 1 more element than the other
        return lilVals.peekMin();
    }
    else{
        return bigVals.peekMax();
      }

  }

  /*****************************************************
   * add(int newVal)
   * adds new value into either bigVals heap or lilVals heap
   * balances heaps if the size difference is greater than 1
   *****************************************************/
  public void add(int newVal){
    if(bigVals.size() == 0 && lilVals.size() == 0 || newVal< bigVals.peekMax()){ //if heaps are empty or value is less belongs in first half (bigVals)
      bigVals.add(newVal);
    }
    else{ //else value belongs in bigger half (lilVals)
      lilVals.add(newVal);
    }

    //balance heaps (size difference >= 2)
    while(lilVals.size()-bigVals.size() >= 2){

      if(lilVals.size() - bigVals.size() > 0){ //if lilVals has extra item
        bigVals.add(lilVals.removeMin()); //remove from min from lilVals and add to bigVals
      }
      else{ //else bigVals has extra items
        lilVals.add(bigVals.removeMax()); //remove max from bigVals and add to lilVals
      }
    }
  }
}
