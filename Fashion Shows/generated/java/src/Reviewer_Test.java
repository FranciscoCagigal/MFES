
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Reviewer_Test extends MyTestCase {
  private void TestReviewer() {

    Reviewer reviewer =
        new Reviewer(
            "Ana Bacalhau",
            39L,
            quotes.FemininoQuote.getInstance(),
            "anabacalhau@gmail.com",
            "password_anabacalhau");
    assertEqual(reviewer.getName(), "Ana Bacalhau");
    assertEqual(reviewer.getAge(), 39L);
    assertEqual(((Object) reviewer.getGender()), quotes.FemininoQuote.getInstance());
    assertEqual(reviewer.getEmail(), "anabacalhau@gmail.com");
    assertEqual(reviewer.getPassword(), "password_anabacalhau");
    return;
  }

  public static void main_test() {

    IO.print("TestReviewer -> ");
    new Reviewer_Test().TestReviewer();
    IO.println("Passed");
  }

  public Reviewer_Test() {}

  public String toString() {

    return "Reviewer_Test{}";
  }
}
