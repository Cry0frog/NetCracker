package contract.icontract;

import person.Person;

import java.time.LocalDate;


public interface IContract {
    int getId();
    void setId(int id);
    LocalDate getDateStart();
    void setDateStart(LocalDate dateStart);
    LocalDate getDateFinish();
    void setDateFinish(LocalDate dateFinish);
    int getNumberContract();
    void setNumberContract(int numberContract);
    Person getPerson();
    void setPerson(Person person);
}

