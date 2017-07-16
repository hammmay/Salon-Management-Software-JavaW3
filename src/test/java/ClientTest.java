import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

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
    
//test to instantiate client object
  @Test
  public void Client_instantiatesCorrectly_true() {
    Client myClient = new Client("Client1");
    assertEquals(true, myClient instanceof Client);
  }
//test to get name of client object
  @Test
  public void Client_instantiatesWithName_Client1() {
    Client myClient = new Client("Client1");
    assertEquals("Client1", myClient.getName());
  }


//test to retrieve a list of all client names
  @Test
  public void all_returnsAllInstancesOfClient_true() {
    Client firstClient = new Client("Client1");
    firstClient.save();
    Client secondClient = new Client("Client2");
    secondClient.save();
    assertEquals(true, Client.all().get(0).equals(firstClient));
    assertEquals(true, Client.all().get(1).equals(secondClient));
  }

//to clear the team array list
  @Test
  public void clear_emptiesAllClientsFromArrayList_0() {
    Client testClient = new Client("Client1");
    assertEquals(0, Client.all().size());
  }

//to add an ID to the team
  @Test
  public void getId_clientInstantiateWithAnId() {
    Client myClient = new Client("Client1");
    myClient.save();
    assertTrue(myClient.getId() > 0);
  }

//to find a team based an ID
  @Test
  public void find_returnsClientWithSameId_secondClient() {
    Client firstClient = new Client("Client1");
    firstClient.save();
    Client secondClient = new Client("Client2");
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Client firstClient = new Client("Client1");
    Client secondClient = new Client("Client1");
    assertTrue(firstClient.equals(secondClient));
  }

  @Test
  public void save_returnsTrueIfNamesAretheSame() {
    Client myClient = new Client("Client1");
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
  }

  @Test
  public void save_assignsIdToObject() {
    Client myClient = new Client("Client1");
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(myClient.getId(), savedClient.getId());
  }
}
