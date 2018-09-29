package ru.geekbrains.Lesson1;
import java.util.ArrayList;

class Item {
	//private int data;
	private ArrayList<String> al=new ArrayList<String>();
	public Item(int data){
		if (this.al.indexOf(Integer.toString(data))<0) {
			this.al.add(Integer.toString(data));
		}
		//this.data = data;
	}
	public ArrayList<String> Add(int data){
		if (this.al.indexOf(Integer.toString(data))<0) {
			this.al.add(Integer.toString(data));
		}
		return this.al;
		//this.data = data;
	}
	public void delete(int data){
		if (this.al.indexOf(Integer.toString(data))<0) {
			this.al.remove(Integer.toString(data));
		}
		return;
	}
	public String [] getKeys(){
		String[] ItemArr = new String[this.al.size()];
		ItemArr = this.al.toArray(ItemArr);
		return ItemArr;
	}
}
class Item2 {
	private int data;
	public Item2(int data){
		this.data = data;
	}
	public int getKey(){
		return this.data;
	}
}