package com.company;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(14);
        set.add(-1);
        set.add(144);
        set.add(222);
        set.add(-37);

        System.out.println(set);

        Person p1 = new Person("John", 33, true);
        Person p2 = new Person("John", 34, false);
        Person p3 = new Person("John", 23, true);
        Person p4 = new Person("John", 155, true);
        Person p5 = new Person("John", -2, true);

        System.out.println("----- HashSet -----");
        Set<Person> hashSet = new HashSet<>();
        hashSet.add(p1);
        hashSet.add(p2);
        hashSet.add(p3);
        System.out.println("HashSet size() = " + hashSet.size());

        System.out.println(hashSet);

        System.out.println();
        System.out.println("----");
        System.out.println();
        System.out.println("----- TreeSet -----");

        Set<Person> treeSet = new TreeSet<>();
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);
        treeSet.add(p5);
        System.out.println("TreeSet size() = " + treeSet.size());

        System.out.println(treeSet);

    }
}


class Person implements Comparable<Person> {
    private String name;
    private Integer age;
    private boolean isResident;

    public Person(String name, Integer age, boolean isResident) {
        this.name = name;
        this.age = age;
        this.isResident = isResident;
    }

    @Override
    public int compareTo(Person o) {
        System.out.println("compareTo");
        int comparingResult = this.name.compareTo(o.name);
        if (comparingResult == 0) {
            comparingResult = this.age.compareTo(o.age);
        }
        return comparingResult; //0
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        return age.equals(person.age);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode");
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    public String toString() {
        return String.format("Name: %s | Age: %s | Is resident: %s\n",
                this.name,
                this.age,
                this.isResident);
    }
}