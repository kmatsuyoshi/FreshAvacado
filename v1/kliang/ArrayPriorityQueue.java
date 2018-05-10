/*
QokoNeuts (Kendrick Liang, Lynne Wang)
APCS2 pd1
HW #46: Arrr, There Be Priorities Here Matey
2018-05-10
*/
import java.util.ArrayList;
public class ArrayPriorityQueue implements PriorityQueue{
    private ArrayList<String> arr;
    public ArrayPriorityQueue(){
	arr = new ArrayList<String>();
    }
    public boolean isEmpty(){//O(1)
	return arr.size() == 0;
    }
    public void add(String x){//O(1)
	arr.add(x);
    }
    public String peekMin(){//O(n)
	if (isEmpty()){
	    return null;
	}
	int mindex = 0;
	for (int i = 0; i < arr.size(); i++){
	    if (arr.get(i).compareTo(arr.get(mindex)) < 0)
		mindex = i;
	}
	return arr.get(mindex);
    }
    public String removeMin(){//O(n)
	if (isEmpty()){
	    return null;
	}
	int mindex = 0;
	for (int i = 0; i < arr.size(); i++){
	    if (arr.get(i).compareTo(arr.get(mindex)) < 0)
		mindex = i;
	}
	return arr.remove(mindex);
    }
    public static void main(String[]args){
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
    }
}
