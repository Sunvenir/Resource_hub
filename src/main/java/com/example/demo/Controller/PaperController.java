package com.example.demo.Controller;

import com.example.demo.entity.Paper;
import com.example.demo.entity.Paper_Expert;
import com.example.demo.mapper.PaperMapper;
import com.example.demo.result.PaperDeleteResult;
import com.example.demo.result.PaperInsertResult;
import com.example.demo.result.PaperSearchResult;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class PaperController {
    @Resource
    private PaperMapper paperMapper;
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
                                    @RequestParam("downloadLink") final String downloadLink,
                                    @RequestParam("source") final String source,
                                    @RequestParam("keywords") final String keywords,
                                    @RequestParam("paperType") final String paperType,
                                    @RequestParam("abstractStr") final String abstractStr,
                                    @RequestParam("author") final String author)
    {
        final Paper p = new Paper();
        final Paper_Expert pe = new Paper_Expert(p.getPaperID(),expertID);
        final PaperInsertResult pr = new PaperInsertResult(p.getPaperID());
        p.setPaperName(paperName);
        p.setDownloadLink(downloadLink);
        p.setSource(source);
        p.setKeywords(keywords);
        p.setPaperType(paperType);
        p.setAbstractStr(abstractStr);
        p.setAuthor(author);
        paperMapper.insert(p);
        return pr;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/DeletePaper")
    public PaperDeleteResult delete(final int expertID, final int paperID)
    {
        final PaperDeleteResult pr = new PaperDeleteResult();
        int code;
        if(paperMapper.search(paperID) == null)
            code = 200;
        else if (paperMapper.delete(expertID, paperID) != 0)
            code = 100;
        else
            code = 200;
        pr.setCode(code);
        return pr;
    }
}