//FreshAvacado ( Fiona Cai, Kendrick Liang, Kayli Matsuyoshi )
//APCS2 pd1
//HW50 -- Run Run Run
//2018-05-18f

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

  public void add(int newVal){
    if(bigVals.size() == 0 && lilVals.size() == 0 || newVal< bigVals.peekMax()){
      bigVals.add(newVal);
    }
    else{
      lilVals.add(newVal);
    }

    //balance heaps (size difference >= 2)
    while(lilVals.size()-bigVals.size() >= 2){

      if(lilVals.size() - bigVals.size() > 0){
        bigVals.add(lilVals.removeMin());
      }
      else{
        lilVals.add(bigVals.removeMax());
      }
    }
  }
}
