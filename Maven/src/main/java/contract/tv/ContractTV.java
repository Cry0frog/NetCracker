package contract.tv;

import contract.Contract;
import person.Person;

import java.time.LocalDate;
import java.util.Objects;

public class ContractTV extends Contract {

    private String pack;

    public ContractTV(int id, LocalDate dateStart, LocalDate dateFinish, int numberContract, Person person, String pack){
        this.id = id;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.numberContract = numberContract;
        this.person = person;
        this.pack = pack;
    }

    @Override
    public String toString() {
        return "ContractTV{" +
                "pack='" + pack + '\'' +
                ", id=" + id +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", numberContract=" + numberContract +
                ", person=" + person +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractTV)) return false;
        ContractTV that = (ContractTV) o;
        return getId() == that.getId() &&
                getNumberContract() == that.getNumberContract() &&
                Objects.equals(getPack(), that.getPack()) &&
                Objects.equals(getDateStart(), that.getDateStart()) &&
                Objects.equals(getDateFinish(), that.getDateFinish()) &&
                Objects.equals(getPerson(), that.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPack(), getId(), getDateStart(), getDateFinish(), getNumberContract(), getPerson());
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
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
