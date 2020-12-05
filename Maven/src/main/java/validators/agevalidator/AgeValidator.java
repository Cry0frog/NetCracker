package validators.agevalidator;

import contract.Contract;
import validators.ivalidator.IValidator;
import validators.message.Message;
import validators.message.status.Status;

public class AgeValidator implements IValidator {

    private Contract contract;

    public AgeValidator(Contract contract) {
        this.contract = contract;
    }

    @Override
    public Message status() {
        Message message;
        if (contract.getPerson().getAge() >= 18) {
            message = new Message(Status.OK);
        } else {
            message = new Message(Status.WARNING, "Age: Customer under 18");
        }
        return message;
    }
}
