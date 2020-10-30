package contract.icontract;

import org.joda.time.LocalDate;
import person.Person;


/**
 * Интерфейс контракт, имеет базовые методы для классов контрактов
 * @author Валуйских Никита
 * @version 1.0
 */
public interface IContract {
    /** Метод возвращает поле id */
    int getId();

    /** Метод устанавливает поле id */
    void setId(int id);

    /** Метод возвращает поле dateStart */
    LocalDate getDateStart();

    /** Метод устанавливает поле dateStart */
    void setDateStart(LocalDate dateStart);

    /** Метод возвращает поле dateFinish */
    LocalDate getDateFinish();

    /** Метод устанавливает поле dateFinish */
    void setDateFinish(LocalDate dateFinish);

    /** Метод возвращает поле numberContract */
    int getNumberContract();

    /** Метод устанавливает поле numberContract */
    void setNumberContract(int numberContract);

    /** Метод возвращает поле person */
    Person getPerson();

    /** Метод устанавливает поле person */
    void setPerson(Person person);
}

