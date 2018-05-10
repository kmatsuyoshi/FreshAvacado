// FreshAvacado ( Fiona Cai, Kendrick Liang, Kayli Matsuyoshi )
// APCS2 pd1
// Lab03
// 2018-05-11w

import java.util.ArrayList;

public class ArrayPriorityQueue {

    // INSTANCE VARIABLES
    private ArrayList<String> _data;
    
    // CONSTRUCTOR
    public ArrayPriorityQueue() {
	_data = new ArrayList<String>();
    }

    // METHODS
    
    // Adds an item to this priority queue.
    public void add( String s ) {
        _data.add(s);
    }

    // Returns true if this stack is empty, otherwise returns false.
    public boolean isEmpty() {
	return _data.size() == 0;
    }

    // Returns the smallest item stored in this priority queue without removing it.
    public String peekMin() {
        if (isEmpty()) {
	    return null;
	}
	int mindex = 0;
	for (int i = 0; i < _data.size(); i++){
	    if (_data.get(i).compareTo(_data.get(mindex)) < 0)
		mindex = i;
	}
	return _data.get(mindex);
    }

    // Removes and returns the smallest item stored in this priority queue.
    public String removeMin() {
        if (isEmpty()){
	    return null;
	}
	int mindex = 0;
	for (int i = 0; i < _data.size(); i++){
	    if (_data.get(i).compareTo(_data.get(mindex)) < 0)
		mindex = i;
	}
	return _data.remove(mindex);
    }

    // MAIN METHOD
    public static void main( String[] args ) {
	
	System.out.println( "...INITIATING TESTING..." );

	System.out.println( "...ScrombleTongs Testing..." );
	
	System.out.println( "...testing default constructor..." );
	ArrayPriorityQueue scromble = new ArrayPriorityQueue();
	
	System.out.println( "...testing add()..." );
	scromble.add("all");
	scromble.add("women");
	scromble.add("are");
	scromble.add("queens");
	
	System.out.println( "...testing peekMin()..." );
	System.out.println( scromble.peekMin() ); // are

	System.out.println( "...testing isEmpty()..." );
	System.out.println( scromble.isEmpty() ); // false
	
	System.out.println( "...testing removeMin()..." );
	System.out.println( scromble.removeMin() ); // all
	System.out.println( scromble.removeMin() ); // are
	System.out.println( scromble.removeMin() ); // women
	System.out.println( scromble.removeMin() ); // queens
	
	System.out.println( "...testing isEmpty()..." );
	System.out.println( scromble.isEmpty() ); // true

	System.out.println( "...QokoNeuts Testing..." );

	ArrayPriorityQueue arrQ = new ArrayPriorityQueue();
	arrQ.add("Undead");
	arrQ.add("Ado");
	arrQ.add("Soon");
	arrQ.add("Need");
	arrQ.add("Seagull");
	arrQ.add("Fearless");
	System.out.println(arrQ.peekMin());
	System.out.println(arrQ.removeMin());
	System.out.println(arrQ.removeMin());
	System.out.println(arrQ.removeMin());
	System.out.println(arrQ.removeMin());
	System.out.println(arrQ.removeMin());
	System.out.println(arrQ.removeMin());
	System.out.println(arrQ.removeMin());

	System.out.println( "...Find Design Testing..." );

	ArrayPriorityQueue test = new ArrayPriorityQueue();
	System.out.println(test.isEmpty()); //TRUE
	test.add("hi");
	test.add("ahmed");
	test.add("can't");
	test.add("make");
	test.add("wordsearchpuzzles");

	System.out.println(test.isEmpty()); //FALSE
	System.out.println(test.peekMin()); //ahmed
	System.out.println(test.removeMin()); //removes ahmed
	while(!test.isEmpty()){
	    System.out.println(test.removeMin());
	}
	System.out.println(test.isEmpty()); //TRUE

	System.out.println( "...TERMINATING TESTING..." );
    }


} // end class ArrPQ
