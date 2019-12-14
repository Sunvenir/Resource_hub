package com.example.demo.Controller;

import com.example.demo.result.SearchResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class SearchController {

    static String searchword;
    static String searchkind;
    static 

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/search")
    public SearchResult search(@RequestParam(name = "searchword") String searchword,
                               @RequestParam(name = "searchkind") String searchkind,
                               @RequestParam(name = "pagenum") int pagenum,
                               @RequestParam(name = "expertID") int expertID){
        if(searchkind == "expert"){

        }

    }
}
