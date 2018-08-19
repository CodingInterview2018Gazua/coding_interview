package Chapter3.animalshelter;

public class Test180819 {
	public static void main(String[] args) {
		AnimalShelter Test = new AnimalShelter();
		
		
		Test.enQueue(new Dog());
		Test.enQueue(new Dog());
		Test.enQueue(new Dog());
		Test.enQueue(new Dog());
		Test.enQueue(new Cat());
		Test.enQueue(new Cat());
		Test.enQueue(new Cat());
		
		Test.deQueueAny();
		Test.deQueueDog();
		Test.deQueueCat();
		
		Test.print();
	}
}
