import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestExample {

    @Test
    public void applicationForACardTest() throws InterruptedException {
        open("http://0.0.0.0:9999");
        SelenideElement form = $("form");
        form.$(".input.input_type_text.input_view_default input[name='name']").setValue("Салтыков-Щедрин Михаил");
        form.$("input[name='phone']").setValue("+79999999999");
        form.$("label[data-test-id='agreement']").click();
        form.$("button").click();
        $("[data-test-id$='success']").shouldHave(Condition.exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
