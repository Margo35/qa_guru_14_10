import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    private static final String ISSUE = "Issue for Autotest";

    @Test
    @DisplayName("Проверка названия Issue с помощью Selenide с Listener")
    public void lambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу репозитория qa_guru_14_10", ()-> {
            open("https://github.com/qa-guru/qa_guru_14_10");
        });

        step("Кликаем по табу Issue", ()-> {
            $("#issues-repo-tab-count").click();
        });

        step("Проверяем наличие Issue" + ISSUE, ()-> {
            $("#issue_2_link").shouldHave(text(ISSUE));
        });

    }

    @Test
    @DisplayName("Проверка наличия issue " + ISSUE + " с помощью аннотации @Step")
    void stepAnnotationTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openPageWithRepository();
        steps.clickTabIssue();
        steps.checkIssue(ISSUE);


    }

}
