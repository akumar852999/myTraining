/*
package com.myTraining.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.jcr.query.Row;
import javax.jcr.query.RowIterator;
import java.io.IOException;
import java.util.Optional;

@Component(service = javax.servlet.Servlet.class)
@SlingServletPaths("/bin/training/sqlindexingsearch")
public class PageSQLindexSearchServlet extends SlingSafeMethodsServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageSQLindexSearchServlet.class);
    private static final String SEARCH_PATH = "/content/myTraining/us";

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String searchText = Optional.ofNullable(request.getParameter("searchText")).orElse("").trim();
        LOGGER.info("🔍 Searching for pages with text: {}", searchText);

        JSONArray resultsArray = new JSONArray();
        JSONObject jsonResponse = new JSONObject();

        if (searchText.isEmpty()) {
            try {
                jsonResponse.put("error", "Missing searchText parameter");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            response.getWriter().write(jsonResponse.toString());
            return;
        }

        // Get JCR Session
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
            QueryManager queryManager = session.getWorkspace().getQueryManager();

            // SQL2 Query to Fetch Pages by Title or Description (Using Custom Oak Index)
            String sql2Query = "SELECT * FROM [cq:Page] AS page WHERE ISDESCENDANTNODE(page, '" + SEARCH_PATH + "') "
                    + "AND (LOWER(page.[jcr:content/jcr:title]) LIKE '%" + searchText.toLowerCase() + "%' "
                    + "OR LOWER(page.[jcr:content/jcr:description]) LIKE '%" + searchText.toLowerCase() + "%') "
                    + "OPTION (INDEX NAME myTrainingLucene)"; //  Uses Custom Oak Index

            LOGGER.info(" Executing SQL2 Query: {}", sql2Query);

            Query query = queryManager.createQuery(sql2Query, Query.JCR_SQL2);
            QueryResult result = query.execute();
            RowIterator rowIterator = result.getRows();

            LOGGER.info(" Query Executed Successfully. Fetching results...");

            // Loop through query results (Using Traditional While Loop)
            while (rowIterator.hasNext()) {
                Row row = rowIterator.nextRow();
                Node node = row.getNode();

                if (node != null) {
                    JSONObject pageObject = new JSONObject();

                    // Retrieve Node Properties Safely
                    pageObject.put("path", node.getPath());
                    pageObject.put("title", node.hasNode("jcr:content") && node.getNode("jcr:content").hasProperty("jcr:title")
                            ? node.getNode("jcr:content").getProperty("jcr:title").getString() : "");

                    pageObject.put("description", node.hasNode("jcr:content") && node.getNode("jcr:content").hasProperty("jcr:description")
                            ? node.getNode("jcr:content").getProperty("jcr:description").getString() : "");

                    resultsArray.put(pageObject);
                }
            }

            jsonResponse.put("results", resultsArray);
        } catch (Exception e) {
            try {
                jsonResponse.put("error", "Search failed: " + e.getMessage());
            } catch (JSONException ex) {
                throw new RuntimeException(ex);
            }
            LOGGER.error(" Error executing query: {}", e.getMessage());
        }

        response.getWriter().write(jsonResponse.toString());
    }
}
*/
