package com.menudesigner.sjbs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JIN Benli on 12/11/14.
 */
public class ResourcesService {

    private Map<String, List<String[]>> cssList;
    private Map<String, List<String[]>> jsList;

    public ResourcesService() {
        this.cssList = new HashMap<>();
        this.jsList = new HashMap<>();
        this.processData();
    }

    private void processData() {
        ArrayList<String[]> tmpList = new ArrayList<>();

        // index page css
        tmpList.add(new String[]{"../../css/bootstrap/bootstrap.css", "@{/css/bootstrap/bootstrap.css}"});
        tmpList.add(new String[]{"../../css/bootstrap/bootstrap-overrides.css", "@{/css/bootstrap/bootstrap-overrides" +
                ".css}"});
        tmpList.add(new String[]{"../../css/compiled/layout.css",
                "@{/css/compiled/layout.css}"});
        tmpList.add(new String[]{"../../css/compiled/elements.css",
                "@{/css/compiled/elements.css}"});
        tmpList.add(new String[]{"../../css/compiled/icons.css",
                "@{/css/compiled/icons.css}"});
        tmpList.add(new String[]{"../../css/lib/font-awesome.css",
                "@{/css/lib/font-awesome.css}"});
        cssList.put("index", tmpList);
        tmpList.clear();

        // index page js


    }
}
