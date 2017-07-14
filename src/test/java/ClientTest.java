import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Before
    public void setUp() {
      DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/stylist_client_test", null, null);
    }

    @After
    public void tearDown() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "DELETE FROM clients *;";
        con.createQuery(sql).executeUpdate();
      }
    }

//test to instantiate client object
  @Test
  public void Client_instantiatesCorrectly_true() {
    Client myClient = new Client("Client");
    assertEquals(true, myClient instanceof Client);
  }
//test to get name of client object
  @Test
  public void getClientName_instantiatesWithClientName_Client() {
    Client myClient = new Client("Client");
    assertEquals("Client", myClient.getClientName());
  }
//test to retrieve a list of all client names
  @Test
  public void all_returnsAllInstancesOfClient_true() {
    Client firstClient = new Client("Client1");
    firstClient.save();
    Client secondClient = new Client("Client2");
    secondClient.save();
    assertEquals(true, Client.all().get(0).contains(firstClient));
    assertEquals(true, Client.all().get(1).contains(secondClient));
  }
//to clear the team array list
  @Test
  public void clear_emptiesAllClientsFromArrayList_0() {
    Client testClient = new Client("Client1");
    assertEquals(0, Client.all().size());
  }
//to add an ID to the team
  @Test
  public void getClientId_clientInstantiateWithAnId() {
    Client testClient = new Client("Client1");
    myClient.save();
    assertTrue(myClient.getClientId() > 0);
  }
//to find a team based an ID
  @Test
  public void find_returnsClientWithSameId_secondClient() {
    Client firstClient = new Client("Client1");
    firstClient.save();
    Client secondClient = new Client("Client2");
    secondClient.save();
    assertEquals(Client.find(secondClient.getClientId()), secondClient);
  }

  @Test
  public void equals_returnsTrueIfClientNamesAretheSame() {
    Client firstClient = new Task("Cindy");
    Client secondClient = new Task("Cindy");
    assertTrue(firstClient.equals(secondClient));
  }

  @Test
  public void save_returnsTrueIfClientNamesAretheSame() {
    Client myClient = new Client("Cindy");
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
  }

  @Test
  public void save_assignsIdToObject() {
    Client myClient = new Client("Cindy");
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(myClient.getId(), savedClient.getId());
  }
}
