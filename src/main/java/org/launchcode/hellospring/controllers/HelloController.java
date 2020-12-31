package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String name, @RequestParam String language) {
        //return "Hello, " + name + " " + language;
        return createMessage(name, language);
    }

    @GetMapping("greet")
    public String checkingPathParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("names")
    public String helloList(Model model) {
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("C#");
        languages.add(".Net");
        languages.add("Java Script");
        languages.add("Type Script");
        model.addAttribute("names", languages);
        return "hello-list";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
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
