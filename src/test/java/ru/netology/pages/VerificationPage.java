package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id='code'] input");
    private SelenideElement verifyButton = $("[data-test-id='action-verify']");
    private SelenideElement errorNotification = $("[data-test-id='error-notification']");
    private String errorNotificationWhenMore3EntryValidUser = "Превышено количество попыток ввода кода!";

    public void verifyVerificationPageVisibility() {
        codeField.shouldBe(visible);
    }

    public void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(visible);
    }

    public DashboardPage validVerify(DataHelper.VerificationCode verificationCode) {
        verify(verificationCode.getCode());
        return new DashboardPage();
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }

    public VerificationPage validVerifyMore3Times(DataHelper.VerificationCode verificationCode) {
        verify(verificationCode.getCode());
        return new VerificationPage();
    }

    public void errorNotificationWhenMore3EntryValidUser() {
        errorNotification.shouldHave(text(errorNotificationWhenMore3EntryValidUser)).shouldBe(visible);
    }
}
