package validators.agevalidator;

import contract.Contract;
import validators.ivalidator.IValidator;
import validators.message.Message;
import validators.message.status.Status;

/**
 * AgeValidator class, has age validation.
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public class AgeValidator implements IValidator {

    /**
     * Field Contract
     */
    private Contract contract;

    public AgeValidator(Contract contract) {
        this.contract = contract;
    }

    public AgeValidator(){

    }

    /**
     * @see IValidator#status()
     */
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

    @Override
    public Contract getContract() {
        return contract;
    }

    @Override
    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
