package contract;

import contract.icontract.IContract;
import org.joda.time.LocalDate;
import person.Person;


/**
 * Класс контракт со свойствами globalContractId, id, dateStart, dateFinish, numberContract и person
 * Класс наследует методы из интерфейса IContract
 * @author Валуйских Никита
 * @version 1.0
 */
public abstract class Contract implements IContract {
    /** Поле подсчета всех контрактов */
    protected static int globalContractId = 0;
    /** Поле уникального индификатора */
    protected int id;
    /** Поле начало действия контракта */
    protected LocalDate dateStart;
    /** Поле завершения действия контракта */
    protected LocalDate dateFinish;
    /** Поле номер контракта */
    protected int numberContract;
    /** Поле персона */
    protected Person person;
}
