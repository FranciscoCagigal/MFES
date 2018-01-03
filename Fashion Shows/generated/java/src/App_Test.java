
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class App_Test extends MyTestCase {
  private void TestApp() {

    App app = new App();
    Regular_User user =
        new Regular_User(
            "Diolinda",
            quotes.FemininoQuote.getInstance(),
            "diolinda@gmail.com",
            "password_diolinda",
            false,
            true);
    Fashion_Show show = new Fashion_Show("Porto", "Primavera", 2017L, 12L, 31L, 23L, 59L);
    Fashion_Show show2 = new Fashion_Show("Porto", "Outono", 2018L, 12L, 31L, 23L, 59L);
    Fashion_Show show3 = new Fashion_Show("Porto", "Outono", 2018L, 10L, 31L, 23L, 59L);
    assertEqual(app.getUsers(), SetUtil.set());
    app.addUserToApp(user);
    assertEqual(app.getUsers(), SetUtil.set(user));
    app.rmvUserToApp(user);
    assertEqual(app.getUsers(), SetUtil.set());
    assertEqual(app.getShows(), SetUtil.set());
    app.addShowToApp(show);
    assertEqual(app.getShows(), SetUtil.set(show));
    app.rmvShowToApp(show);
    assertEqual(app.getShows(), SetUtil.set());
    app.addShowToApp(show);
    app.addShowToApp(show2);
    app.addShowToApp(show3);
    assertEqual(app.getShowsByTheme("Primavera"), SetUtil.set(show));
    assertEqual(app.getShowsByTheme("Outono"), SetUtil.set(show3, show2));
    assertEqual(app.getShowsByDate(), SeqUtil.seq(show, show3, show2));
    app.rmvShowToApp(show);
    app.rmvShowToApp(show2);
    app.rmvShowToApp(show3);
    assertEqual(app.getShowsByTheme("Outono"), SetUtil.set());
    assertEqual(app.getShowsByDate(), SeqUtil.seq());
    assertEqual(
        app.compareDates(
            new Fashion_Show.Date(2018L, 12L, 31L, 10L, 30L),
            new Fashion_Show.Date(2017L, 12L, 31L, 10L, 30L)),
        false);
    assertEqual(
        app.compareDates(
            new Fashion_Show.Date(2017L, 12L, 31L, 10L, 30L),
            new Fashion_Show.Date(2018L, 12L, 31L, 10L, 30L)),
        true);
    assertEqual(
        app.compareDates(
            new Fashion_Show.Date(2017L, 12L, 31L, 10L, 30L),
            new Fashion_Show.Date(2017L, 11L, 30L, 10L, 30L)),
        false);
    assertEqual(
        app.compareDates(
            new Fashion_Show.Date(2017L, 11L, 30L, 10L, 30L),
            new Fashion_Show.Date(2017L, 12L, 31L, 10L, 30L)),
        true);
    assertEqual(
        app.compareDates(
            new Fashion_Show.Date(2017L, 12L, 31L, 10L, 30L),
            new Fashion_Show.Date(2017L, 12L, 30L, 10L, 30L)),
        false);
    assertEqual(
        app.compareDates(
            new Fashion_Show.Date(2017L, 12L, 30L, 10L, 30L),
            new Fashion_Show.Date(2017L, 12L, 31L, 10L, 30L)),
        true);
    assertEqual(
        app.compareDates(
            new Fashion_Show.Date(2017L, 12L, 31L, 11L, 30L),
            new Fashion_Show.Date(2017L, 12L, 31L, 10L, 30L)),
        false);
    assertEqual(
        app.compareDates(
            new Fashion_Show.Date(2017L, 12L, 31L, 10L, 30L),
            new Fashion_Show.Date(2017L, 12L, 31L, 11L, 30L)),
        true);
    assertEqual(
        app.compareDates(
            new Fashion_Show.Date(2017L, 12L, 31L, 11L, 20L),
            new Fashion_Show.Date(2017L, 12L, 31L, 11L, 19L)),
        false);
    assertEqual(
        app.compareDates(
            new Fashion_Show.Date(2017L, 12L, 31L, 11L, 19L),
            new Fashion_Show.Date(2017L, 12L, 31L, 11L, 20L)),
        true);
    assertEqual(
        app.compareDates(
            new Fashion_Show.Date(2017L, 12L, 31L, 11L, 20L),
            new Fashion_Show.Date(2017L, 12L, 31L, 11L, 20L)),
        true);
    return;
  }

  public static void main_test() {

    IO.print("TestApp -> ");
    new App_Test().TestApp();
    IO.println("Passed");
  }

  public App_Test() {}

  public String toString() {

    return "App_Test{}";
  }
}
