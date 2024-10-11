import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем страницу репозитория qa_guru_14_10")
    public void openPageWithRepository() {
        open("https://github.com/qa-guru/qa_guru_14_10");
    }

    @Step("Кликаем по табу Issue")
    public void clickTabIssue() {
        $("#issues-repo-tab-count").click();
    }

    @Step("Проверяем наличие Issue")
    public void checkIssue(String issue){
        $("#issue_2_link").shouldHave(text(issue));

    }

}
