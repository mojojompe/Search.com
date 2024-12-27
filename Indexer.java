//This builds an indented index mapping words to the pages where they appear

import java.util.*;

public class Indexer {
    private Map<String, List<String>> invertedIndex = new HashMap<>();
    
    // Index the crawled content
    public void index(Map<String, String> crawledData) {
        for (Map.Entry<String, String> entry : crawledData.entrySet()) {
            String url = entry.getKey();
            String content = entry.getValue();
            String[] words = content.split("\\W+");  // Tokenization
            
            for (String word : words) {
                word = word.toLowerCase();  // Convert to lowercase for consistency
                invertedIndex.putIfAbsent(word, new ArrayList<>());
                invertedIndex.get(word).add(url);  // Add URL to the index
            }
        }
    }
    
    public List<String> search(String query) {
        return invertedIndex.getOrDefault(query.toLowerCase(), new ArrayList<>());
    }
}
