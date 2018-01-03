
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Reviewer extends User {
  private Number age;

  public void cg_init_Reviewer_1(
      final String name1,
      final Number age1,
      final Object gender1,
      final String email1,
      final String password1) {

    name = name1;
    age = age1;
    gender = gender1;
    email = email1;
    password = password1;
    return;
  }

  public Reviewer(
      final String name1,
      final Number age1,
      final Object gender1,
      final String email1,
      final String password1) {

    cg_init_Reviewer_1(name1, age1, gender1, email1, password1);
  }

  public Number getAge() {

    return age;
  }

  public Reviewer() {}

  public String toString() {

    return "Reviewer{" + "age := " + Utils.toString(age) + "}";
  }
}
