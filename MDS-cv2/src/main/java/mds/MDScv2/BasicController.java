package mds.MDScv2;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basic")

public class BasicController {


    @GetMapping
    public String testBasic() {
        return "<b>Hello from test</b>";
    }

    @GetMapping("list")
    public List<String> testList() {
        return List.of("Hello", "world", "in", "JSON");
    }

    @GetMapping("param1")
    public String testParam1(@RequestParam(defaultValue = "user") String name) {
        return String.format("Hello %s", name);
    }

    @GetMapping("param2")
    public String testParam2(@RequestParam(defaultValue = "user", name = "jmeno") String name2) {
        return String.format("Hello %s", name2);
    }

    @GetMapping("param3")
    public String testParam3(@RequestParam List<String> id) {
        return "All IDs are: " + id;
    }


    @GetMapping("form")
    public String helloForm() {

        return "<html>" + "<body>" + "<form method='post' action='hello'>" + "<input type='text' name='name'/>" + "<input type='submit' value='Pozdrav'/>" + "</form>" + "</body>" + "</html>";
    }


    @RequestMapping(value = "hello", method = {RequestMethod.POST, RequestMethod.GET})
    public String helloTest(String name) {
        return String.format("Hello %s", name);
    }

}
