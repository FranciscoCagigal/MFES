
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Regular_User_Test extends MyTestCase {
  private void TestUser() {

    Regular_User user =
        new Regular_User(
            "Diolinda",
            quotes.FemininoQuote.getInstance(),
            "diolinda@gmail.com",
            "password_diolinda",
            true,
            false);
    Regular_User user2 =
        new Regular_User(
            "Diofeia",
            quotes.FemininoQuote.getInstance(),
            "diofeia@gmail.com",
            "password_diofeia",
            false,
            true);
    Model model = new Model("Pedro Faria", 67L, quotes.MasculinoQuote.getInstance(), 1.78, 74.32);
    Fashion_Show show = new Fashion_Show("Porto", "Primavera", 2017L, 12L, 31L, 23L, 59L);
    Model_Look model_look =
        new Model_Look(
            model,
            show,
            new Fashion_Show.Date(2017L, 12L, 31L, 23L, 0L),
            "vestido azul e cor de rosa");
    assertEqual(user.getName(), "Diolinda");
    assertEqual(user2.getName(), "Diofeia");
    assertEqual(user.getPremium(), true);
    assertEqual(user2.getPremium(), false);
    assertEqual(((Object) user.getGender()), quotes.FemininoQuote.getInstance());
    assertEqual(((Object) user2.getGender()), quotes.FemininoQuote.getInstance());
    assertEqual(user.getEmail(), "diolinda@gmail.com");
    assertEqual(user2.getEmail(), "diofeia@gmail.com");
    assertEqual(user.getPassword(), "password_diolinda");
    assertEqual(user2.getPassword(), "password_diofeia");
    assertEqual(user.isAdmin(), false);
    assertEqual(user2.isAdmin(), true);
    assertEqual(user.getFavoriteLooks(), SetUtil.set());
    user.addLookToFavoriteLooks(model_look);
    assertEqual(user.getFavoriteLooks(), SetUtil.set(model_look));
    user.removeLookFromFavoriteLooks(model_look);
    assertEqual(user.getFavoriteLooks(), SetUtil.set());
    return;
  }

  public static void main_test() {

    IO.print("TestUser -> ");
    new Regular_User_Test().TestUser();
    IO.println("Passed");
  }

  public Regular_User_Test() {}

  public String toString() {

    return "Regular_User_Test{}";
  }
}
