//This Servlet handles the HTTP request, processes the search query using your Java-based search engine, and returns the results.

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SearchServlet extends HttpServlet {

    private SimpleSearchEngine searchEngine;

    @Override
    public void init() throws ServletException {
        searchEngine = new SimpleSearchEngine(); 
        searchEngine.setup(); 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");  
        List<String> results = searchEngine.search(query);  

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Search Results for '" + query + "':</h1>");

        if (!results.isEmpty()) {
            for (String result : results) {
                out.println("<p>" + result + "</p>");
            }
        } else {
            out.println("<p>No results found.</p>");
        }

        out.println("<a href='Index.html'>Back to search</a>");
        out.println("</body></html>");
    }
}

