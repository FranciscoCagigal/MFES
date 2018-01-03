
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Fashion_Show {
  private String location;
  private Date date;
  private String theme;
  private VDMMap models = MapUtil.map();
  private VDMSet workshops = SetUtil.set();
  private VDMMap critics = MapUtil.map();
  private VDMMap program = MapUtil.map();

  public void cg_init_Fashion_Show_1(
      final String location1,
      final String theme1,
      final Number year,
      final Number month,
      final Number day,
      final Number hour,
      final Number minute) {

    location = location1;
    theme = theme1;
    date = new Date(year, month, day, hour, minute);
    return;
  }

  public Fashion_Show(
      final String location1,
      final String theme1,
      final Number year,
      final Number month,
      final Number day,
      final Number hour,
      final Number minute) {

    cg_init_Fashion_Show_1(location1, theme1, year, month, day, hour, minute);
  }

  public String getLocation() {

    return location;
  }

  public String getTheme() {

    return theme;
  }

  public Date getDate() {

    return Utils.copy(date);
  }

  public VDMSet getDesigners() {

    return MapUtil.dom(Utils.copy(models));
  }

  public VDMMap getModels() {

    return Utils.copy(models);
  }

  public VDMMap getProgramShow() {

    return Utils.copy(program);
  }

  public VDMSeq getModelsOfDesigner(final Fashion_Designer Fashion_Designer) {

    VDMSeq l = SeqUtil.seq();
    for (Iterator iterator_4 =
            SeqUtil.elems(Utils.copy(((VDMSeq) Utils.get(models, Fashion_Designer)))).iterator();
        iterator_4.hasNext();
        ) {
      Model_In_Runway m = (Model_In_Runway) iterator_4.next();
      l = SeqUtil.conc(Utils.copy(l), SeqUtil.seq(m.getModel()));
    }
    return Utils.copy(l);
  }

  public VDMSeq getModelsInRunwayOfDesigner(final Fashion_Designer Fashion_Designer) {

    return Utils.copy(((VDMSeq) Utils.get(models, Fashion_Designer)));
  }

  public VDMSet getWorkShops() {

    return Utils.copy(workshops);
  }

  public VDMMap getCritics() {

    return Utils.copy(critics);
  }

  public void addDesignerToShow(final Fashion_Designer Fashion_Designer) {

    models =
        MapUtil.override(
            Utils.copy(models), MapUtil.map(new Maplet(Fashion_Designer, SeqUtil.seq())));
  }

  public void rmvDesignerToShow(final Fashion_Designer Fashion_Designer) {

    models = MapUtil.domResBy(SetUtil.set(Fashion_Designer), Utils.copy(models));
  }

  public void addModelToShow(final Fashion_Designer Fashion_Designer, final Model Model) {

    VDMMap im = MapUtil.inverse(Utils.copy(program));
    Date d = Utils.copy(((Date) Utils.get(im, Fashion_Designer)));
    Date newdate = null;
    Model_In_Runway mrw = null;
    if (Utils.equals(((VDMSeq) Utils.get(models, Fashion_Designer)).size(), 0L)) {
      mrw = new Model_In_Runway(Model, Utils.copy(d));
    } else {
      d =
          ((Model_In_Runway)
                  Utils.get(
                      ((VDMSeq) Utils.get(models, Fashion_Designer)),
                      ((VDMSeq) Utils.get(models, Fashion_Designer)).size()))
              .getDate();
      if (Utils.equals(d.minute, 59L)) {
        newdate = new Date(d.year, d.month, d.day, d.hour.longValue() + 1L, 0L);
      } else {
        newdate = new Date(d.year, d.month, d.day, d.hour, d.minute.longValue() + 1L);
      }

      mrw = new Model_In_Runway(Model, Utils.copy(newdate));
    }

    Utils.mapSeqUpdate(
        models,
        Fashion_Designer,
        SeqUtil.conc(Utils.copy(((VDMSeq) Utils.get(models, Fashion_Designer))), SeqUtil.seq(mrw)));
  }

  public void removeModelToShow(final Fashion_Designer Fashion_Designer, final Model Model) {

    VDMSeq seqAux = SeqUtil.seq();
    for (Iterator iterator_5 =
            SeqUtil.inds(((VDMSeq) Utils.get(models, Fashion_Designer))).iterator();
        iterator_5.hasNext();
        ) {
      Number i = (Number) iterator_5.next();
      if (!(Utils.equals(
          ((Model_In_Runway) Utils.get(((VDMSeq) Utils.get(models, Fashion_Designer)), i))
              .getModel(),
          Model))) {
        seqAux =
            SeqUtil.conc(
                Utils.copy(seqAux),
                SeqUtil.seq(
                    ((Model_In_Runway)
                        Utils.get(((VDMSeq) Utils.get(models, Fashion_Designer)), i))));
      }
    }
    Utils.mapSeqUpdate(models, Fashion_Designer, Utils.copy(seqAux));
  }

  public void addDesignerToProgramShow(final Date dateShow, final Fashion_Designer designer) {

    program =
        MapUtil.override(
            Utils.copy(program), MapUtil.map(new Maplet(Utils.copy(dateShow), designer)));
  }

  public void removeDesignerFromProgramShow(final Date dateShow) {

    program = MapUtil.domResBy(SetUtil.set(Utils.copy(dateShow)), Utils.copy(program));
  }

  public Fashion_Designer getDesignerByDate(final Date dateShow) {

    return ((Fashion_Designer) Utils.get(program, dateShow));
  }

  public VDMSet getListOfDatesByDesigner(final Fashion_Designer designer) {

    VDMMap m = MapUtil.rngResTo(Utils.copy(program), SetUtil.set(designer));
    VDMSet l = MapUtil.dom(Utils.copy(m));
    return Utils.copy(l);
  }

  public void addWorkShopToShow(final WorkShop WorkShop) {

    workshops = SetUtil.union(Utils.copy(workshops), SetUtil.set(WorkShop));
  }

  public void rmvWorkShopToShow(final WorkShop WorkShop) {

    workshops = SetUtil.diff(Utils.copy(workshops), SetUtil.set(WorkShop));
  }

  public void workShopBooking(final WorkShop WorkShop, final Regular_User User) {

    WorkShop.addUserToWorkshop(User);
  }

  public void addCritic(final Reviewer Reviewer, final Critic Critic) {

    critics =
        MapUtil.override(
            Utils.copy(critics), MapUtil.map(new Maplet(Reviewer, Utils.copy(Critic))));
  }

  public void rmvCritic(final Reviewer Reviewer) {

    critics = MapUtil.domResBy(SetUtil.set(Reviewer), Utils.copy(critics));
  }

  public Number getAvgReview() {

    Number sum = 0L;
    for (Iterator iterator_6 = MapUtil.dom(Utils.copy(critics)).iterator();
        iterator_6.hasNext();
        ) {
      Reviewer reviewer = (Reviewer) iterator_6.next();
      sum = sum.doubleValue() + ((Critic) Utils.get(critics, reviewer)).rate.longValue();
    }
    if (MapUtil.dom(Utils.copy(critics)).size() > 0L) {
      return Utils.divide(sum.doubleValue(), MapUtil.dom(Utils.copy(critics)).size());

    } else {
      return sum;
    }
  }

  public Boolean checkProgramDisponibility(final Date desiredDate) {

    VDMSet l = MapUtil.dom(Utils.copy(program));
    Number minutesDesrired = HoursToMinutes(desiredDate.hour, desiredDate.minute);
    for (Iterator iterator_7 = l.iterator(); iterator_7.hasNext(); ) {
      Date d = (Date) iterator_7.next();
      Boolean andResult_12 = false;

      if (Utils.equals(d.year, desiredDate.year)) {
        Boolean andResult_13 = false;

        if (Utils.equals(d.month, desiredDate.month)) {
          if (Utils.equals(d.day, desiredDate.day)) {
            andResult_13 = true;
          }
        }

        if (andResult_13) {
          andResult_12 = true;
        }
      }

      if (andResult_12) {
        Boolean orResult_2 = false;

        Boolean andResult_14 = false;

        if (HoursToMinutes(d.hour, d.minute).longValue() < minutesDesrired.longValue()) {
          if (HoursToMinutes(d.hour, d.minute).longValue() > minutesDesrired.longValue() - 30L) {
            andResult_14 = true;
          }
        }

        if (andResult_14) {
          orResult_2 = true;
        } else {
          Boolean andResult_15 = false;

          if (HoursToMinutes(d.hour, d.minute).longValue() > minutesDesrired.longValue()) {
            if (HoursToMinutes(d.hour, d.minute).longValue() < minutesDesrired.longValue() + 30L) {
              andResult_15 = true;
            }
          }

          orResult_2 = andResult_15;
        }

        if (orResult_2) {
          return false;
        }
      }
    }
    return true;
  }

  public Fashion_Show() {}

  public static Number DaysOfMonth(final Number month, final Number year) {

    Boolean orResult_3 = false;

    if (Utils.equals(month, 1L)) {
      orResult_3 = true;
    } else {
      Boolean orResult_4 = false;

      if (Utils.equals(month, 3L)) {
        orResult_4 = true;
      } else {
        Boolean orResult_5 = false;

        if (Utils.equals(month, 5L)) {
          orResult_5 = true;
        } else {
          Boolean orResult_6 = false;

          if (Utils.equals(month, 7L)) {
            orResult_6 = true;
          } else {
            Boolean orResult_7 = false;

            if (Utils.equals(month, 8L)) {
              orResult_7 = true;
            } else {
              Boolean orResult_8 = false;

              if (Utils.equals(month, 10L)) {
                orResult_8 = true;
              } else {
                orResult_8 = Utils.equals(month, 12L);
              }

              orResult_7 = orResult_8;
            }

            orResult_6 = orResult_7;
          }

          orResult_5 = orResult_6;
        }

        orResult_4 = orResult_5;
      }

      orResult_3 = orResult_4;
    }

    if (orResult_3) {
      return 31L;

    } else {
      Boolean andResult_16 = false;

      if (Utils.equals(month, 2L)) {
        Boolean orResult_9 = false;

        Boolean andResult_17 = false;

        if (Utils.equals(Utils.mod(year.longValue(), 4L), 0L)) {
          if (!(Utils.equals(Utils.mod(year.longValue(), 100L), 0L))) {
            andResult_17 = true;
          }
        }

        if (andResult_17) {
          orResult_9 = true;
        } else {
          orResult_9 = Utils.equals(Utils.mod(year.longValue(), 400L), 0L);
        }

        if (orResult_9) {
          andResult_16 = true;
        }
      }

      if (andResult_16) {
        return 29L;

      } else {
        if (Utils.equals(month, 2L)) {
          return 28L;

        } else {
          return 30L;
        }
      }
    }
  }

  public static Number HoursToMinutes(final Number hour, final Number minutes) {

    return hour.longValue() * 60L + minutes.longValue();
  }

  public String toString() {

    return "Fashion_Show{"
        + "location := "
        + Utils.toString(location)
        + ", date := "
        + Utils.toString(date)
        + ", theme := "
        + Utils.toString(theme)
        + ", models := "
        + Utils.toString(models)
        + ", workshops := "
        + Utils.toString(workshops)
        + ", critics := "
        + Utils.toString(critics)
        + ", program := "
        + Utils.toString(program)
        + "}";
  }

  public static class Date implements Record {
    public Number year;
    public Number month;
    public Number day;
    public Number hour;
    public Number minute;

    public Date(
        final Number _year,
        final Number _month,
        final Number _day,
        final Number _hour,
        final Number _minute) {

      year = _year;
      month = _month;
      day = _day;
      hour = _hour;
      minute = _minute;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof Date)) {
        return false;
      }

      Date other = ((Date) obj);

      return (Utils.equals(year, other.year))
          && (Utils.equals(month, other.month))
          && (Utils.equals(day, other.day))
          && (Utils.equals(hour, other.hour))
          && (Utils.equals(minute, other.minute));
    }

    public int hashCode() {

      return Utils.hashCode(year, month, day, hour, minute);
    }

    public Date copy() {

      return new Date(year, month, day, hour, minute);
    }

    public String toString() {

      return "mk_Fashion_Show`Date" + Utils.formatFields(year, month, day, hour, minute);
    }
  }

  public static Boolean inv_Date(final Date recordPattern_1) {

    Boolean success_1 = true;
    Number y = null;
    Number m = null;
    Number d = null;
    Number h = null;
    Number min = null;
    y = recordPattern_1.year;
    m = recordPattern_1.month;
    d = recordPattern_1.day;
    h = recordPattern_1.hour;
    min = recordPattern_1.minute;

    if (!(success_1)) {
      throw new RuntimeException("Record pattern match failed");
    }

    Boolean andResult_18 = false;

    if (m.longValue() <= 12L) {
      Boolean andResult_19 = false;

      if (d.longValue() <= DaysOfMonth(m, y).longValue()) {
        Boolean andResult_20 = false;

        if (h.longValue() < 24L) {
          if (min.longValue() < 60L) {
            andResult_20 = true;
          }
        }

        if (andResult_20) {
          andResult_19 = true;
        }
      }

      if (andResult_19) {
        andResult_18 = true;
      }
    }

    return andResult_18;
  }

  public static class Critic implements Record {
    public String description;
    public Number rate;

    public Critic(final String _description, final Number _rate) {

      description = _description != null ? _description : null;
      rate = _rate;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof Critic)) {
        return false;
      }

      Critic other = ((Critic) obj);

      return (Utils.equals(description, other.description)) && (Utils.equals(rate, other.rate));
    }

    public int hashCode() {

      return Utils.hashCode(description, rate);
    }

    public Critic copy() {

      return new Critic(description, rate);
    }

    public String toString() {

      return "mk_Fashion_Show`Critic" + Utils.formatFields(description, rate);
    }
  }

  public static Boolean inv_Critic(final Critic v) {

    return v.rate.longValue() <= 5L;
  }
}
