package mx.ipn.cic.fragmentarguments.model;

import java.io.Serializable;

/**
 * Created by jmperezsantos on 12/9/17.
 */

public class UserModel implements Serializable {

    private String name;
    private String lastname;
    private String address;
    private int age;
    private char genere;

    public UserModel() {
    }

    public UserModel(String name, String lastname, String address, int age, char genere) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.age = age;
        this.genere = genere;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGenere() {
        return genere;
    }

    public void setGenere(char genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", genere=" + genere +
                '}';
    }
}
