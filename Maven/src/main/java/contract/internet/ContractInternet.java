package contract.internet;

import contract.Contract;
import org.joda.time.LocalDate;
import person.Person;


import java.util.Objects;

/**
 * Класс контракт для интернет соеденения, наследуется от класса Contract и интерфейса IContract
 * Имеет уникальное свойство speed
 * @author Валуйских Никита
 * @version 1.0
 */
public class ContractInternet extends Contract {

    /** Поле скорость интернета, измеряется в Mbps */
    private int speed;

    public ContractInternet(LocalDate dateStart, LocalDate dateFinish, int numberContract, Person person, int speed) {
        this.id = globalContractId;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.numberContract = numberContract;
        this.person = person;
        this.speed = speed;
        globalContractId++;
    }

    @Override
    public String toString() {
        return "ContractInternet{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", numberContract=" + numberContract +
                ", speed=" + speed +
                ", person=" + person +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractInternet)) return false;
        ContractInternet that = (ContractInternet) o;
        return getSpeed() == that.getSpeed() &&
                getNumberContract() == that.getNumberContract() &&
                Objects.equals(getDateStart(), that.getDateStart()) &&
                Objects.equals(getDateFinish(), that.getDateFinish()) &&
                Objects.equals(getPerson(), that.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpeed(), getId(), getDateStart(), getDateFinish(), getNumberContract(), getPerson());
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public LocalDate getDateStart() {
        return this.dateStart;
    }

    @Override
    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    @Override
    public LocalDate getDateFinish() {
        return null;
    }

    @Override
    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    @Override
    public int getNumberContract() {
        return this.numberContract;
    }

    @Override
    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }

    @Override
    public Person getPerson() {
        return this.person;
    }

    @Override
    public void setPerson(Person person) {
        this.person = person;
    }
}
