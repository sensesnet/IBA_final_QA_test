package steps.StepDef;

import cucumber.api.PendingException;
import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.То;
import cucumber.runtime.java.StepDefAnnotation;
import page.PreCondition;

@StepDefAnnotation
public class RegistrationSteps extends PreCondition {
    @Допустим("^я на странице \"Authentication\"$")
    public void яНаСтранице() throws Throwable {
        getAuthenticationPage().loadPage();
    }

    @И("^я заполнил поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void яЗаполнилПолеЗначением(String fieldName, String value) throws Throwable {
        getAuthenticationPage().setValueToField(fieldName, value);
    }

    @То("^откроется страница \"([^\"]*)\" на странице регистрации$")
    public void откроетсяСтраница(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @И("^я нажимаю на кнопку \"([^\"]*)\" на странице \"Authentication\"$")
    public void яНажимаюНаКнопкуНаСтранице(String buttonName) throws Throwable {
        getAuthenticationPage().pressButton(buttonName);
    }
}
