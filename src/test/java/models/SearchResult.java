package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult<T> {
    private Integer count;
    private String next;
    private String previous;
    private List<T> results;

    public Integer getCount() { return count; }
    public String getNext() { return next; }
    public String getPrevious() { return previous; }
    public List<T> getResults() { return results; }
}
