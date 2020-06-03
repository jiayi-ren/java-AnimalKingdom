package animalkingdom;

import java.util.*;

public class Main {

    public static List<Animal> filteredAnimals = new ArrayList<>();

    public static void filterAnimals(List<Animal> animals, CheckAnimal tester, boolean printIt) {
        filteredAnimals.clear();

        for (Animal a : animals) {
            if(tester.test(a)) {
                if(printIt) {
                    System.out.println(a.getName() + " " + a.reproduce() + " " + a.move() + " " + a.breath() + " " + a.getYear());
                }
                filteredAnimals.add(a);
            }
        }
    }

    public static void main(String[] args) {
        Mammals pandas = new Mammals("Pandas", 1869);
        Mammals zebra = new Mammals("Zebra", 1778);
        Mammals koala = new Mammals("Koala", 1816);
        Mammals sloth = new Mammals("Sloth", 1804);
        Mammals armadillo = new Mammals("Armadillo", 1758);
        Mammals raccoon = new Mammals("Raccoon", 1758);
        Mammals bigfoot = new Mammals("Bigfoot", 2021);

        Birds pigeon = new Birds("Pigeon", 1837);
        Birds peacock = new Birds("Peacock", 1821);
        Birds toucan = new Birds("Toucan", 1758);
        Birds parrot = new Birds("Parrot", 1824);
        Birds swan = new Birds("Swan", 1758);

        Fish salmon = new Fish("Salmon", 1758);
        Fish catfish = new Fish("Catfish", 1817);
        Fish perch = new Fish("Perch", 1758);

        List<Animal> animalList = new ArrayList<>();
        animalList.add(pandas);
        animalList.add(zebra);
        animalList.add(koala);
        animalList.add(sloth);
        animalList.add(armadillo);
        animalList.add(raccoon);
        animalList.add(bigfoot);
        animalList.add(pigeon);
        animalList.add(peacock);
        animalList.add(toucan);
        animalList.add(parrot);
        animalList.add(swan);
        animalList.add(salmon);
        animalList.add(catfish);
        animalList.add(perch);

        System.out.println(animalList + "\n");

        System.out.println("***MVP***\n");
        System.out.println("*** List all the animals in descending order by year named ***");
        animalList.sort(Comparator.comparing(a -> a.getYear(), Comparator.reverseOrder()));
        animalList.forEach((a) -> System.out.println(a));

        System.out.println();

        System.out.println("*** List all the animals alphabetically ***");
        animalList.sort((a1, a2) -> a1.getName().compareTo(a2.getName()));
        animalList.forEach((a) -> System.out.println(a));

        System.out.println();

        System.out.println("*** List all the animals order by how they move ***");
        animalList.sort((a1, a2) -> a1.move().compareTo(a2.move()));
        animalList.forEach((a) -> System.out.println(a));

        System.out.println();

        System.out.println("*** List only those animals the breath with lungs ***");
        filterAnimals(animalList, a -> a.breath().toLowerCase().equals("lungs"), true);

        System.out.println();

        System.out.println("*** List only those animals that breath with lungs and were named in 1758 ***");
        filterAnimals(animalList, a -> (a.breath().toLowerCase().equals("lungs"))&&(a.getYear() == 1758), true);

        System.out.println();

        System.out.println("*** List only those animals that lay eggs and breath with lungs ***");
        filterAnimals(animalList, a -> (a.breath().toLowerCase().equals("lungs"))&&(a.reproduce().toLowerCase().equals("eggs")), true);

        System.out.println();

        System.out.println("*** List alphabetically only those animals that were named in 1758 ***");
        filterAnimals(animalList, a -> a.getYear() == 1758,true);
        
        System.out.println();

        System.out.println("*** Stretch Goal ***\n\n*** For the list of animals, list alphabetically those animals that are mammals ***");
        filterAnimals(animalList, a -> a.move().toLowerCase().equals("walk"),true);
        
    }
}