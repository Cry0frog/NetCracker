package validators.datevalidator;

import contract.Contract;
import validators.ivalidator.IValidator;
import validators.message.Message;
import validators.message.status.Status;

/**
 * DateValidator class, has date validation.
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public class DateValidator implements IValidator {

    /**
     * Field Contract
     */
    private Contract contract;

    public DateValidator(Contract contract) {
        this.contract = contract;
    }

    public DateValidator(){

    }

    /**
     * @see IValidator#status()
     */
    @Override
    public Message status() {
        Message message;
        if(contract.getDateStart().isBefore(contract.getDateFinish())) {
            message = new Message(Status.OK);
        } else {
            message = new Message(Status.WARNING, "Date: The contract end date is less than the start date!");
        }
        return message;
    }

    @Override
    public Contract getContract() {
        return contract;
    }

    @Override
    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
