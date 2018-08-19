package algorithm;

import java.io.PrintStream;
import java.util.LinkedList;

public class Main {

	static PrintStream ps = System.out;

	public static void main(String[] args) {
		
		Queue<Animal> queue = new Queue<>();
		queue.enqueue(new Dog("A"));
		queue.enqueue(new Cat("B"));
		queue.enqueue(new Cat("C"));
		queue.enqueue(new Cat("D"));
		queue.enqueue(new Dog("E"));
		
		ps.println(queue.dequeueDog().getName()); // A
		
		ps.println(queue.dequeueAny().getName()); // B
		
		ps.println(queue.dequeueDog().getName()); // E
		
		ps.println(queue.dequeueCat().getName()); // C
		
		ps.println(queue.dequeueAny().getName()); // D
	}
}

class Animal { 
	private boolean out;
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public boolean isOut() {
		return out;
	}

	public void setOut(boolean out) {
		this.out = out;
	}

	public String getName() {
		return name;
	}
	
}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
}

class Cat extends Animal { 
	public Cat(String name) {
		super(name);
	}
}

class Queue<T extends Animal> {
	
	LinkedList<T> anyLinkedList = new LinkedList<>();
	LinkedList<T> dogLinkedList = new LinkedList<>();
	LinkedList<T> catLinkedList = new LinkedList<>();
	
	public void enqueue(T animal) {
		anyLinkedList.add(animal);
		if(animal instanceof Dog) {
			dogLinkedList.add(animal);
		} else {
			catLinkedList.add(animal);
		}
	}
	
	public T dequeueAny() {
		T animal = null;
		while((animal = anyLinkedList.removeFirst()).isOut());
		animal.setOut(true);
		return animal;
		
	}
	
	public T dequeueDog() {
		T animal = null;
		while((animal = dogLinkedList.removeFirst()).isOut());
		animal.setOut(true);
		return animal;
	}
	
	public T dequeueCat() {
		T animal = null;
		while((animal = catLinkedList.removeFirst()).isOut());
		animal.setOut(true);
		return animal;
	}
	
}
