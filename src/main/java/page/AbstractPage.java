package page;

import driver.NameOfElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

public abstract class AbstractPage
{

    public WebElement get(String cucumberElementName)
    {
        Class<?> clazz = this.getClass();
        for (Field field : clazz.getDeclaredFields())
        {
            if (field.isAnnotationPresent(NameOfElement.class))
            {
                NameOfElement nameOfElementAnnotation = field.getAnnotation(NameOfElement.class);
                if (nameOfElementAnnotation.value().equals(cucumberElementName))
                {
                    try
                    {
                        return (WebElement) field.get(this);

                    } catch (IllegalAccessException e)
                    {
                        System.out.println("ERROR: element with name " + cucumberElementName + " at page " + this.getClass().getName() + " is not public");
                    }
                }
            }
        }
        //screenshot("No_element");
        throw new IllegalArgumentException("ERROR: there is no such element with name " + cucumberElementName + " at page " + this.getClass().getName());
    }

    public By getBy(String elementName)
    {
        Class<?> clazz = this.getClass();
        for (Field field : clazz.getDeclaredFields())
        {
            if (field.isAnnotationPresent(NameOfElement.class))
            {
                NameOfElement nameOfElementAnnotation = field.getAnnotation(NameOfElement.class);
                if (nameOfElementAnnotation.value().equals(elementName))
                {
                    try
                    {
                        return (By) field.get(this);

                    } catch (IllegalAccessException e)
                    {
                        System.out.println("ERROR: element with name " + elementName + " at page " + this.getClass().getName() + " is not public");
                    }
                }
            }
        }
        //screenshot("No_elements");
        throw new IllegalArgumentException("ERROR: there is no such element with name " + elementName + " at page " + this.getClass().getName());
    }

}
