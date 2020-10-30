package main;

import contract.Contract;
import contract.internet.ContractInternet;
import contract.mobile.ContractMobile;
import contract.tv.ContractTV;
import person.Person;
import repository.Repository;
import org.joda.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Person man1 = new Person("Konstantin", new LocalDate(2000,5,20),'M',12345);
        Contract contract1 = new ContractInternet(new LocalDate(2020,5,20), new LocalDate(2021,5,20),123,man1,35);
        Contract contract2 = new ContractMobile(new LocalDate(2019,5,20),new LocalDate(2021,5,20),1234,man1,50000,50000,50000);
        Contract contract3 = new ContractTV(new LocalDate(2020,7,14), new LocalDate(2021,5,20),12345,man1,"Full");
        Repository repository = new Repository();

        repository.add(contract1);
        repository.add(contract2);
        repository.add(contract2);
        repository.add(contract3);

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
    }
}
