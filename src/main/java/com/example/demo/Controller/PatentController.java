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
                                   @RequestParam(value="patentName",required = false) final String patentName,
                                 @RequestParam(value="applicationDate",required = false) final String applicationDate,
                                 @RequestParam(value="authorizationDate",required = false) final String authorizationDate,
                                 @RequestParam(value="patentNumber",required = false) final String patentNumber,
                                 @RequestParam(value="brief",required = false) final String brief,
                                 @RequestParam(value="patentType",required = false) final String patentType,
                                 @RequestParam(value="patentAuthor",required = false) final String patentAuthor)
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
