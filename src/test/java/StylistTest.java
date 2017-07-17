import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteClientQuery = "DELETE FROM clients *;";
      String deleteStylistQuery = "DELETE FROM stylists *;";
      con.createQuery(deleteClientQuery).executeUpdate();
      con.createQuery(deleteStylistQuery).executeUpdate();
    }
  }

  @Test
  public void Stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Stylist1");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getStylistName_stylistInstantiatesWithName_Stylist1() {
    Stylist testStylist = new Stylist("Stylist1");
    assertEquals("Stylist1", testStylist.getStylistName());
  }

  @Test
  public void all_returnsAllInstancesOfStylists_true() {
    Stylist firstStylist = new Stylist("Stylist1");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Stylist2");
    secondStylist.save();
    assertEquals(true, Stylist.all().get(0).equals(firstStylist));
    assertEquals(true, Stylist.all().get(1).equals(secondStylist));
  }
//to clear the stylist array list
  @Test
  public void clear_emptiesAllStylistsFromArrayList_0() {
    Stylist testStylist = new Stylist("Stylist1");
    assertEquals(0, Stylist.all().size());
  }
//to add an ID to the stylist
  @Test
  public void getId_stylistInstantiateWithAnId_1() {
    Stylist testStylist = new Stylist("Stylist1");
    testStylist.save();
    assertTrue(testStylist.getId() > 0);
  }
//to find a stylist based an ID
  @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    Stylist firstStylist = new Stylist("Stylist1");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Stylist2");
    secondStylist.save();
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }
//to make sure the stylist instantiates with an empty clients list
  @Test
  public void getStylists_initiallyReturnsEmptyList_ArrayList() {
    Stylist testStylist = new Stylist("Stylist1");
    assertEquals(0, testStylist.getClients().size());
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist firstStylist = new Stylist("Stylist1");
    Stylist secondStylist = new Stylist("Stylist1");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Stylist myStylist = new Stylist("Stylist1");
    myStylist.save();
    assertTrue(Stylist.all().get(0).equals(myStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    Stylist myStylist = new Stylist("Stylist1");
    myStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(myStylist.getId(), savedStylist.getId());
  }

  @Test
  public void save_savesStylistIdIntoDB_true() {
    Stylist myStylist = new Stylist("Stylist1");
    myStylist.save();
    Client myClient = new Client("Client1", myStylist.getId());
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertEquals(savedClient.getStylistId(), myStylist.getId());
  }
}
