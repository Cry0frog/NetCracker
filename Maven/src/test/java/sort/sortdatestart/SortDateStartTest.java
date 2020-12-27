package sort.sortdatestart;

import contract.Contract;
import contract.internet.ContractInternet;
import contract.mobile.ContractMobile;
import contract.tv.ContractTV;
import org.joda.time.LocalDate;
import org.junit.Test;
import person.Person;

import static org.junit.Assert.*;

public class SortDateStartTest {

    @Test
    public void sort() {
        SortDateStart sortDateStart = new SortDateStart();

        Person man1 = new Person("Konstantin", new LocalDate(2000,5,20),'M',12345);
        Contract contract1 = new ContractInternet(new LocalDate(2020,5,20), new LocalDate(2021,6,19),123,man1,35);
        Contract contract2 = new ContractMobile(new LocalDate(2019,5,20), new LocalDate(2022,5,5),1234,man1,50000,50000,50000);
        Contract contract3 = new ContractTV(new LocalDate(2020,7,14), new LocalDate(2021,5,7),12345,man1,"Full");


        Contract[] contracts1 = new Contract[4];
        Contract[] contracts2 = new Contract[4];
        contracts1[0] = contract2;
        contracts1[1] = contract1;
        contracts1[2] = contract3;
        contracts2[0] = contract1;
        contracts2[1] = contract2;
        contracts2[2] = contract3;


        sortDateStart.sort(contracts2);

        assertArrayEquals(contracts1, contracts2);
    }
}