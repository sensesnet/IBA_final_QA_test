package entity;

public class ContactUsEntity {

    private String subject_heading;
    private String email_address;
    private String order_reference;
    private String message;

    public String getSubject_heading() {
        return subject_heading;
    }

    public void setSubject_heading(String subject_heading) {
        this.subject_heading = subject_heading;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getOrder_reference() {
        return order_reference;
    }

    public void setOrder_reference(String order_reference) {
        this.order_reference = order_reference;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
