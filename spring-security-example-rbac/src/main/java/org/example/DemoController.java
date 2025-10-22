package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/admin/data")
    public String adminData() {
        return "Это данные для ADMIN";
    }

    @GetMapping("/user/data")
    public String userData() {
        return "Это данные для USER и ADMIN";
    }
}
