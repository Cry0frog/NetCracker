package person;


import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.util.Objects;

/**
 * Класс персона со свойствами globalPersonId, id, name, birthday, sex, passport и age
 * @author Валуйских Никита
 * @version 1.0
 */
public class Person {
    private static int globalPersonId = 0;
    private int id;
    private String name;
    private LocalDate birthday;
    private char sex;
    private int passport;
    private int age;

    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if(birthDate == null)return 0;
        Years age = Years.yearsBetween(birthDate, currentDate);
        return age.getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", passport=" + passport +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId() &&
                getSex() == person.getSex() &&
                getPassport() == person.getPassport() &&
                getAge() == person.getAge() &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(getBirthday(), person.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBirthday(), getSex(), getPassport(), getAge());
    }

    public Person(String name, LocalDate birthday, char sex, int passport) {
        this.id = globalPersonId;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.passport = passport;
        this.age = calculateAge(birthday, new LocalDate());
        globalPersonId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
