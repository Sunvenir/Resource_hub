package com.example.demo.Controller;

import javax.annotation.Resource;

import com.example.demo.entity.Paper;
import com.example.demo.entity.Paper_Expert;
import com.example.demo.mapper.ExpertMapper;
import com.example.demo.mapper.PaperMapper;
import com.example.demo.result.PaperDeleteResult;
import com.example.demo.result.PaperInsertResult;
import com.example.demo.result.PaperSearchResult;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaperController {
    @Resource
    private PaperMapper paperMapper;

    @Resource
    private ExpertMapper expertMapper;

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/SearchPaper")
    public PaperSearchResult search(@RequestParam("paperID") final int paperID)
    {
        final Paper p = paperMapper.search(paperID);
        final PaperSearchResult pr = new PaperSearchResult(p);
        return pr;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/InsertPaper")
    public PaperInsertResult insert(@RequestParam("expertID") final int expertID,
                                    @RequestParam("paperName") final String paperName,
                                    @RequestParam("date") final String date,
                                    @RequestParam("source") final String source,
                                    @RequestParam("keywords") final String keywords,
                                    @RequestParam("paperType") final String paperType,
                                    @RequestParam("abstract") final String _abstract,
                                    @RequestParam("author") final String author)
    {
        final Paper p = new Paper();
        final Paper_Expert pe = new Paper_Expert(p.getPaperID(),expertID);
        final PaperInsertResult pr = new PaperInsertResult(p.getPaperID());
        p.setPaperName(paperName);
        p.setDate(date);
        p.setSource(source);
        p.setKeywords(keywords);
        p.setPaperType(paperType);
        p.setAbstract(_abstract);
        p.setAuthor(author);
        paperMapper.insertPaper(p);
        paperMapper.insertPaper_expert(pe);
        return pr;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/DeletePaper")
    public PaperDeleteResult delete(final int expertID, final int paperID)
    {
        final PaperDeleteResult pr = new PaperDeleteResult();
        int code;
        if(paperMapper.search(paperID) == null)
            code = 100;
        else if (paperMapper.delete(expertID, paperID) != 0)
            code = 200;
        else
            code = 500;
        pr.setCode(code);
        return pr;
    }
}