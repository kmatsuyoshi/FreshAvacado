//FreshAvacado ( Fiona Cai, Kendrick Liang, Kayli Matsuyoshi )
//APCS2 pd1
//HW50 -- Run Run Run
//2018-05-18f

import java.util.NoSuchElementException;

public class RunMed{
  //instance vars
  private ALHeapMin bigVals;
  private ALHeapMax lilVals;

  //constructor
  public RunMed(){
    bigVals = new ALHeapMin();
    lilVals = new ALHeapMax();
  }


  /*****************************************************
   * double getMedian()
   * Returns running median of numbers inputted
   *****************************************************/
  public double getMedian(){
    if(lilVals.isEmpty()){ //
      throw new NoSuchElementException();
    }
    else if(bigVals.size() == lilVals.size()){ //heaps are same size, take avg of max and min
      return (bigVals.peekMin() + lilVals.peekMax()) / 2.0;
    }
    else{ //median is the max or min of heap that has 1 more element than the other
      if(lilVals.size() > bigVals.size()){
        return lilVals.peekMax();
      }
      else{
        return bigVals.peekMin();
      }
    }
  }

  public void add(int newVal){
    //add item to correct heap
    if(newVal < lilVals.peekMax()){ //if item is smaller than lilVals root, add to lilVals
      lilVals.add(new Integer(newVal));
    }
    else{ //else add to lilVals
      bigVals.add(new Integer(newVal));
    }

    //balance heaps (size difference >= 2)
    while(Math.abs(bigVals.size() - lilVals.size()) >= 2){
      if(bigVals.size() - lilVals.size() > 0){ //bigVals has extra items
        lilVals.add(bigVals.removeMin());
      }
      else{ //else lilVals has the extra item
        bigVals.add(lilVals.removeMax());
      }
    }
  }
}
