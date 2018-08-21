package Chapter3.animalshelter;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
	private Queue<AllowedAnimal> mShelter = new LinkedList<>();

	public void enQueue(AllowedAnimal animal) {
		mShelter.offer(animal);
	}

	public AllowedAnimal deQueueAny() {
		if (!mShelter.isEmpty())
			return mShelter.poll();
		else {
			return null;
		}
	}

	public Dog deQueueDog() {
		Queue<AllowedAnimal> mCage = new LinkedList<>();
		Dog dog = null;

		while (!mShelter.isEmpty()) {
			AllowedAnimal data = mShelter.poll();

			if (dog == null && data instanceof Dog) {
				dog = (Dog) data;
			} else {
				mCage.offer(data);
			}
		}

		mShelter = mCage;

		return dog;
	}

	public Cat deQueueCat() {
		Queue<AllowedAnimal> mCage = new LinkedList<>();
		Cat cat = null;

		while (!mShelter.isEmpty()) {
			AllowedAnimal data = mShelter.poll();

			if (cat == null && data instanceof Cat) {
				cat = (Cat) data;
			} else {
				mCage.offer(data);
			}
		}

		mShelter = mCage;

		return cat;
	}

	public void print() {
		while (!mShelter.isEmpty()) {
			System.out.println(mShelter.poll().toString());
		}
	}
}
