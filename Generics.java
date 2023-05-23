package project_4;
import java.util.*;
public class Assignment_4 {
	public static void main(String[] args) {
		mylist<ZooAnimals1> zoo = new mylist<>("My Zoo");
		ZooAnimals1 z1 = new ZooAnimals1("Todd", 5, "Elephant", 321, false);
		ZooAnimals1 z2 = new ZooAnimals1("Mary", 2, "Lion", 222, true);
		ZooAnimals1 z3 = new ZooAnimals1("Aaron", 7, "Flamingo", 182, false);
		zoo.insertAtFront(z1);
		zoo.insertAtBack(z2);
		zoo.insertAtBack(z3);
		
		zoo.size();
	}
}
class ListNode <T> {
	T data;
	ListNode < T > nextNode;
	
	ListNode (T object) {
		this(object, null);
	}
	ListNode (T object, ListNode < T > node) {
		data = object;
		nextNode = node;
	}
	T getData(){
		return data;
	}
	ListNode<T> getNext(){
		return nextNode;
	}
}
class mylist<T>{
	public ListNode<T> first;
	public ListNode<T> last;
	public String name;
	public mylist () {
		this("My list");
	}
	public mylist (String listName) {
		name = listName;
		first = last = null;
	}
	public void insertAtBack (T insertItem){
		if(isEmpty()){
			first = last = new ListNode < T > (insertItem);
		}else {
			ListNode < T > current = first;
			while (current.nextNode != null) {
				current = current.nextNode;
			}
			current.nextNode = last = null;
		}
	}
	public void insertAtFront (T insertItem){
		if(isEmpty()) {
			first = last = new ListNode < T > (insertItem);
		}else {
			first = new ListNode < T > (insertItem, first);
		}
	}
	public boolean isEmpty(){
		return first == null;
	}
	public void print(){
		if (isEmpty()){
			System.out.printf("Empty %s\n", name);
			return;
		}
		System.out.printf("%s is:\n", name);
		ListNode<T> current = first;
		while (current != null){
			System.out.printf("%s", current.data.toString());
			current = current.nextNode;
		}
		System.out.println();
	}
	public int size() {
		int count = 0;
		ListNode < T > current = first;
		while (current != null){
			count++;
			current = current.nextNode;
		}
		return count;
	}
	public T removeFromFront() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException(name);
		}
		T removedItem = first.data;
		if(first == last) {
			first = last = null;
		}else {
			first = first.nextNode;
		}
		return removedItem;
	}
	public T removeFromBack () throws NoSuchElementException{
		if (isEmpty ()) {
			throw new NoSuchElementException (name);
		}
		T removedItem = last.data;
		if (first == last) {
			first = last = null;
		}else {
			ListNode < T > current = first;
			
			while (current.nextNode != null) {
				current = current.nextNode;
			}
			last = current;
		}
		return removedItem;
	}
	public void search(int pos) throws Exception {
		if(isEmpty()) {
			System.out.printf ("Empty %s\n", name);
			return;
		}
		System.out.printf ("%s is: ", name);
		ListNode < T > current = first;
		
		for(int i = 0;i < pos;i++) {
			if(i == pos){
				System.out.printf ("%s ", current.data);
				return;
			}else {
				current = current.nextNode;
			}
		}
		throw new Exception("index number out of bounds");
	}
}
class ZooAnimals1 {
	public String name;
	public int age;
	public String species;
	public int chip;
	public boolean carnivore;
	public ZooAnimals1(String name1, int age1, String origin1, int chip1, boolean carnivore1) {
	}
	public void ZooAnimals(String name1, int age1, String species1, int chip1, boolean carnivore1) {
		this.name = name1;
		this.age = age1;
		this.species = species1;
		this.chip = chip1;
		this.carnivore = carnivore1;
	}
}
