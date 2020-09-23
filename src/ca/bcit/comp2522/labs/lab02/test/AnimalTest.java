package ca.bcit.comp2522.labs.lab02.test;

import ca.bcit.comp2522.labs.lab02.Aibo;
import ca.bcit.comp2522.labs.lab02.Cat;
import ca.bcit.comp2522.labs.lab02.Dog;
import ca.bcit.comp2522.labs.lab02.IncessantSpeakable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** AnimalTest. Tests Animal and related classes. */
public class AnimalTest {
    /** Tests if Cat is an instance of IncessantSpeakable. */
    @Test
    public void testIncessantSpeakableOfCat() {
        Cat c = new Cat();

        assertEquals(false, (c instanceof IncessantSpeakable));
    }

    /**
     * Tests if Dog is an instance of IncessantSpeakable.
     * Tests Dog's getSpeak().
     */
    @Test
    public void testIncessantSpeakableOfDog() {
        Dog d = new Dog();

        assertEquals(false, (d instanceof IncessantSpeakable));
        assertEquals("Woof woof!", d.getSpeak());
    }

    /** Tests if Aibo is an instance of IncessantSpeakable. */
    @Test
    public void testIncessantSpeakableOfAibo() {
        Aibo a = new Aibo();

        assertEquals(false, (a instanceof IncessantSpeakable));
    }
}
