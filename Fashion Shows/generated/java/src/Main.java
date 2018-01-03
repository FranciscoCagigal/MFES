
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Main {
  private static Model_Test model_test = new Model_Test();
  private static Designer_Test designer_test = new Designer_Test();
  private static Show_Test show_test = new Show_Test();
  private static Regular_User_Test user_test = new Regular_User_Test();
  private static WorkShop_Test workshop_test = new WorkShop_Test();
  private static App_Test app_test = new App_Test();
  private static Reviewer_Test reviewer_test = new Reviewer_Test();
  private static Model_Look_Test model_look_test = new Model_Look_Test();
  private static Model_In_Runway_Test model_in_runway_test = new Model_In_Runway_Test();

  public static void main() {

    Main.model_test.main_test();
    Main.designer_test.main_test();
    Main.show_test.main_test();
    Main.user_test.main_test();
    Main.workshop_test.main_test();
    Main.app_test.main_test();
    Main.reviewer_test.main_test();
    Main.model_look_test.main_test();
    Main.model_in_runway_test.main_test();
  }

  public Main() {}

  public String toString() {

    return "Main{"
        + "model_test := "
        + Utils.toString(model_test)
        + ", designer_test := "
        + Utils.toString(designer_test)
        + ", show_test := "
        + Utils.toString(show_test)
        + ", user_test := "
        + Utils.toString(user_test)
        + ", workshop_test := "
        + Utils.toString(workshop_test)
        + ", app_test := "
        + Utils.toString(app_test)
        + ", reviewer_test := "
        + Utils.toString(reviewer_test)
        + ", model_look_test := "
        + Utils.toString(model_look_test)
        + ", model_in_runway_test := "
        + Utils.toString(model_in_runway_test)
        + "}";
  }
}
