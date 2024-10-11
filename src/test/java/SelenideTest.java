import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    @DisplayName("Проверка названия Issue Selenide с Listener")
    public void issueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/qa-guru/qa_guru_14_10");
        $("#issues-repo-tab-count").click();
        $("#issue_2_link").shouldHave(text("Issue for Autotest"));

    }
}
