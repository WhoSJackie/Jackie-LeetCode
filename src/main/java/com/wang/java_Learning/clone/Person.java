package com.wang.java_Learning.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;

@AllArgsConstructor
@Data
public class Person implements Cloneable{
    private Address address;
    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person person =  (Person)super.clone();
        person.setAddress(person.getAddress().clone());
        return person;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person(new Address("wuhan",1));
        Person person2 = new Person(new Address("wuhan",1));
        HashSet<Person> set = new HashSet<>();
        set.add(person1);
        set.add(person2);
        for (Person person : set) {
            System.out.println(person);
        }
//        Person clonePerson = person1.clone();
//        System.out.println(person1.getAddress()==clonePerson.getAddress());
    }
}

@AllArgsConstructor
@Data
class Address implements Cloneable{
    private String name;
    private int code;
    @Override
    protected Address clone() throws CloneNotSupportedException {
        Address address = (Address)super.clone();
        address.setName(address.getName());
        return address;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Address address1 = new Address("wuhan",1);
        Address address2 = new Address("wuhan",1);
        Address address3 = new Address("wuhan",2);
//        HashSet<Address> set  =new HashSet<>();
//        set.add(address1);
//        set.add(address2);
//        set.add(address3);
//        for (Address address : set) {
//            System.out.println(address);
//        }
        Address cloneAddr = address1.clone();
        System.out.println(address1.getName()==cloneAddr.getName());
    }
}


