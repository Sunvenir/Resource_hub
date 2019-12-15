package com.example.demo.Controller;

import javax.annotation.Resource;

import com.example.demo.entity.Expert;
import com.example.demo.entity.User;
import com.example.demo.mapper.ExpertMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.result.ExpertEditResult;
import com.example.demo.result.ExpertIDResult;
import com.example.demo.result.ExpertRecommendResult;

import com.example.demo.result.ExpertaddResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpertController {
    @Resource
    private ExpertMapper expertMapper;
    @Resource
    private UserMapper userMapper;

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/expert")
    public ExpertIDResult searchByID(@RequestParam("expertID") int expertID) {
        Expert expert = expertMapper.getExpertByID(expertID);
        return new ExpertIDResult(expert);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/homepage")
    public ExpertRecommendResult recommend() {
        Expert[] experts = expertMapper.expertRecommend();
        return new ExpertRecommendResult(experts);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/editexpert")
    public ExpertEditResult edit(@RequestParam(name = "expertID") int expertID,
            @RequestParam(name = "institution", required = false) String institution,
            @RequestParam(name = "brief", required = false) String brief,
            @RequestParam(name = "technicalField", required = false) String technicalField) {
        Expert expert = expertMapper.getExpertByID(expertID);
        if (expert == null) {
            return new ExpertEditResult(200);
        }
        if (institution != null) {
            expert.setInstitution(institution);
        }
        if (brief != null) {
            expert.setBrief(brief);
        }
        if (technicalField != null) {
            expert.settechnicalField(technicalField);
        }
        int code = expertMapper.editExpert(expert);
        return new ExpertEditResult(code);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/addexpert")
    public ExpertaddResult add(@RequestParam(name = "expertID") int expertID,
            @RequestParam(name = "useraccount") String UID) {
        // User user = new User();
        User user = userMapper.getByUId(UID);
        if (user == null) {
            return new ExpertaddResult(200);
        }
        user.setExpertID(expertID);
        user.setStatus("2");
        userMapper.editUser(user);
        Expert expert = new Expert();
        expert.setexpertID(expertID);
        expertMapper.insertExpert(expert);
        return new ExpertaddResult(100);
    }
}
