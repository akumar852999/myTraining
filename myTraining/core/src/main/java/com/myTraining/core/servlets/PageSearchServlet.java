/*
package com.myTraining.core.servlets;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(service = Servlet.class)
@SlingServletPaths("/bin/training/searchpages")
public class PageSearchServlet extends SlingAllMethodsServlet {

    //private static final String SEARCH_PATH = "/content/myTraining/us";
//http://localhost:4502/bin/training/searchpages?searchText=when&searchPath=/content/myTraining/us
    //http://localhost:4502/bin/training/searchpages?searchText=you
    @Reference
    private QueryBuilder queryBuilder;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String searchText = request.getParameter("searchText");
        String searchPath = request.getParameter("searchPath");
        JSONObject jsonResponse = new JSONObject();
        JSONArray resultsArray = new JSONArray();

        if (StringUtils.isBlank(searchText)) {
            try {
                jsonResponse.put("error", "Missing searchText parameter");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            response.getWriter().write(jsonResponse.toString());
            return;
        }

        Session session = request.getResourceResolver().adaptTo(Session.class);
        if (session == null) {
            try {
                jsonResponse.put("error", "JCR Session is null");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            response.getWriter().write(jsonResponse.toString());
            return;
        }

        try {
            // Using Predicate Map to construct the query
            Map<String, String> predicateMap = new HashMap<>();
            predicateMap.put("path", searchPath); // Search under this path
            predicateMap.put("type", "cq:Page"); // Search only cq:Page nodes
            predicateMap.put("fulltext", searchText); // Full-text search across multiple fields
            predicateMap.put("fulltext.relPath", "jcr:content"); // Search within jcr:content
            predicateMap.put("p.limit", "-1"); // Fetch all results
            predicateMap.put("orderby", "@jcr:content/jcr:title"); // Sort by title

            Query query = queryBuilder.createQuery(PredicateGroup.create(predicateMap), session);
            SearchResult searchResult = query.getResult();

            List<Hit> hits = searchResult.getHits();
            for (Hit hit : hits) {
                JSONObject pageObject = new JSONObject();
                pageObject.put("path", hit.getPath());
                pageObject.put("title", hit.getProperties().get("jcr:title", ""));
                pageObject.put("description", hit.getProperties().get("jcr:description", ""));
                pageObject.put("tags", hit.getProperties().get("cq:tags", new String[]{}));

                resultsArray.put(pageObject);
            }

            jsonResponse.put("results", resultsArray);
        } catch (Exception e) {
            try {
                jsonResponse.put("error", "Search failed: " + e.getMessage());
            } catch (JSONException ex) {
                throw new RuntimeException(ex);
            }
        }

        response.getWriter().write(jsonResponse.toString());
    }
}
*/
