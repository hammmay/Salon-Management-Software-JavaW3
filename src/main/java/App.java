// //front-end user interface routes
// import java.util.Map;
// import java.util.HashMap;
// import java.util.ArrayList;
// import spark.ModelAndView;
// import spark.template.velocity.VelocityTemplateEngine;
// import static spark.Spark.*;
//
// public class App {
//   public static void main(String[] args) {
//     staticFileLocation("/public");
//     String layout = "templates/layout.vtl";
//
//     get("/", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("stylists", request.session().attribute("stylists"));
//       model.put("template", "templates/index.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/stylist-added-success", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       ArrayList<Stylist> stylists = request.session().attribute("stylists");
//       if (stylists == null) {
//         stylists = new ArrayList<Stylist>();
//         request.session().attribute("stylists", stylists);
//       }
//       String stylistDescription = request.queryParams("stylistDescription");
//       Stylist newStylist = new Stylist(stylistDescription);
//       stylists.add(newStylist);
//       model.put("template", "templates/stylistAddSuccess.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/:id", (request, response) -> {
//       HashMap<String, Object> model = new HashMap<String, Object>();
//       Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
//       model.put("stylist", stylist);
//       model.put("clients", stylist.getClients());
//       model.put("template", "templates/stylistClientList.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/clientSuccessPage", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       Stylist stylist = Stylist.find(Integer.parseInt(request.queryParams("stylistId")));
//       String clientDescription = request.queryParams("clientDescription");
//       Client newClient = new Client(clientDescription);
//       stylist.addClient(newClient);
//       model.put("template", "templates/clientAddSuccess.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//
//   }
// }
