package com.interapi.app.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class HomeController {
    
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value="/admin/test",method = RequestMethod.POST)
    @ResponseBody
    public String adminTest1() {
        return "ROLE_USER";
    }
    
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping("/auto/test")
    @ResponseBody
    public String adminTest2() {
        return "ROLE_ADMIN";
    }
}
