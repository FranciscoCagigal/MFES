
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Model_Look {
  private Model model;
  private Fashion_Show fashion_show;
  private Fashion_Show.Date date;
  private String description;

  public void cg_init_Model_Look_1(
      final Model model1,
      final Fashion_Show fashion_show1,
      final Fashion_Show.Date date1,
      final String description1) {

    model = model1;
    fashion_show = fashion_show1;
    date = Utils.copy(date1);
    description = description1;
    return;
  }

  public Model_Look(
      final Model model1,
      final Fashion_Show fashion_show1,
      final Fashion_Show.Date date1,
      final String description1) {

    cg_init_Model_Look_1(model1, fashion_show1, Utils.copy(date1), description1);
  }

  public Model getModel() {

    return model;
  }

  public Fashion_Show getFashionShow() {

    return fashion_show;
  }

  public Fashion_Show.Date getDate() {

    return Utils.copy(date);
  }

  public String getDescription() {

    return description;
  }

  public Model_Look() {}

  public String toString() {

    return "Model_Look{"
        + "model := "
        + Utils.toString(model)
        + ", fashion_show := "
        + Utils.toString(fashion_show)
        + ", date := "
        + Utils.toString(date)
        + ", description := "
        + Utils.toString(description)
        + "}";
  }
}
