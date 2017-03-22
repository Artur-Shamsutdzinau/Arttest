package framework.model;

public class Email {
    private String addressee;
    private String subject;
    private String body;

    public Email(String addressee, String subject, String body) {
        this.addressee = addressee;
        this.subject = subject;
        this.body = body;
    }

    public String getAddressee() {
        return addressee;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
