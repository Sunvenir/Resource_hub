package com.example.demo.Controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.result.RegisterResult;
import com.example.demo.result.loginresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.util.Map;

@RestController
public class UserController {
    @Resource
    private UserMapper userMapper;

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/register")
    public RegisterResult register(@RequestParam("useraccount") String useraccount,
                                   @RequestParam("password") String password){
        User user = new User();
        user.setUID(useraccount);
        user.setPassword(password);
        user.setStatus("1");
        //System.out.println(useraccount + password);
        int count = 0;
        int code = 0;
        if(userMapper.getByUId(useraccount) != null){
            code = 200;
        }
        else{
            userMapper.insert(user);
            code = 100;
        }

        //System.out.println(count);
        RegisterResult registerResult = new RegisterResult(code);
        return  registerResult;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/login")
    public loginresult login(@RequestParam("useraccount") String useraccount,
                             @RequestParam("password") String password){
        User user = new User();
        int code;
        String useroot;
        int expertID;
        user = userMapper.getByUId(useraccount);
        if(user == null){
            code = 200;
            loginresult loginresult = new loginresult(code,null,-1);
            return loginresult;
        }
        if(password.equals(user.getPassword())){
            code = 100;
            useroot = user.getStatus();
            expertID = user.getExpertID();
            loginresult loginresult = new loginresult(code,useroot,expertID);
            return  loginresult;
        }
        else {
            code = 300;
            loginresult loginresult = new loginresult(code,null,-1);
            return loginresult;
        }
    }

}
