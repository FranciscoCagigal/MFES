
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Model_In_Runway_Test extends MyTestCase {
  public void TestModelInRunaway() {

    Model model1 = new Model("Pedro Faria", 67L, quotes.MasculinoQuote.getInstance(), 1.78, 74.32);
    Model_In_Runway model1_rw =
        new Model_In_Runway(model1, new Fashion_Show.Date(2017L, 12L, 31L, 20L, 0L));
    assertEqual(model1_rw.getModel(), model1);
    assertEqual(model1_rw.getDate(), new Fashion_Show.Date(2017L, 12L, 31L, 20L, 0L));
    model1_rw.setPhoto("picture.png");
    assertEqual(model1_rw.getPhoto(), "picture.png");
    model1_rw.removePhoto();
    model1_rw.setDate(new Fashion_Show.Date(2017L, 11L, 10L, 15L, 0L));
    assertEqual(model1_rw.getDate(), new Fashion_Show.Date(2017L, 11L, 10L, 15L, 0L));
    return;
  }

  public static void main_test() {

    IO.print("TestModelInRunaway -> ");
    new Model_In_Runway_Test().TestModelInRunaway();
    IO.println("Passed");
  }

  public Model_In_Runway_Test() {}

  public String toString() {

    return "Model_In_Runway_Test{}";
  }
}
