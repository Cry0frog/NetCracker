package person;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    /** Person field. */
    Person person = new Person("Lora", new LocalDate(2000,6,28),'M',13422);

    @Test
    public void calculateAge() {
        int myAge = new LocalDate().getYear() - person.getBirthday().getYear();
        int classAge = person.getAge();
        assertEquals(myAge, classAge);
    }

    @Test
    public void testEquals() {
        boolean check = person.equals("Lora", new LocalDate(2000,6,28),'M',13422);
        assertEquals(true, check);
    }
}