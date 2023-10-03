package org.dario;

public record Person(String name, String dob) {


//    public Person(String name, String dob) {
//        this.name = name;
//        this.dob = dob.replace('-', '/');
//    }

    public Person(Person person) {

        //Es obligatorio para cualquier custom constructor hacer referencia al canonical constructor
        this(person.name, person.dob);
    }

    public Person {
        // Este es el compact constructor, un trozo de codigo que se inyectará en el canonical const
        // Estan disponibles los campos que se le pasan al constructor, pero no se le pueden asignar a los campos de clase, eso lo hará el canonical
        if (dob == null) throw new IllegalArgumentException("Bad data");


    }
}
