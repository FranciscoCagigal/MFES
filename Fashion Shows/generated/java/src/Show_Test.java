
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Show_Test extends MyTestCase {
  public void TestShow() {

    Fashion_Show show = new Fashion_Show("Porto", "Primavera", 2017L, 12L, 31L, 9L, 0L);
    Fashion_Designer designer1 = new Fashion_Designer("Andre Correia", 54L);
    Fashion_Designer designer2 = new Fashion_Designer("Francisco Louça", 64L);
    Fashion_Designer designer3 = new Fashion_Designer("Afonso Martins", 58L);
    Fashion_Designer designer4 = new Fashion_Designer("Carlos Silva", 62L);
    Fashion_Designer designer5 = new Fashion_Designer("Mario Andrade", 59L);
    Model model1 = new Model("Pedro Faria", 67L, quotes.MasculinoQuote.getInstance(), 1.78, 74.32);
    Model model2 = new Model("Sara Sampaio", 24L, quotes.FemininoQuote.getInstance(), 1.82, 53.24);
    Model model3 =
        new Model("Daniela Hanganu", 26L, quotes.FemininoQuote.getInstance(), 1.79, 52.78);
    Model model4 = new Model("Dariia", 23L, quotes.FemininoQuote.getInstance(), 1.85, 56.91);
    WorkShop workshop =
        new WorkShop(
            "Como costurar um botão?",
            new Fashion_Show.Date(2017L, 12L, 31L, 20L, 0L),
            new Fashion_Show.Date(2017L, 12L, 31L, 21L, 0L),
            20L,
            "João Botões Correia",
            "A7");
    WorkShop workshop2 =
        new WorkShop(
            "Como se maquilhar?",
            new Fashion_Show.Date(2017L, 12L, 31L, 19L, 0L),
            new Fashion_Show.Date(2017L, 12L, 31L, 20L, 0L),
            20L,
            "João Botões Correia",
            "A9");
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
    Reviewer reviewer =
        new Reviewer(
            "Ana Bacalhau",
            39L,
            quotes.FemininoQuote.getInstance(),
            "anabacalhau@gmail.com",
            "password_anabacalhau");
    Reviewer reviewer2 =
        new Reviewer(
            "Ana Moura",
            45L,
            quotes.FemininoQuote.getInstance(),
            "anamoura@gmail.com",
            "password_anamoura");
    Fashion_Show.Date data1 = new Fashion_Show.Date(2017L, 12L, 31L, 10L, 59L);
    Fashion_Show.Date data2 = new Fashion_Show.Date(2017L, 12L, 31L, 11L, 59L);
    Fashion_Show.Date data3 = new Fashion_Show.Date(2017L, 12L, 31L, 12L, 30L);
    Fashion_Show.Date data4 = new Fashion_Show.Date(2017L, 12L, 31L, 14L, 0L);
    Fashion_Show.Date data5 = new Fashion_Show.Date(2017L, 12L, 31L, 15L, 30L);
    Fashion_Show.Date data6 = new Fashion_Show.Date(2017L, 12L, 31L, 17L, 0L);
    Fashion_Show.Date data7 = new Fashion_Show.Date(2017L, 12L, 31L, 18L, 30L);
    Fashion_Show.Critic critic =
        new Fashion_Show.Critic("Melhor festival de moda que participei!", 5L);
    Fashion_Show.Critic critic2 = new Fashion_Show.Critic("Evento aquém das expectativas.", 2L);
    assertEqual(show.getTheme(), "Primavera");
    assertEqual(show.getLocation(), "Porto");
    assertEqual(show.getDate(), new Fashion_Show.Date(2017L, 12L, 31L, 9L, 0L));
    assertEqual(show.getModels(), MapUtil.map());
    assertEqual(show.getProgramShow(), MapUtil.map());
    assertEqual(show.getDesigners(), SetUtil.set());
    show.addDesignerToShow(designer1);
    assertEqual(show.getDesigners(), SetUtil.set(designer1));
    show.addDesignerToShow(designer2);
    assertEqual(show.getDesigners(), SetUtil.set(designer1, designer2));
    show.rmvDesignerToShow(designer1);
    assertEqual(show.getDesigners(), SetUtil.set(designer2));
    show.rmvDesignerToShow(designer2);
    assertEqual(show.getDesigners(), SetUtil.set());
    show.addDesignerToProgramShow(Utils.copy(data1), designer1);
    assertEqual(show.getProgramShow(), MapUtil.map(new Maplet(Utils.copy(data1), designer1)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 1L);
    show.addDesignerToProgramShow(Utils.copy(data2), designer2);
    assertEqual(
        show.getProgramShow(),
        MapUtil.map(
            new Maplet(Utils.copy(data1), designer1), new Maplet(Utils.copy(data2), designer2)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 2L);
    show.addDesignerToShow(designer1);
    show.addDesignerToShow(designer2);
    assertEqual(show.getModelsOfDesigner(designer1), SeqUtil.seq());
    assertEqual(show.getModelsOfDesigner(designer2), SeqUtil.seq());
    assertEqual(
        show.getModels(),
        MapUtil.map(new Maplet(designer1, SeqUtil.seq()), new Maplet(designer2, SeqUtil.seq())));
    assertEqual(show.getModelsInRunwayOfDesigner(designer1), SeqUtil.seq());
    show.addModelToShow(designer1, model1);
    show.addModelToShow(designer1, model2);
    show.addModelToShow(designer1, model3);
    show.addModelToShow(designer2, model4);
    assertEqual(
        ((Model_In_Runway) Utils.get(show.getModelsInRunwayOfDesigner(designer1), 1L)).getModel(),
        model1);
    assertEqual(
        ((Model_In_Runway) Utils.get(show.getModelsInRunwayOfDesigner(designer1), 2L)).getModel(),
        model2);
    assertEqual(
        ((Model_In_Runway) Utils.get(show.getModelsInRunwayOfDesigner(designer1), 3L)).getModel(),
        model3);
    assertEqual(
        ((Model_In_Runway) Utils.get(show.getModelsInRunwayOfDesigner(designer2), 1L)).getModel(),
        model4);
    assertEqual(show.getModelsOfDesigner(designer1), SeqUtil.seq(model1, model2, model3));
    assertEqual(show.getModelsOfDesigner(designer2), SeqUtil.seq(model4));
    show.removeModelToShow(designer1, model2);
    assertEqual(show.getModelsOfDesigner(designer1), SeqUtil.seq(model1, model3));
    show.removeDesignerFromProgramShow(Utils.copy(data2));
    assertEqual(show.getProgramShow(), MapUtil.map(new Maplet(Utils.copy(data1), designer1)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 1L);
    show.removeDesignerFromProgramShow(Utils.copy(data1));
    assertEqual(show.getProgramShow(), MapUtil.map());
    assertEqual(show.getWorkShops(), SetUtil.set());
    show.addWorkShopToShow(workshop);
    assertEqual(show.getWorkShops(), SetUtil.set(workshop));
    show.addWorkShopToShow(workshop2);
    assertEqual(show.getWorkShops(), SetUtil.set(workshop, workshop2));
    assertEqual(workshop.getUsers(), SetUtil.set());
    show.workShopBooking(workshop, user1);
    assertEqual(workshop.getUsers(), SetUtil.set(user1));
    show.workShopBooking(workshop, user2);
    assertEqual(workshop.getUsers(), SetUtil.set(user1, user2));
    show.rmvWorkShopToShow(workshop);
    assertEqual(show.getWorkShops(), SetUtil.set(workshop2));
    show.rmvWorkShopToShow(workshop2);
    assertEqual(show.getWorkShops(), SetUtil.set());
    show.addDesignerToProgramShow(Utils.copy(data1), designer1);
    assertEqual(show.getProgramShow(), MapUtil.map(new Maplet(Utils.copy(data1), designer1)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 1L);
    show.addDesignerToProgramShow(Utils.copy(data2), designer2);
    assertEqual(
        show.getProgramShow(),
        MapUtil.map(
            new Maplet(Utils.copy(data1), designer1), new Maplet(Utils.copy(data2), designer2)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 2L);
    show.addDesignerToProgramShow(Utils.copy(data3), designer3);
    assertEqual(
        show.getProgramShow(),
        MapUtil.map(
            new Maplet(Utils.copy(data1), designer1),
            new Maplet(Utils.copy(data2), designer2),
            new Maplet(Utils.copy(data3), designer3)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 3L);
    show.addDesignerToProgramShow(Utils.copy(data4), designer4);
    assertEqual(
        show.getProgramShow(),
        MapUtil.map(
            new Maplet(Utils.copy(data1), designer1),
            new Maplet(Utils.copy(data2), designer2),
            new Maplet(Utils.copy(data3), designer3),
            new Maplet(Utils.copy(data4), designer4)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 4L);
    assertEqual(
        show.checkProgramDisponibility(new Fashion_Show.Date(2017L, 12L, 31L, 13L, 59L)), false);
    assertEqual(show.getDesignerByDate(Utils.copy(data1)), designer1);
    assertEqual(show.getDesignerByDate(Utils.copy(data2)), designer2);
    assertEqual(show.getDesignerByDate(Utils.copy(data3)), designer3);
    assertEqual(show.getDesignerByDate(Utils.copy(data4)), designer4);
    show.addDesignerToProgramShow(Utils.copy(data5), designer1);
    assertEqual(
        show.getProgramShow(),
        MapUtil.map(
            new Maplet(Utils.copy(data1), designer1),
            new Maplet(Utils.copy(data2), designer2),
            new Maplet(Utils.copy(data3), designer3),
            new Maplet(Utils.copy(data4), designer4),
            new Maplet(Utils.copy(data5), designer1)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 5L);
    show.addDesignerToProgramShow(Utils.copy(data6), designer2);
    assertEqual(
        show.getProgramShow(),
        MapUtil.map(
            new Maplet(Utils.copy(data1), designer1),
            new Maplet(Utils.copy(data2), designer2),
            new Maplet(Utils.copy(data3), designer3),
            new Maplet(Utils.copy(data4), designer4),
            new Maplet(Utils.copy(data5), designer1),
            new Maplet(Utils.copy(data6), designer2)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 6L);
    show.addDesignerToProgramShow(Utils.copy(data7), designer1);
    assertEqual(
        show.getProgramShow(),
        MapUtil.map(
            new Maplet(Utils.copy(data1), designer1),
            new Maplet(Utils.copy(data2), designer2),
            new Maplet(Utils.copy(data3), designer3),
            new Maplet(Utils.copy(data4), designer4),
            new Maplet(Utils.copy(data5), designer1),
            new Maplet(Utils.copy(data6), designer2),
            new Maplet(Utils.copy(data7), designer1)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 7L);
    assertEqual(
        show.getListOfDatesByDesigner(designer1),
        SetUtil.set(Utils.copy(data1), Utils.copy(data5), Utils.copy(data7)));
    assertEqual(
        show.getListOfDatesByDesigner(designer2),
        SetUtil.set(Utils.copy(data2), Utils.copy(data6)));
    show.removeDesignerFromProgramShow(Utils.copy(data7));
    assertEqual(
        show.getProgramShow(),
        MapUtil.map(
            new Maplet(Utils.copy(data1), designer1),
            new Maplet(Utils.copy(data2), designer2),
            new Maplet(Utils.copy(data3), designer3),
            new Maplet(Utils.copy(data4), designer4),
            new Maplet(Utils.copy(data5), designer1),
            new Maplet(Utils.copy(data6), designer2)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 6L);
    show.removeDesignerFromProgramShow(Utils.copy(data6));
    assertEqual(
        show.getProgramShow(),
        MapUtil.map(
            new Maplet(Utils.copy(data1), designer1),
            new Maplet(Utils.copy(data2), designer2),
            new Maplet(Utils.copy(data3), designer3),
            new Maplet(Utils.copy(data4), designer4),
            new Maplet(Utils.copy(data5), designer1)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 5L);
    show.removeDesignerFromProgramShow(Utils.copy(data5));
    assertEqual(
        show.getProgramShow(),
        MapUtil.map(
            new Maplet(Utils.copy(data1), designer1),
            new Maplet(Utils.copy(data2), designer2),
            new Maplet(Utils.copy(data3), designer3),
            new Maplet(Utils.copy(data4), designer4)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 4L);
    show.removeDesignerFromProgramShow(Utils.copy(data4));
    assertEqual(
        show.getProgramShow(),
        MapUtil.map(
            new Maplet(Utils.copy(data1), designer1),
            new Maplet(Utils.copy(data2), designer2),
            new Maplet(Utils.copy(data3), designer3)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 3L);
    show.removeDesignerFromProgramShow(Utils.copy(data3));
    assertEqual(
        show.getProgramShow(),
        MapUtil.map(
            new Maplet(Utils.copy(data1), designer1), new Maplet(Utils.copy(data2), designer2)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 2L);
    show.removeDesignerFromProgramShow(Utils.copy(data2));
    assertEqual(show.getProgramShow(), MapUtil.map(new Maplet(Utils.copy(data1), designer1)));
    assertEqual(MapUtil.dom(show.getProgramShow()).size(), 1L);
    show.removeDesignerFromProgramShow(Utils.copy(data1));
    assertEqual(show.getProgramShow(), MapUtil.map());
    assertEqual(show.getCritics(), MapUtil.map());
    assertEqual(show.getAvgReview(), 0L);
    show.addCritic(reviewer, Utils.copy(critic));
    assertEqual(show.getCritics(), MapUtil.map(new Maplet(reviewer, Utils.copy(critic))));
    assertEqual(show.getAvgReview(), 5L);
    show.addCritic(reviewer2, Utils.copy(critic2));
    assertEqual(
        show.getCritics(),
        MapUtil.map(
            new Maplet(reviewer, Utils.copy(critic)), new Maplet(reviewer2, Utils.copy(critic2))));
    assertEqual(show.getAvgReview(), 3.5);
    show.rmvCritic(reviewer);
    assertEqual(show.getCritics(), MapUtil.map(new Maplet(reviewer2, Utils.copy(critic2))));
    assertEqual(show.getAvgReview(), 2L);
    show.rmvCritic(reviewer2);
    assertEqual(show.getCritics(), MapUtil.map());
    assertEqual(show.getAvgReview(), 0L);
    assertEqual(show.DaysOfMonth(1L, 2000L), 31L);
    assertEqual(show.DaysOfMonth(4L, 2000L), 30L);
    assertEqual(show.DaysOfMonth(2L, 2000L), 29L);
    assertEqual(show.DaysOfMonth(2L, 1900L), 28L);
    return;
  }

  public static void main_test() {

    IO.print("TestShow -> ");
    new Show_Test().TestShow();
    IO.println("Passed");
  }

  public Show_Test() {}

  public String toString() {

    return "Show_Test{}";
  }
}
