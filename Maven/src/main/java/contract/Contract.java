package contract;

import contract.icontract.IContract;
import org.joda.time.LocalDate;
import person.Person;


/**
 * Class contract with properties globalContractId, id, dateStart, dateFinish, numberContract and person
 * The class inherits methods from the IContract interface
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public abstract class Contract implements IContract {
    /** Field counting for all contracts */
    protected static int globalContractId = 0;
    /** Unique identifier field */
    protected int id;
    /** Contract start field */
    protected LocalDate dateStart;
    /** Contract expiration field */
    protected LocalDate dateFinish;
    /** Field contract number */
    protected int numberContract;
    /** Persona field */
    protected Person person;
}
