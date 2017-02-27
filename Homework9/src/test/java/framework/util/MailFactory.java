package framework.util;

import framework.model.Email;

/**
 * Created by Artur_Shamsutdzinau on 2/16/2017.
 */
public class MailFactory {
    private static final String EMAIL_ADDRESSEE = "Artur_Shamsutdzinau@epam.com";
    private static final String EMAIL_SUBJECT = "TestSubject";
    private static final String EMAIL_BODY = "TestBody";

    public static Email getNewEmail() {
        Long currentTime = System.currentTimeMillis();
        String emailBody = EMAIL_BODY + currentTime;
        return new Email(EMAIL_ADDRESSEE, EMAIL_SUBJECT, emailBody);
    }
}
