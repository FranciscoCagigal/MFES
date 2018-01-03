
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Model_Test extends MyTestCase {
  private void TestModel() {

    Model model = new Model("Pedro Faria", 67L, quotes.MasculinoQuote.getInstance(), 1.78, 74.32);
    assertEqual(model.getName(), "Pedro Faria");
    assertEqual(model.getAge(), 67L);
    assertEqual(((Object) model.getGender()), quotes.MasculinoQuote.getInstance());
    assertEqual(model.getHeight(), 1.78);
    assertEqual(model.getWeight(), 74.32);
    return;
  }

  public static void main_test() {

    IO.print("TestModel -> ");
    new Model_Test().TestModel();
    IO.println("Passed");
  }

  public Model_Test() {}

  public String toString() {

    return "Model_Test{}";
  }
}
