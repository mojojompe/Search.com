//This class links the crawler, indexer, and query processor and manages the search engine workflow.

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SimpleSearchEngine {

    private WebCrawler crawler;
    private Indexer indexer;
    private QueryProcessor queryProcessor;

    public void setup() {
        crawler = new WebCrawler();
        indexer = new Indexer();
        queryProcessor = new QueryProcessor(indexer);
        
        List<String> urls = Arrays.asList("https://example.com/page1", "https://example.com/page2");
        Map<String, String> crawledData = crawler.crawl(urls);
        indexer.index(crawledData);
    }

    public List<String> search(String query) {
        return queryProcessor.processQuery(query);
    }
}
