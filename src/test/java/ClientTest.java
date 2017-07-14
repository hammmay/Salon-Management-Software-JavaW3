import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {
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
    Client secondClient = new Client("Client2");
    assertEquals(true, Client.all().contains(firstClient));
    assertEquals(true, Client.all().contains(secondClient));
  }
//to clear the team array list
  @Test
  public void clear_emptiesAllClientsFromArrayList_0() {
    Client testClient = new Client("Client1");
    Client.clear();
    assertEquals(0, Client.all().size());
  }
//to add an ID to the team
  @Test
  public void getClientId_clientInstantiateWithAnId_1() {
    Client.clear();
    Client testClient = new Client("Client1");
    assertEquals(1, testClient.getClientId());
  }
//to find a team based an ID
  @Test
  public void find_returnsClientWithSameId_secondClient() {
    Client.clear();
    Client firstClient = new Client("Client1");
    Client secondClient = new Client("Client2");
    assertEquals(Client.find(secondClient.getClientId()), secondClient);
  }

}
