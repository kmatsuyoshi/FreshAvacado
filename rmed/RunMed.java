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
    else{ //bigVals must have one more element than lilVals
      return bigVals.peekMax();
    }
  }

  public void add(Integer newVal){
    if(bigVals().isEmpty()){
      
    }
  }
}
