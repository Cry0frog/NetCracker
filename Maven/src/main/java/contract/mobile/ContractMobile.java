package contract.mobile;

import contract.Contract;
import org.joda.time.LocalDate;
import person.Person;


import java.util.Objects;

/**
 * Класс контракт для мобильной связи, наследуется от класса Contract и интерфейса IContract
 * Имеет уникальное свойство minute, gigabyte и sms
 * @author Валуйских Никита
 * @version 1.0
 */
public class ContractMobile extends Contract {

    /** Поле минуты */
    private int minute;

    /** Поле gigabyte */
    private int gigabyte;

    /** Поле смс */
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
        return Objects.hash(getMinute(), getGigabyte(), getSms(), getId(), getDateStart(), getDateFinish(), getNumberContract(), getPerson());
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getGigabyte() {
        return gigabyte;
    }

    public void setGigabyte(int gigabyte) {
        this.gigabyte = gigabyte;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
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
