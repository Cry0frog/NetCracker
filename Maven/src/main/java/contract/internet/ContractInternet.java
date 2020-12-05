package contract.internet;

import contract.Contract;
import contract.icontract.IContract;
import org.joda.time.LocalDate;
import person.Person;


import java.util.Objects;

/**
 * The contract class for the Internet connection, inherits from the Contract class and the IContract interface
 * Has a unique property speed
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public class ContractInternet extends Contract {


    /** Internet speed field, measured in Mbps */
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
        return Objects.hash(getSpeed(), getDateStart(), getDateFinish(), getNumberContract(), getPerson());
    }

    /** The method returns the speed field
     * @return speed
     * */
    public int getSpeed() {
        return speed;
    }

    /** Method sets the speed field
     * @param speed speed
     * */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @see IContract#getId() 
     * */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * @see IContract#setId(int) 
     * */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @see IContract#getDateStart() 
     * */
    @Override
    public LocalDate getDateStart() {
        return this.dateStart;
    }

    /**
     * @see IContract#setDateStart(LocalDate) 
     * */
    @Override
    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * @see IContract#getDateFinish() 
     * */
    @Override
    public LocalDate getDateFinish() {
        return this.dateFinish;
    }

    /**
     * @see IContract#setDateFinish(LocalDate) 
     * */
    @Override
    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    /**
     * @see IContract#getNumberContract() 
     * */
    @Override
    public int getNumberContract() {
        return this.numberContract;
    }

    /**
     * @see IContract#setNumberContract(int) 
     * */
    @Override
    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }

    /**
     * @see IContract#getPerson() 
     * */
    @Override
    public Person getPerson() {
        return this.person;
    }

    /**
     * @see IContract#setPerson(Person) 
     * */
    @Override
    public void setPerson(Person person) {
        this.person = person;
    }
}
