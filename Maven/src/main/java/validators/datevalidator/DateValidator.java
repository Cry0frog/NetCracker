package validators.datevalidator;

import contract.Contract;
import validators.ivalidator.IValidator;
import validators.message.Message;
import validators.message.status.Status;

public class DateValidator implements IValidator {

    private Contract contract;

    public DateValidator(Contract contract) {
        this.contract = contract;
    }

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

}
