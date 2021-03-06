package main;

import contract.Contract;
import contract.internet.ContractInternet;
import contract.mobile.ContractMobile;
import contract.tv.ContractTV;
import csvreader.CSVReader;
import injector.Injector;
import person.Person;
import repository.Repository;
import org.joda.time.LocalDate;
import search.searchdatefrom.SearchDataFrom;
import sort.exsample.sortdatestart.SortDateStart;
import sort.exsample.sortidcontract.SortIdContract;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] args) {
        Person man1 = new Person("Konstantin", new LocalDate(2000,5,20),'M',12345);
        Contract contract1 = new ContractInternet(new LocalDate(2020,5,20), new LocalDate(2021,6,19),123,man1,35);
        Contract contract2 = new ContractMobile(new LocalDate(2019,5,20),new LocalDate(2022,5,5),1234,man1,50000,50000,50000);
        Contract contract3 = new ContractTV(new LocalDate(2020,7,14), new LocalDate(2021,5,7),12345,man1,"Full");
        Repository repository = new Repository();

        repository.add(contract1);
        repository.add(contract2);
        repository.add(contract2);
        repository.add(contract3);

        try {
            Injector.inject(repository);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < repository.size(); i++) {
            System.out.println(repository.get(i));
        }

        repository.remove(1);
        repository.remove(3);

        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < repository.size(); i++) {
            System.out.println(repository.get(i));
        }

        repository.add(contract2);

        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < repository.size(); i++) {
            System.out.println(repository.get(i));
        }

        System.out.println("---------------------------------------------------------");

        SearchDataFrom searchDataFrom = new SearchDataFrom(new LocalDate(2020,1,1));

        Repository repository1 = repository.search(searchDataFrom);

        repository1.view();
        System.out.println("---------------------------------------------------------");

        SortIdContract sortIdContract = new SortIdContract();
        SortDateStart sortDateStart = new SortDateStart();

        repository.sort(sortIdContract);

        repository.view();
        System.out.println("---------------------------------------------------------");

        CSVReader csvReader;
        try {
            csvReader = new CSVReader(repository,new FileReader("Repository.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        repository.view();
        System.out.println("---------------------------------------------------------");
    }
}
