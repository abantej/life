package algorithms.stack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can
 * select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They
 * cannot select which specific animal they would like. Create the data structures to maintain this system
 * and implement operations such as enqueue, dequeueAny, dequequeDog, and dequeueCat. You may use the built-in
 * LinkedList data structure.
 */
public class Challenge006_AnimalShelter {
    
    private static String DOG = "dog";
    private static String CAT = "cat";

    private class Animal {
        String type;
        Animal (String type) {
            this.type = type;
        }
    }

    private class AnimalShelter extends LinkedList<Animal>{
        LinkedList<Animal> queue = new LinkedList<>();
        void enqueue(Animal animal) {
            queue.addLast(animal);
        }

        Animal dequeueAny() {
            if (queue.isEmpty()) {
                throw new RuntimeException("there are no more animals");
            }
            return queue.removeFirst();
        }

        Animal dequeueDog() {
            if (queue.isEmpty()) {
                throw new RuntimeException("there are no more animals");
            }
            Iterator<Animal> it = queue.iterator();
            Animal dog = null;
            while (it.hasNext()) {
                Animal animal = it.next();
                if (animal.type.equals(DOG)) {
                    dog = animal;
                    it.remove();
                    break;
                }
            }
            return dog;
        }

        Animal dequeueCat() {
            if (queue.isEmpty()) {
                throw new RuntimeException("there are no more animals");
            }
            Iterator<Animal> it = queue.iterator();
            Animal cat = null;
            while (it.hasNext()) {
                Animal animal = it.next();
                if (animal.type.equals(CAT)) {
                    cat = animal;
                    it.remove();
                    break;
                }
            }
            return cat;
        }
    }


    @Test
    public void animalShelterTest() {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Animal(DOG));
        shelter.enqueue(new Animal(CAT));
        shelter.enqueue(new Animal(CAT));
        shelter.enqueue(new Animal(DOG));
        shelter.enqueue(new Animal(CAT));
        shelter.enqueue(new Animal(DOG));

        assertEquals(DOG, shelter.dequeueAny().type);
        assertEquals(DOG, shelter.dequeueDog().type);
        assertEquals(CAT, shelter.dequeueCat().type);
        assertEquals(CAT, shelter.dequeueAny().type);

    }
}
