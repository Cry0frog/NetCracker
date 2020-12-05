package contract.tv;

import contract.Contract;
import contract.icontract.IContract;
import org.joda.time.LocalDate;
import person.Person;


import java.util.Objects;


/**
 * The contract class for digital television, inherits from the Contract class and the IContract interface
 * Has a unique property pack
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public class ContractTV extends Contract {

    /** Field connection package */
    private String pack;

    public ContractTV(LocalDate dateStart, LocalDate dateFinish, int numberContract, Person person, String pack){
        this.id = globalContractId;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.numberContract = numberContract;
        this.person = person;
        this.pack = pack;
        globalContractId++;
    }

    @Override
    public String toString() {
        return "ContractTV{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", numberContract=" + numberContract +
                ", pack='" + pack + '\'' +
                ", person=" + person +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractTV)) return false;
        ContractTV that = (ContractTV) o;
        return  getNumberContract() == that.getNumberContract() &&
                Objects.equals(getPack(), that.getPack()) &&
                Objects.equals(getDateStart(), that.getDateStart()) &&
                Objects.equals(getDateFinish(), that.getDateFinish()) &&
                Objects.equals(getPerson(), that.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPack(), getDateStart(), getDateFinish(), getNumberContract(), getPerson());
    }

    /**
     * The method returns pack
     * @return pack package name
     * */
    public String getPack() {
        return pack;
    }

    /**
     * Method sets pack
     * @param pack package name
     * */
    public void setPack(String pack) {
        this.pack = pack;
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
