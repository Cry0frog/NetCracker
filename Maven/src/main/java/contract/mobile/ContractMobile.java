package contract.mobile;

import contract.Contract;
import contract.icontract.IContract;
import org.joda.time.LocalDate;
import person.Person;


import java.util.Objects;

/**
 * The contract class for mobile communication, inherits from the Contract class and the IContract interface
 * Has unique property minute, gigabyte and sms
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public class ContractMobile extends Contract {

    /** Minute field */
    private int minute;

    /** gigabyte field */
    private int gigabyte;

    /** SMS field */
    private int sms;

    @Override
    public String toString() {
        return "ContractMobile{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", numberContract=" + numberContract +
                ", minute=" + minute +
                ", gigabyte=" + gigabyte +
                ", sms=" + sms +
                ", person=" + person +
                '}';
    }

    public  ContractMobile(LocalDate dateStart, LocalDate dateFinish, int numberContract, Person person, int minute, int gigabyte, int sms){
        this.id = globalContractId;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.numberContract = numberContract;
        this.person = person;
        this.minute = minute;
        this.gigabyte = gigabyte;
        this.sms = sms;
        globalContractId++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractMobile)) return false;
        ContractMobile that = (ContractMobile) o;
        return getMinute() == that.getMinute() &&
                getGigabyte() == that.getGigabyte() &&
                getSms() == that.getSms() &&
                getNumberContract() == that.getNumberContract() &&
                Objects.equals(getDateStart(), that.getDateStart()) &&
                Objects.equals(getDateFinish(), that.getDateFinish()) &&
                Objects.equals(getPerson(), that.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMinute(), getGigabyte(), getSms(), getDateStart(), getDateFinish(), getNumberContract(), getPerson());
    }

    /**
     * Method returns minute
     * @return minute
     * */
    public int getMinute() {
        return minute;
    }

    /**
     * Method sets minute
     * @param minute minutes
     * */
    public void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * Method returns gigabyte
     * @return gigabyte
     * */
    public int getGigabyte() {
        return gigabyte;
    }

    /**
     * Method installs gigabyte
     * @param gigabyte gigabytes
     * */
    public void setGigabyte(int gigabyte) {
        this.gigabyte = gigabyte;
    }

    /**
     * Method returns sms
     * @return sms
     * */
    public int getSms() {
        return sms;
    }

    /**
     * Method sets sms
     * @param sms sms
     * */
    public void setSms(int sms) {
        this.sms = sms;
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
