package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;

@Controller
@RequestMapping("test")
public class HelloController {

    // Handles request at path /hello
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String name, @RequestParam String language) {
        //return "Hello, " + name + " " + language;
        return createMessage(name, language);
    }

    @GetMapping("hello/{name}/{id}")
    @ResponseBody
    public String checkingPathParam(@PathVariable String name, String id) {
        return "Hello, " + name + "! " + id;
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = 'hello'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<select name = 'language' >" +
                        "<option value = 'french'> French </option> " +
                        "<option value = 'english' selected> English </option>" +
                        "<option value = 'hindi'> Hindi </option>" +
                        "<option value = 'spanish'> Spanish </option>" +
                        "<option value = 'telugu'> Telugu </option>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

    public static String createMessage(String name, String language) {
        String greeting = "";
        if (language.equalsIgnoreCase("french")) {
            greeting = "Bonjour, ";
        } else if (language.equalsIgnoreCase("english")) {
            greeting = "Hello, ";
        }
        if (language.equalsIgnoreCase("hindi")) {
            greeting = "Namaste, ";
        }
        if (language.equalsIgnoreCase("spanish")) {
            greeting = "Hola, ";
        }
        if (language.equalsIgnoreCase("telugu")) {
            greeting = "Namaskaram, ";
        }

        return
                "<html>" +
                        "<body>" +
                        "<p>" + greeting + name + "</p>" +
                        "</body>" +
                        "</html>";

    }


}
