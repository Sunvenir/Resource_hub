package com.example.demo.Controller;

import javax.annotation.Resource;

import com.example.demo.entity.Expert;
import com.example.demo.mapper.ExpertMapper;
import com.example.demo.result.ExpertEditResult;
import com.example.demo.result.ExpertIDResult;
import com.example.demo.result.ExpertRecommendResult;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpertController {
    @Resource
    private ExpertMapper expertMapper;

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
            expert.setField(technicalField);
        }
        int code = expertMapper.editExpert(expert);
        return new ExpertEditResult(code);
    }
}