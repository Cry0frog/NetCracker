package contract;

import contract.icontract.IContract;
import person.Person;

import java.time.LocalDate;

public abstract class Contract implements IContract {
    protected int id;
    protected LocalDate dateStart;
    protected LocalDate dateFinish;
    protected int numberContract;
    protected Person person;
}
