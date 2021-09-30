package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {

////    @GetMapping("hello")
////    @ResponseBody
////    public String hello() {
////        return "Hello, Spring!";
////    }
//
//    // lives at /hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }
//
//    // Handles request of the form /hello?name=LaunchCode
//    // lives at /hello/hello
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }
//
//    // Handles requests of the form /hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }


    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                    "<option value='french'>French</option>" +
                    "<option value='spanish'>Spanish</option>" +
                    "<option value='hebrew'>Hebrew</option>" +
                    "<option value='japanese'>Japanese</option>" +
                    "<option value='english'>English</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);

    }

    public static String createMessage(String name, String language) {
        String greeting = "";

        if (language.equals("french")) {
            greeting = "Bonjour ";
        } else if (language.equals("spanish")) {
            greeting = "Hola ";
        } else if (language.equals("hebrew")) {
            greeting = "Shalom ";
        } else if (language.equals("japanese")) {
            greeting = "Kon'nichiwa ";
        } else if (language.equals("english")){
            greeting = "Hello ";
        }

        return greeting + " " + name;
    }
}
