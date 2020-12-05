package validators.message;

import validators.message.status.Status;

public class Message {

    private String message;

    public Message(Status status) {
        this.status = status;
    }

    private Status status;

    @Override
    public String toString() {
        return "Message{"
                + "status="
                + status
                + ", message='"
                + message
                + '\''
                + '}';
    }

    public Message(Status status, String message) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

