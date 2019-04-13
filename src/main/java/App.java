import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //port manager//
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

        //layout template as a string//
        String layout = "public/templates/layout.vtl";
        //css string//


        //routes//
        //index file//
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //hero form//

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("tasks", request.session().attribute("tasks"));
            model.put("template", "public/templates/form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //display file//

        get("/display", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //loading page//
        get("/loading", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/layout.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //collect inputs//
        post("/display", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            ArrayList<Hero> heroes = request.session().attribute("cause");
            if (heroes == null) {
                heroes = new ArrayList<Hero>();
                request.session().attribute("cause", heroes);
            }

            String superPower = request.queryParams("cause");
            Hero newHero = new Hero(superPower);
            heroes.add(newHero);

            model.put("template", "public/templates/loaded.vtl");
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }
}

