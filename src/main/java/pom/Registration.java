package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class Registration {
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";
    @FindBy(how = How.XPATH, using = "//label[text()='Имя']/following-sibling::input")
    private SelenideElement nameInput;
    @FindBy(how = How.XPATH, using = "//label[text()='Email']/following-sibling::input")
    private SelenideElement emailInput;
    @FindBy(how = How.XPATH, using = "//label[text()='Пароль']/following-sibling::input")
    private SelenideElement passwordInput;
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement buttonReg;
    @FindBy(how = How.XPATH, using = "//h2[text ='Регистрация']")
    private SelenideElement headerReg;
    @FindBy(how = How.XPATH, using = "//a[@href='/login']")
    private SelenideElement loginLink;
    @FindBy(how = How.XPATH, using = "//p[text()='Такой пользователь уже существует']")
    private SelenideElement userAlreadyExistErrorMessage;
    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordErrorMessage;

    @Step("Заполнение поля 'Имя' значением {name}")
    public Registration fillNameInput(String name) {
        nameInput.sendKeys(Keys.SHIFT, Keys.HOME,Keys.DELETE);
        nameInput.sendKeys(name);
        return this;
    }

    @Step("Заполение поля 'Email' значением {email}")
    public Registration fillEmailInput(String email) {
        emailInput.sendKeys(Keys.SHIFT, Keys.HOME,Keys.DELETE);
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Заполение поля 'Пароль' значением {password}")
    public Registration fillPasswordInput(String password) {
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(Keys.SHIFT, Keys.HOME,Keys.DELETE);
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Клик по кнопке 'Зарегестрироваться'")
    public Registration clickButtonReg() {
        buttonReg.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Клик по ссылке 'Войти'")
    public Registration clickLinkLogIn() {
        loginLink.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Ошибка 'Такой пользователь уже существует'")
    public boolean isUserAlreadyExistErrorMessage() {
        return userAlreadyExistErrorMessage.should(Condition.exist).isDisplayed();
    }

    @Step("Ошибка 'Некорректный пароль'")
    public boolean isIncorrectPasswordErrorMessage() {
        return incorrectPasswordErrorMessage.should(Condition.exist).isDisplayed();
    }

    @Step("Ожидание закрытия страницы Регистрация")
    public Registration regPageDisappear() {
        buttonReg.shouldBe(Condition.disappear);
        return this;
    }

    @Step("Ожидание загрузки страницы Регистрация")
    public Registration regPageLoaded() {
        headerReg.shouldBe(Condition.visible);
        return this;
    }
}