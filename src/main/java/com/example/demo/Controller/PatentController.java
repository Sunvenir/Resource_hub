package com.example.demo.Controller;

import com.example.demo.entity.Patent;
import com.example.demo.entity.Patent_Expert;
import com.example.demo.mapper.PatentMapper;
import com.example.demo.result.PatentDeleteResult;
import com.example.demo.result.PatentInsertResult;
import com.example.demo.result.PatentSearchResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PatentController {
    @Resource
    private PatentMapper patentMapper;
    @CrossOrigin(origins = "*")
    @RequestMapping("/api/SearchPatent")
    public PatentSearchResult search(@RequestParam("patentID") int patentID)
    {
        Patent p = patentMapper.search(patentID);
        PatentSearchResult pr = new PatentSearchResult(p);
        return pr;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/InsertPatent")
    public PatentInsertResult insert(@RequestParam("expertID") final int expertID,
                                   @RequestParam("patentName") final String patentName,
                                 @RequestParam("applicationDate") final String applicationDate,
                                 @RequestParam("authorizationDate") final String authorizationDate,
                                 @RequestParam("patentNumber") final String patentNumber,
                                 @RequestParam("brief") final String brief,
                                 @RequestParam("patentType") final String patentType,
                                 @RequestParam("patentAuthor") final String patentAuthor)
    {
        Patent p = new Patent();
        p.setPatentID(patentMapper.searchmax() + 1);
        Patent_Expert pe = new Patent_Expert(p.getPatentID(), expertID);
        p.setPatentName(patentName);
        p.setApplicationDate(applicationDate);
        p.setAuthorizationDate(authorizationDate);
        p.setPatentNumber(patentNumber);
        p.setBrief(brief);
        p.setPatentType(patentType);
        p.setPatentAuthor(patentAuthor);
        patentMapper.insertPatent(p);
        patentMapper.insertPatent_expert(pe);
        PatentInsertResult pr = new PatentInsertResult(p.getPatentID());
        return pr;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/DeletePatent")
    public PatentDeleteResult delete(int expertID, int patentID)
    {
        PatentDeleteResult pr = new PatentDeleteResult();
        int code;
        if(patentMapper.search(patentID) == null)
            code = 200;
        else if(patentMapper.delete(expertID, patentID)!=0)
            code = 100;
        else
            code = 200;
        pr.setCode(code);
        return pr;
    }
}
