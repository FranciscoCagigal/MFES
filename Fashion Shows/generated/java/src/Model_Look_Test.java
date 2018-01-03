
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Model_Look_Test extends MyTestCase {
  private void TestModelLook() {

    Model model = new Model("Pedro Faria", 67L, quotes.MasculinoQuote.getInstance(), 1.78, 74.32);
    Fashion_Show show = new Fashion_Show("Porto", "Primavera", 2017L, 12L, 31L, 23L, 59L);
    Model_Look model_look =
        new Model_Look(
            model,
            show,
            new Fashion_Show.Date(2017L, 12L, 31L, 23L, 0L),
            "vestido azul e cor de rosa");
    assertEqual(model_look.getModel(), model);
    assertEqual(model_look.getFashionShow(), show);
    assertEqual(model_look.getDate(), new Fashion_Show.Date(2017L, 12L, 31L, 23L, 0L));
    assertEqual(model_look.getDescription(), "vestido azul e cor de rosa");
    return;
  }

  public static void main_test() {

    IO.print("TestModelLook -> ");
    new Model_Look_Test().TestModelLook();
    IO.println("Passed");
  }

  public Model_Look_Test() {}

  public String toString() {

    return "Model_Look_Test{}";
  }
}
