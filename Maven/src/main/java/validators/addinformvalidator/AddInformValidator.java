package validators.addinformvalidator;

import contract.Contract;
import contract.internet.ContractInternet;
import contract.mobile.ContractMobile;
import contract.tv.ContractTV;
import validators.ivalidator.IValidator;
import validators.message.Message;
import validators.message.status.Status;

public class AddInformValidator implements IValidator {

    private Contract contract;

    public AddInformValidator(Contract contract) {
        this.contract = contract;
    }

    @Override
    public Message status() {
        Message message = null;
        if (contract instanceof ContractMobile) {
            if (((ContractMobile) contract).getMinute() < 0 || ((ContractMobile) contract).getSms() < 0 || ((ContractMobile) contract).getGigabyte() < 0) {
                message = new Message(Status.WARNING, "Additional fields: One of the additional fields is negative!");
            } else {
                message = new Message(Status.OK);
            }
        } else if (contract instanceof ContractInternet) {
            if (((ContractInternet) contract).getSpeed() < 0) {
                message = new Message(Status.WARNING, "Additional fields: One of the additional fields is negative!");
            } else {
                message = new Message(Status.OK);
            }
        } else if (contract instanceof ContractTV) {
            if (((ContractTV) contract).getPack() == null || ((ContractTV) contract).getPack().equals("")) {
                message = new Message(Status.WARNING, "Additional fields: Additional field is empty!");
            } else {
                message = new Message(Status.OK);
            }
        }
        return message;
    }
}
