// FreshAvacado ( Fiona Cai, Kendrick Liang, Kayli Matsuyoshi )
// APCS2 pd1
// Lab03
// 2018-05-15t

/*****************************************************
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;
import java.lang.Integer;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /*****************************************************
   * default constructor  ---  inits empty heap
   *****************************************************/
  public ALHeap()
  {
      _heap = new ArrayList<Integer>();
  }

  /*****************************************************
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   *****************************************************/
  public String toString()
  {
      String returnString = java.lang.Integer.toBinaryString(_heap.get(0) );
      for( int i = 1; i < _heap.size(); i++ ) {
	  returnString += " - " + _heap.get(i);
      }
      return returnString;
  }//O(n)


  /*****************************************************
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   *****************************************************/
  public boolean isEmpty()
  {
      int i = 0;
      while ( i < _heap.size() ) {
	  if ( _heap.get(i) != null ) {
	      return false;
	  }
      }
      return true;
  }//O(n)


  /*****************************************************
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   *****************************************************/
  public Integer peekMin()
  {
      if(_heap.size() <= 0){
        return null;
      }
      else{
        return _heap.get(0);
      }
  }//O(1)


  /*****************************************************
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   *****************************************************/
  public void add( Integer addVal )
  {
    _heap.add(addVal);
    int i = _heap.size() - 1;
    int parenti = parent(i);

    while(parenti ! = i && _heap.get(i) < _heap.get(parenti)){
      swap(i, parenti);
      i = parenti;
      parenti = parent(i);
    }

  }//O(?)


  /*****************************************************
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   *****************************************************/
  public Integer removeMin()
  {
    
  }//O(?)


  /*****************************************************
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   *****************************************************/
  private int minChildPos( int pos )
  {
      if ( ( _heap.get(2*pos+1) == null &&  _heap.get(2*pos+2) == null ) || pos > _heap.size() || pos < 0 ) {
	  return -1;
      }
      else if ( _heap.get(2*pos+1) > _heap.get(2*pos+2) ) {
	  return 2*pos+2;
      }
      else {
	  return 2*pos+1;
      }
  }//O(1)


  //************ aux helper fxns ***************
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
	    return a;
    else
	    return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }

  private Integer parent(Integer i){
    if(i.intValue() % 2 == 1){
      return new Integer(i.intValue()/2);
    }
    else{
      return new Integer((i.intValue() - 1)/2);
    }
  }
  //********************************************



  //main method for testing
  public static void main( String[] args )
  {
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ALHeap pile = new ALHeap();
      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
