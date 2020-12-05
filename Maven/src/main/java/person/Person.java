package person;


import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.util.Objects;

/**
 * Person class with properties globalPersonId, id, name, birthday, sex, passport and age
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public class Person {
    /** All customers counting field */
    private static int globalPersonId = 0;

    /** Unique identifier field */
    private int id;

    /** Last name, first name, patronymic field */
    private String name;

    /** Birthday box. */
    private LocalDate birthday;

    /** Field sex. */
    private char sex;

    /** Folder data field. */
    private int passport;

    /** Field age. */
    private int age;

    /** The method calculates age based on date of birth
     * @param birthDate Birthday
     * @param currentDate date of the current day
     * @return age
     * */
    public int calculateAge(final LocalDate birthDate, final LocalDate currentDate) {
        if(birthDate == null)return 0;
        Years age = Years.yearsBetween(birthDate, currentDate);
        return age.getYears();
    }


    @Override
    public String toString() {
        return "Person{"
                + "id="
                + id
                + ", name='"
                + name
                + '\''
                + ", birthday="
                + birthday
                + ", sex="
                + sex
                + ", passport="
                + passport
                + ", age="
                + age
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return  getSex() == person.getSex() &&
                getPassport() == person.getPassport() &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(getBirthday(), person.getBirthday());
    }

    public boolean equals(final String name, final LocalDate birthday, final char sex, final int passport) {
        return  getSex() == sex
                && getPassport() == passport
                && Objects.equals(getName(), name)
                && Objects.equals(getBirthday(), birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBirthday(), getSex(), getPassport());
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

    /** Method returns id field.
     * @return id - unique identifier
     * */
    public int getId() {
        return id;
    }

    /** Method sets the id field.
     * @param id unique identifier
     * */
    public void setId(int id) {
        this.id = id;
    }

    /** The method returns name.
     * @return name
     * */
    public String getName() {
        return name;
    }

    /** Method sets the name.
     * @param name name
     * */
    public void setName(String name) {
        this.name = name;
    }

    /** The method returns birthday
     * @return birthday
     * */
    public LocalDate getBirthday() {
        return birthday;
    }

    /** Method sets the birthday
     * @param birthday birthday
     * */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /** The method returns sex
     * @return sex
     * */
    public char getSex() {
        return sex;
    }

    /** Method sets the sex
     * @param sex sex
     * */
    public void setSex(char sex) {
        this.sex = sex;
    }

    /** The method returns passport
     * @return passport data
     * */
    public int getPassport() {
        return passport;
    }

    /** Method sets the passport
     * @param passport passport data
     * */
    public void setPassport(int passport) {
        this.passport = passport;
    }

    /** The method returns age
     * @return age
     * */
    public int getAge() {
        return age;
    }

    /** Method sets the age
     * @param age age
     * */
    public void setAge(int age) {
        this.age = age;
    }
}
