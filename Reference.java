/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Reference;

import java.util.*;

class Animal {

    private String tipo;

    public Animal(String tipo) {

        this.tipo = tipo;
    }


    public String getTipo() {
        return tipo;
    }
}


public class Reference {

    interface AnonClass {

        public void anonSort();

        public void anonSort1();
    }

    
    public static int compareByTipo(Animal a, Animal b) {
        return a.getTipo().compareTo(b.getTipo());
    }

  
    public static void main(String[] args) {

        List<String> animales = new ArrayList<String>();
        animales.add("perro");
        animales.add("gato");
        animales.add("iguana");
        animales.add("vaca");
        animales.add("hamster");
        animales.add("cabra");
        animales.add("venado");
        animales.add("elefante");
        animales.add("leon");
        animales.add("aguila");

        AnonClass anon = new AnonClass() {
            
            public void anonSort() {
                Collections.sort(animales);
                System.out.println(animales);
            }

            public void anonSort1() {
                animales.sort(Comparator.comparing(String::length));
                System.out.println(animales);
            }
        };
        
        System.out.println("Sort por clase anónima: ");
        anon.anonSort();
        anon.anonSort1();
        System.out.println("\n");

        System.out.println("Sort por expresión lambda: ");
        animales.sort((p1, p2) -> p1.compareTo(p2));
        System.out.println(animales);

        Collections.sort(animales, (a, b) -> a.length() - b.length());
        System.out.println(animales);
        
        System.out.println("\nSort por método de referencia: ");
        
        List<Animal> listaAnimales = new ArrayList<>();       
        listaAnimales.add(new Animal("Perro"));
        listaAnimales.add(new Animal("Gato"));
        listaAnimales.add(new Animal("Hamster"));
        listaAnimales.add(new Animal("Elefante"));
        listaAnimales.add(new Animal("Jirafa"));
        listaAnimales.add(new Animal("Gorila"));
        listaAnimales.add(new Animal("Guacamaya"));
        listaAnimales.add(new Animal("Garza"));
        listaAnimales.add(new Animal("Pato"));
        listaAnimales.add(new Animal("Tortuga"));

        Collections.sort(listaAnimales, Reference::compareByTipo);

        listaAnimales.stream()
                .map(x -> x.getTipo())
                .forEach(System.out::println);

    }
}
