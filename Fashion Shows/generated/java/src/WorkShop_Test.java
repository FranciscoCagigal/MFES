
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class WorkShop_Test extends MyTestCase {
  private void TestWorkShop() {

    WorkShop workshop =
        new WorkShop(
            "Como costurar um botão?",
            new Fashion_Show.Date(2017L, 12L, 31L, 20L, 0L),
            new Fashion_Show.Date(2017L, 12L, 31L, 21L, 0L),
            20L,
            "João Botões Correia",
            "A7");
    Regular_User user1 =
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
    assertEqual(workshop.getTheme(), "Como costurar um botão?");
    assertEqual(workshop.getBeginDate(), new Fashion_Show.Date(2017L, 12L, 31L, 20L, 0L));
    assertEqual(workshop.getEndDate(), new Fashion_Show.Date(2017L, 12L, 31L, 21L, 0L));
    assertEqual(workshop.getLotation(), 20L);
    assertEqual(workshop.getOrator(), "João Botões Correia");
    assertEqual(workshop.getRoom(), "A7");
    assertEqual(workshop.getUsers(), SetUtil.set());
    workshop.addUserToWorkshop(user1);
    assertEqual(workshop.getUsers(), SetUtil.set(user1));
    workshop.addUserToWorkshop(user2);
    assertEqual(workshop.getUsers(), SetUtil.set(user1, user2));
    workshop.rmvUserToWorkshop(user1);
    assertEqual(workshop.getUsers(), SetUtil.set(user2));
    workshop.rmvUserToWorkshop(user2);
    assertEqual(workshop.getUsers(), SetUtil.set());
    return;
  }

  public static void main_test() {

    IO.print("TestWorkShop -> ");
    new WorkShop_Test().TestWorkShop();
    IO.println("Passed");
  }

  public WorkShop_Test() {}

  public String toString() {

    return "WorkShop_Test{}";
  }
}
