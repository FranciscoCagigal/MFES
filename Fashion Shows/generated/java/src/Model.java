
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Model {
  public static final Number minAge = 18L;
  private String name;
  private Number age;
  private Object gender;
  private Number height;
  private Number weight;

  public void cg_init_Model_1(
      final String name1,
      final Number age1,
      final Object gender1,
      final Number height1,
      final Number weight1) {

    name = name1;
    age = age1;
    gender = gender1;
    height = height1;
    weight = weight1;
    return;
  }

  public Model(
      final String name1,
      final Number age1,
      final Object gender1,
      final Number height1,
      final Number weight1) {

    cg_init_Model_1(name1, age1, gender1, height1, weight1);
  }

  public String getName() {

    return name;
  }

  public Number getAge() {

    return age;
  }

  public Object getGender() {

    return gender;
  }

  public Number getHeight() {

    return height;
  }

  public Number getWeight() {

    return weight;
  }

  public Model() {}

  public String toString() {

    return "Model{"
        + "minAge = "
        + Utils.toString(minAge)
        + ", name := "
        + Utils.toString(name)
        + ", age := "
        + Utils.toString(age)
        + ", gender := "
        + Utils.toString(gender)
        + ", height := "
        + Utils.toString(height)
        + ", weight := "
        + Utils.toString(weight)
        + "}";
  }
}
