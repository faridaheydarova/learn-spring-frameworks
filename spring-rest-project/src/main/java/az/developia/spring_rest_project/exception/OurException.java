package az.developia.spring_rest_project.exception;

public class OurException extends RuntimeException{
    private String internalMessage;

    public String getInternalMessage() {
        return internalMessage;
    }

    public void setInternalMessage(String internalMessage) {
        this.internalMessage = internalMessage;
    }

    public OurException(String message, String internalMessage) {
        super(message);
        this.internalMessage = internalMessage;
    }
}
//message-user
//internalmessage-developer