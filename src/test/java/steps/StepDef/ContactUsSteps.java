package steps.StepDef;

import cucumber.api.PendingException;
import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.То;
import cucumber.runtime.java.StepDefAnnotation;
import entity.ContactUsEntity;
import page.PreCondition;

import java.util.List;

@StepDefAnnotation
public class ContactUsSteps extends PreCondition{

    @Допустим("^я на странице \"ContactUs\"$")
    public void яНаСтранице() throws Throwable {
      getContactUsPage().loadPage();
    }

    @И("^я заполнил все необходимые поля:$")
    public void яЗаполнилВсеНеобходимыеПоля(List<ContactUsEntity> entities) throws Throwable {
      getContactUsPage().setContactUsFields(entities);
    }

    @И("^я прикрепил \"([^\"]*)\" файл в поле \"([^\"]*)\"$")
    public void яПрикрепилФайлВПоле(String arg0, String arg1) throws Throwable {
    }

    @И("^я нажимаю на кнопку \"([^\"]*)\"$")
    public void яНажимаюНаКнопку(String buttonName) throws Throwable {
        getContactUsPage().pressButton(buttonName);
    }

    @То("^отобразится сообщение об успешной отправке:$")
    public void отобразитсяСообщениеОбУспешнойОтправке(String message) throws Throwable {
        getContactUsPage().checkMessage(message);
    }

    @То("^отобразится сообщение об неуспешной отправке:$")
    public void отобразитсяСообщениеОбНеуспешнойОтправке(String message) throws Throwable {
        getContactUsPage().checkMessage(message);
    }







    @И("^я заполнил все необходимые поля в блоке \"([^\"]*)\":$")
    public void яЗаполнилВсеНеобходимыеПоляВБлоке(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^я поставил согласие \"([^\"]*)\"$")
    public void яПоставилСогласие(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
