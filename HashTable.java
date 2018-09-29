package ru.geekbrains.Lesson1;
import java.util.ArrayList;
class HashTable{
	private Item [] hashArr;
	//private ArrayList<Item> al=new ArrayList<Item>();
	//private ArrayList<Item> [] hashArr;
	private int arrSize;
	private Item nonItem;
	public HashTable(int size){
		this.arrSize = size;
		hashArr = new Item[arrSize];
		nonItem = new Item(-1);
	}

	public void display (){
		for(int i = 0 ; i < arrSize ; i ++){
			if(hashArr [ i ] != null){
				System.out.println(hashArr[ i ].getKeys());
			} else {
				System.out.println("***");
			}
		}
	}

	public int hashFunc(int key){
		return key % arrSize;
	}

	//public void insertMethod01OfOpenAddresses(Item2 item){
	//	int key = item.getKey();
	//	int hashVal = hashFunc(key);
	//	while(hashArr [ hashVal ] != null && hashArr [ hashVal ].getKey () != - 1) {
	//		++hashVal;
	//		hashVal %= arrSize;
	//	}
	//	hashArr [ hashVal ] = item;
	//}

	public void insertMethod02OfChain(Item item){
		String [] sListOfKeys = item.getKeys();
		int key=0;
		for (int i=0; i<sListOfKeys.length; i++) {
			key+=Integer.parseInt(sListOfKeys[i]);
		}
		int hashVal = hashFunc(key);
		if(hashArr[hashVal] != null ) { //&& hashArr[hashVal].getKeys().toString() != ""
			hashArr[hashVal].Add(hashVal);
		}
		else
			hashArr[hashVal] = item;
	}

	public Item delete(int key){
		int hashVal = hashFunc(key);
		while(hashArr [ hashVal ] != null) {
			if(hashArr[hashVal].getKeys().toString().indexOf(key)>=0){
				Item temp = hashArr[hashVal];
				hashArr[hashVal].delete(hashVal);
				return temp;
			}
			++hashVal;
			hashVal %= arrSize;
		}
		return null;
	}

	public Item find(int key){
		int hashVal = hashFunc(key);
		while(hashArr[hashVal]!= null) {
			String [] sAr = hashArr[hashVal].getKeys();
			for (int i=0; i<2; i++) {
				if(sAr[i] == Integer.toString(key)){
					return hashArr[hashVal];
				}
			}
			++hashVal;
			hashVal %= arrSize;
		}
		return null;
	}
}