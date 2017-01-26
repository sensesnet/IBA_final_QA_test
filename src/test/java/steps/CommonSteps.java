package steps;

import cucumber.api.PendingException;
import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.То;
import cucumber.runtime.java.StepDefAnnotation;
import page.PreCondition;

@StepDefAnnotation
public class CommonSteps extends PreCondition{


    @Допустим("^я на доавторизационной странице$")
    public void яНаДоавторизационнойСтранице() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @То("^откроется страница \"([^\"]*)\"$")
    public void откроетсяСтраница(String pageName) throws Throwable {
//        String elementName = null;
//
////        switch (pageName) {
//            case "Create an account":
//                WebElement elementPage = getCreateAnAccountPage().get(pageName);
//                break;
//            case "My account":
//               // WebElement elementAccountPage = get().get(pageName);
////                break;
////            case "": elementName = "not found";
////                break;
////            case "": elementName = "not found";
////                break;
////            case "": elementName = "not found";
////                break;
////            case "": elementName = "not found";
////                break;
////            case "": elementName = "not found";
////                break;
//            default: elementName = "not found";
//                break;
//        }


    }
}
