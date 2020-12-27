package validators.ivalidator;

import contract.Contract;
import validators.message.Message;

/**
 * IValidator interface, has method status.
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public interface IValidator {

    /**
     * Method validates
     * @return Message value
     */
    Message status();
    Contract getContract();
    void setContract(Contract contract);

}
