
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Model_In_Runway {
  private Model model;
  private String photo = null;
  private Fashion_Show.Date date;

  public void cg_init_Model_In_Runway_1(final Model model1, final Fashion_Show.Date date1) {

    model = model1;
    date = Utils.copy(date1);
    return;
  }

  public Model_In_Runway(final Model model1, final Fashion_Show.Date date1) {

    cg_init_Model_In_Runway_1(model1, Utils.copy(date1));
  }

  public Model getModel() {

    return model;
  }

  public String getPhoto() {

    return photo;
  }

  public Fashion_Show.Date getDate() {

    return Utils.copy(date);
  }

  public void setDate(final Fashion_Show.Date date1) {

    date = Utils.copy(date1);
  }

  public void setPhoto(final String photo1) {

    photo = photo1;
  }

  public void removePhoto() {

    photo = null;
  }

  public Model_In_Runway() {}

  public String toString() {

    return "Model_In_Runway{"
        + "model := "
        + Utils.toString(model)
        + ", photo := "
        + Utils.toString(photo)
        + ", date := "
        + Utils.toString(date)
        + "}";
  }
}
