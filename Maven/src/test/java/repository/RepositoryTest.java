package repository;

import contract.Contract;
import contract.internet.ContractInternet;
import contract.mobile.ContractMobile;
import contract.tv.ContractTV;
import org.joda.time.LocalDate;
import org.junit.Test;
import person.Person;
import search.isearch.ISearch;
import search.searchdatefrom.SearchDataFrom;
import sort.isorter.ISort;
import sort.exsample.sortidcontract.SortIdContract;

import static org.junit.Assert.*;

public class RepositoryTest {

    Repository repository = new Repository();

    Person man1 = new Person("Konstantin", new LocalDate(2000,5,20),'M',12345);
    Contract contract1 = new ContractInternet(new LocalDate(2020,5,20), new LocalDate(2021,6,19),123,man1,35);
    Contract contract2 = new ContractMobile(new LocalDate(2019,5,20), new LocalDate(2022,5,5),1234,man1,50000,50000,50000);
    Contract contract3 = new ContractTV(new LocalDate(2020,7,14), new LocalDate(2021,5,7),12345,man1,"Full");

    @Test
    public void add() {
        Contract[] contracts = {contract1, contract2, contract3};
        repository.add(contract1);
        repository.add(contract2);
        repository.add(contract3);
        repository.add(contract1);

        Contract[] contracts1 = repository.forEach();

        assertArrayEquals(contracts, contracts1);
    }

    @Test
    public void get() {
        repository.add(contract1);

        int id = contract1.getId();
        Contract contract = repository.get(id);

        assertEquals(contract1, contract);
    }

    @Test
    public void remove() {
        repository.add(contract1);
        repository.add(contract2);

        int id = contract1.getId();
        repository.remove(id);

        if(repository.forEach().length > 1) {
            fail();
        }

    }

    @Test
    public void search() {
        repository.add(contract1);
        repository.add(contract2);
        repository.add(contract3);

        ISearch iSearch = new SearchDataFrom(new LocalDate(2020,6,5));
        Repository repository1 = repository.search(iSearch);
        Repository repository2 = new Repository();
        repository2.add(contract3);

        assertArrayEquals(repository1.forEach(), repository2.forEach());
    }

    @Test
    public void sort() {
        ISort iSort = new SortIdContract();
        repository.add(contract3);
        repository.add(contract1);
        repository.add(contract2);

        Repository repository1 = new Repository();
        repository1.add(contract1);
        repository1.add(contract2);
        repository1.add(contract3);

        repository.sort(iSort);
        assertArrayEquals(repository1.forEach(), repository.forEach());
    }
}