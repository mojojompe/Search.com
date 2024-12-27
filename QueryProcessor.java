//This processes user search query and retrieves the relevant results from this index.

import java.util.List;

public class QueryProcessor {
    private Indexer indexer;

    public QueryProcessor(Indexer indexer) {
        this.indexer = indexer;
    }

    public List<String> processQuery(String query) {
        return indexer.search(query);
    }
}
