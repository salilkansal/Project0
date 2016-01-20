import java.util.ArrayList;
import java.util.Iterator;

class AnimalIterator<String> implements Iterator<Object> {

    private ArrayList<?> animal;
    private int position;

    public AnimalIterator(Animal animalBase) {
        this.animal = animalBase.getAnimal();
    }

    @Override
    public boolean hasNext() {
        if (position < animal.size())
            return true;
        else
            return false;
    }

    @Override
    public Object next() {
        Object aniObj = animal.get(position);
        position++;
        return aniObj;
    }

    @Override
    public void remove() {
        animal.remove(position);
    }

}

class Animal implements Iterable<String> {

    private ArrayList<String> animal = new ArrayList<String>();

    public Animal(ArrayList animal){
        this.animal = animal;
    }

    public ArrayList getAnimal() {
        return animal;
    }

    @Override
    public Iterator<String> iterator() {
        return new AnimalIterator(this);
    }

}

public class TestIterator {

    public static void main(String args[]) {
        ArrayList<String> animalList = new ArrayList();
        animalList.add("Horse");
        animalList.add("Lion");
        animalList.add("Tiger");
        Animal animal = new Animal(animalList);
        for (String animalObj : animal) {
            System.out.println(animalObj);
        }
    }
}