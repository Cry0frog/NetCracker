package person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;


public class Person {
    private int id;
    private String name;
    private LocalDate birthday;
    private char sex;
    private int passport;
    private int age = Period.between(birthday, LocalDate.now()).getYears();

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

    public Person(int id, String name, LocalDate birthday, char sex, int passport) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.passport = passport;
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
