package steps;

import cucumber.api.PendingException;
import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.То;
import cucumber.runtime.java.StepDefAnnotation;

@StepDefAnnotation
public class CommonSteps {


    @Допустим("^я на доавторизационной странице$")
    public void яНаДоавторизационнойСтранице() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @То("^откроется страница \"([^\"]*)\"$")
    public void откроетсяСтраница(String pageName) throws Throwable {

    }
}
