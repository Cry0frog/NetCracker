package validators.namevalidator;

import contract.Contract;
import validators.ivalidator.IValidator;
import validators.message.Message;
import validators.message.status.Status;

public class NameValidator implements IValidator {

    private Contract contract;

    public NameValidator(Contract contract) {
        this.contract = contract;
    }

    @Override
    public Message status() {
        Message message;
        String[] name = contract.getPerson().getName().split(" ");
        if (name.length < 3) {
            message = new Message(Status.WARNING, "Name: The field does not contain the required information (Surname First name Patronymic)!");
        } else {
            message = new Message(Status.OK);
        }
        return message;
    }
}
