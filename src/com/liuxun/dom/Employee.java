package com.liuxun.dom;

public class Employee {
    private String name;
    private int age;
    private int id;
    private  double salary;

    public Employee() {
    }

    public Employee( int id,String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "\t" + name + " \t" + age + "\t" + salary;
    }
    public String getDescription() {
        return id + "\t" + name + " \t" + age + "\t" + salary;
    }
}
