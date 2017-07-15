// import org.junit.*;
// import static org.junit.Assert.*;
//
// public class StylistTest {
//
//   @Test
//   public void Stylist_instantiatesCorrectly_true() {
//     Stylist testStylist = new Stylist("Stylist1");
//     assertEquals(true, testStylist instanceof Stylist);
//   }
//
//   @Test
//   public void getStylistName_stylistInstantiatesWithName_Stylist1() {
//     Stylist testStylist = new Stylist("Stylist1");
//     assertEquals("Stylist1", testStylist.getStylistName());
//   }
//
//   @Test
//   public void all_returnsAllInstancesOfStylists_true() {
//     Stylist firstStylist = new Stylist("Stylist1");
//     Stylist secondStylist = new Stylist("Stylist2");
//     assertEquals(true, Stylist.all().contains(firstStylist));
//     assertEquals(true, Stylist.all().contains(secondStylist));
//   }
// //to clear the stylist array list
//   @Test
//   public void clear_emptiesAllStylistsFromArrayList_0() {
//     Stylist testStylist = new Stylist("Stylist1");
//     Stylist.clear();
//     assertEquals(0, Stylist.all().size());
//   }
// //to add an ID to the stylist
//   @Test
//   public void getStylistId_stylistInstantiateWithAnId_1() {
//     Stylist.clear();
//     Stylist testStylist = new Stylist("Stylist1");
//     assertEquals(1, testStylist.getStylistId());
//   }
// //to find a stylist based an ID
//   @Test
//   public void find_returnsStylistWithSameId_secondStylist() {
//     Stylist.clear();
//     Stylist firstStylist = new Stylist("Stylist1");
//     Stylist secondStylist = new Stylist("Stylist2");
//     assertEquals(Stylist.find(secondStylist.getStylistId()), secondStylist);
//   }
// //to make sure the stylist instantiates with an empty clients list
//   @Test
//   public void getStylists_initiallyReturnsEmptyList_ArrayList() {
//     Stylist.clear();
//     Stylist testStylist = new Stylist("Stylist1");
//     assertEquals(0, testStylist.getClients().size());
//   }
// //to add a client to a stylist
//   @Test
//   public void addClient_addsClientToList_true() {
//     Stylist testStylist = new Stylist("Stylist1");
//     Client testClient = new Client("Client1");
//     testStylist.addClient(testClient);
//     assertTrue(testStylist.getClients().contains(testClient));
//   }
//
// }
