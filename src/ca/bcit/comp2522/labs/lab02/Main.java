package ca.bcit.comp2522.labs.lab02;

public final class Main {

    /*
    Part II Answers
        1) IncessantSpeakable was created for animals that could loudSpeak(),
        such as a Poodle. We have separate interfaces because some animals
        can speak() but not loudSpeak(). The reason IncessantSpeakable
        extends Speakable is because if an animal can loudSpeak(), it can also
        speak(). Structuring it like this allows Poodle to only need to
        implement IncessantSpeakable, and it allows for an efficient
        way to check if this animal can loudSpeak() using instanceof.

        2) The Robot class is used by Aibo. By extending from Robot,
        we know Aibo is a Robot (and a robot will have a battery).
        And by implementing Speakable, we know this robot can speak.

        3) Polymorphism means "many forms". In this case we have
        a Speakable interface, with different classes that
        implement it. However, each class has its own "form"
        of implementation. For example, a Dog's speak() method returns
        "Woof woof!" whereas a Cat's returns "Meow!"
     */

    private Main() {  }

    public static void main(final String[] args) {
        // write your code here

        // no animals were hurt during testing
        Cat c1 = new Cat();
        Cat c2 = new Cat();
        Cat c3 = new Cat();
        Dog d1 = new Dog();
        Dog d2 = new Dog();
        Poodle d3 = new Poodle();

        Aibo r1 = new Aibo();
        Aibo r2 = new Aibo();

        Speakable[] speakingThings = new Speakable[8];

        speakingThings[0] = c1;
        speakingThings[1] = c2;
        speakingThings[2] = c3;
        speakingThings[3] = d1;
        speakingThings[4] = d2;
        speakingThings[5] = d3;
        speakingThings[6] = r1;
        speakingThings[7] = r2;

        for (int i = 0; i < speakingThings.length; i++) {
            speakingThings[i].speak();
            System.out.println(speakingThings[i].getClass());
            System.out.println("is speakable: " + (speakingThings[i]
                    instanceof Speakable));
            System.out.println("is LOUDspeakable: " + (speakingThings[i]
                    instanceof IncessantSpeakable));
        }
    }
}
