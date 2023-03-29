package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

@Entity
@Table(name="Dogs", uniqueConstraints = @UniqueConstraint(columnNames = "age", name = "UK_???????('age"))
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "int(11) unsigned NOT NULL")
    private int id;
    @Column(name="age",columnDefinition = "tinyint(3) unsigned NOT NULL")
    private int age;
    @Column(name="name",length=200, nullable = false)
    private String name;
    @Column(name="reside_state", columnDefinition = "char(2) DEFAULT 'XX'")
    private String resideState;

    public Dog() {}
    public Dog(int id, int age, String name, String resideState){
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}
//1) id
//  2) age
//  3) name
//  4) resideState
