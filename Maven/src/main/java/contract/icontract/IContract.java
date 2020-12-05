package contract.icontract;

import org.joda.time.LocalDate;
import person.Person;


/**
 * Contract interface, has basic methods for contract classes
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public interface IContract {

    /** Method returns id field.
     * @return id unique identifier
     * */
    int getId();

    /** Method sets the id field
     * @param id unique identifier
     * */
    void setId(int id);


    /** Method returns dateStart field
     * @return dateStart contract start date
     * */
    LocalDate getDateStart();


    /** The method sets the dateStart field
     * @param dateStart contract start date
     * */
    void setDateStart(LocalDate dateStart);


    /** Method returns dateFinish field
     * @return dateFinish contract expiration date
     * */
    LocalDate getDateFinish();


    /** The method sets the dateFinish field
     * @param dateFinish contract expiration date
     * */
    void setDateFinish(LocalDate dateFinish);

    /** The method returns the field numberContract
     * @return numberContract contract number
     */
    int getNumberContract();


    /** The method sets the numberContract field
     * @param numberContract contract number
     * */
    void setNumberContract(int numberContract);

    /** The method returns the person field
     * @return Person client
     * */
    Person getPerson();

    /** Method sets the person field
     * @param person customer
     * */
    void setPerson(Person person);
}

