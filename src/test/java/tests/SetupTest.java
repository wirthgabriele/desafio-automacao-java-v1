package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;

public class SetupTest extends BaseTests{

    @Test
    public void testOpeningBrowser(){
        // Navegar para http://automationpractice.com/
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a url!");
    }

    @Test
    public void testCreateAccount() throws InterruptedException {
        // Clicar em Sign In
        Browser.getCurrentDriver().findElement(By.className("login")).click();
        System.out.println("Clicou em Sign in");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains((Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account"))));

        // Digitar e-mail
        Browser.getCurrentDriver().findElement(By.id("email_create")).sendKeys("mail2021112@test.com");
        System.out.println("Digitou o e-mail");

        // Clicar em Create an account
        Browser.getCurrentDriver().findElement(By.id("SubmitCreate")).click();
        System.out.println("Clicou em Create an account");

        Thread.sleep(5000);
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains((Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account#account-creation"))));

        // Selecionar Mrs.
        Browser.getCurrentDriver().findElement(By.id("id_gender2")).click();
        System.out.println("Selecionou opção Mrs.");

        // Digitar First name
        Browser.getCurrentDriver().findElement(By.id("customer_firstname")).sendKeys("Maria");
        System.out.println("Digitou o nome");

        // Digitar Last name
        Browser.getCurrentDriver().findElement(By.id("customer_lastname")).sendKeys("Silva");
        System.out.println("Digitou o sobrenome");

        // Digitar Password
        Browser.getCurrentDriver().findElement(By.id("passwd")).sendKeys("teste12345");
        System.out.println("Digitou a senha");

        // Selecionar dia
        Select select_days = new Select(Browser.getCurrentDriver().findElement(By.id("days")));
        select_days.selectByValue("8");
        System.out.println("Selecionou o dia");

        // Selecionar mês
        Select select_mouths = new Select(Browser.getCurrentDriver().findElement(By.cssSelector("select#months")));
        select_mouths.selectByValue("4");
        System.out.println("Selecionou o mês");

        // Selecionar ano
        Select select_years = new Select(Browser.getCurrentDriver().findElement(By.id("years")));
        select_years.selectByValue("1990");
        System.out.println("Selecionou o ano");

        // Digitar Address
        Browser.getCurrentDriver().findElement(By.id("address1")).sendKeys("ABC");
        System.out.println("Digitou o endereço");

        // Digitar City
        Browser.getCurrentDriver().findElement(By.id("city")).sendKeys("Orlando");
        System.out.println("Digitou a cidade");

        // Selecionar State
        Select select_state = new Select(Browser.getCurrentDriver().findElement(By.id("id_state")));
        select_state.selectByValue("10");
        System.out.println("Selecionou o estado");

        // Digitar Postal Code
        Browser.getCurrentDriver().findElement(By.id("postcode")).sendKeys("99999");
        System.out.println("Digitou o código postal");

        // Selecionar Country
        Select select_country = new Select(Browser.getCurrentDriver().findElement(By.id("id_country")));
        select_country.selectByValue("21");
        System.out.println("Selecionou o país");

        // Digitar Mobile phone
        Browser.getCurrentDriver().findElement(By.id("phone_mobile")).sendKeys("991919191");
        System.out.println("Digitou o celular");

        // Clicar em Register
        Browser.getCurrentDriver().findElement(By.id("submitAccount")).click();
        System.out.println("Clicou em Register");

        String myAccount = Browser.getCurrentDriver().findElement(By.tagName("h1")).getText();
        assertEquals("MY ACCOUNT", myAccount);

        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));

    }

}
