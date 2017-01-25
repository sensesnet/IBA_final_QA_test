package steps.StepDef;

import cucumber.api.PendingException;
import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.То;
import cucumber.runtime.java.StepDefAnnotation;

@StepDefAnnotation
public class RegistrationSteps {
    @Допустим("^я на странице \"Authentication\"$")
    public void яНаСтранице(String arg0) throws Throwable {

    }

    @И("^я заполнил поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void яЗаполнилПолеЗначением(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
    @То("^откроется страница \"([^\"]*)\" на странице регистрации$")
    public void откроетсяСтраница(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
