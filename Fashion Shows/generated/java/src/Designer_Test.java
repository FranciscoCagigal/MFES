
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Designer_Test extends MyTestCase {
  public void TestDesigner() {

    Fashion_Designer designer = new Fashion_Designer("Andre Correia", 54L);
    assertEqual(designer.getName(), "Andre Correia");
    assertEqual(designer.getAge(), 54L);
    return;
  }

  public static void main_test() {

    IO.print("TestDesigner -> ");
    new Designer_Test().TestDesigner();
    IO.println("Passed");
  }

  public Designer_Test() {}

  public String toString() {

    return "Designer_Test{}";
  }
}
