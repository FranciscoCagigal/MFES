
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Fashion_Designer {
  private String name;
  private Number age;

  public void cg_init_Fashion_Designer_1(final String name1, final Number age1) {

    name = name1;
    age = age1;
    return;
  }

  public Fashion_Designer(final String name1, final Number age1) {

    cg_init_Fashion_Designer_1(name1, age1);
  }

  public String getName() {

    return name;
  }

  public Number getAge() {

    return age;
  }

  public Fashion_Designer() {}

  public String toString() {

    return "Fashion_Designer{"
        + "name := "
        + Utils.toString(name)
        + ", age := "
        + Utils.toString(age)
        + "}";
  }
}
