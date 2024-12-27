//This is a simple crawler that fetches and stores example content for the URLs.

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class WebCrawler {
    public Map<String, String> crawl(List<String> urls) {
        Map<String, String> crawledData = new HashMap<>();
        
        // For simplicity, instead of fetching real web pages, we use hardcoded content
        for (String url : urls) {
            String content = "Content from " + url; 
            crawledData.put(url, content);  // Store URL and its content
        }
        
        return crawledData;
    }
    
}
