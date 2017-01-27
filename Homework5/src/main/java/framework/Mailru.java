package framework;


import org.openqa.selenium.By;

public class Mailru {
    public static final String MAILRU_START_PAGE = "http://mail.ru";
    public static final String FULL_USER_NAME = "arttest123@mail.ru";
    public static final String LOGIN = "arttest123";
    public static final String PASSWORD = "123blablabla";
    public static final String ADDRESSEE = "Artur_Shamsutdzinau@epam.com";
    public static final String SUBJECT = "TestSubject";
    public static final String EMAIL_BODY = "TestBody";

    //-------------------login------------------
    public static final By MAILRU_VALID_LOGIN = By.xpath("//i[@id='PH_user-email' and contains(text(),'arttest123@mail.ru')]");
    public static final By MAILRU_INVALID_LOGIN = By.xpath("//div[@class='b-login__errors']");
    public static final By INPUT_LOGIN_LOCATOR = By.xpath("//input[@id='mailbox__login']");
    public static final By INPUT_PASSWORD_LOCATOR = By.xpath("//input[@id='mailbox__password']");
    public static final By BUTTON_SUBMIT_LOCATOR = By.xpath("//input[@id='mailbox__auth__button']");

    //---------------mail.ru mail page------------
    public static final By NEW_MAIL__BUTTON_LOCATOR = By.xpath("//a[@class='b-toolbar__btn js-shortcut']");
    public static final By SENT_MAILS__BUTTON_LOCATOR = By.xpath("//a[@href='/messages/sent/']");
    public static final By DRAFT_MAILS__BUTTON_LOCATOR = By.xpath("//a[@href='/messages/drafts/']");


    //------------------new mail page-------------
    public static final By ADDRESSEE_LOCATOR = By.xpath("//textarea[@data-original-name='To']");
    public static final By SUBJECT_LOCATOR = By.xpath("//input[@class='b-input' and @name='Subject']");
    public static final By EMAIL_BODY_LOCATOR = By.xpath("//body[@id='tinymce']");
    public static final By SAVE_AS_DRAFT_LOCATOR = By.xpath("//div[@data-name='saveDraft']");
    public static final By SAVE_AS_DRAFT_DISABLED_LOCATOR = By.xpath("//div[@data-name='saveDraft'][@aria-disabled='disabled']");
    public static final By SEND_BUTTON_LOCATOR = By.xpath("//div[@data-name='send']");











}
