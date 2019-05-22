package com.coursework.be.controller;

import com.coursework.be.entity.Admin;
import com.coursework.be.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Admin addAdmin(@RequestBody Admin admin){
        if(admin != null) {
            return adminService.createAdmin(admin);
        }else return null;
    }


}
