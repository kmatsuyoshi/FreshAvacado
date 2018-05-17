//FreshAvacado ( Fiona Cai, Kendrick Liang, Kayli Matsuyoshi )
//APCS2 pd1
//HW50 -- Run Run Run
//2018-05-18f

public class RunMed{
  //instance vars
  private ALHeapMin lilVals;
  private ALHeapMax bigVals;

  //constructor
  public RunMed(){
    lilVals = new ALHeapMin();
    bigVals = new ALHeapMax();
  }


  /*****************************************************
   * double getMedian()
   * Returns running median of numbers inputted
   *****************************************************/
  public double getMedian(){
    if(bigVals.isEmpty()){ //
      throw new NoSuchElementException();
    }
    else if(bigVals.size() == lilVals.size()){ //heaps are same size, take avg of max and min
      return (bigVals.peekMax() + lilVals.peekMin()) / 2.0;
    }
    else{ //median is the max or min of heap that has 1 more element than the other
      if(bigVals().size > lilVals.size()){
        return bigVals.peekMax();
      }
      else{
        return lilVals.peekMin();
      }
    }
  }

  public void add(int newVal){
    //add item to correct heap
    if(newVal < bigVals.peekMax()){ //if item is smaller than maxHeap root, add to maxheap
      bigVals.add(new Integer(newVal));
    }
    else{
      lilVals.add(new Integer(newVal));
    }

    //balance heaps (size difference > 2)
    if(Math.abs(bigVals.size() - lilVals.size()) > 1){
      if(bigVals.size() > lilVals.size()){
        
      }
    }
  }
}
