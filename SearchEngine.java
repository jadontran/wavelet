import java.net.URI;
import java.util.ArrayList;

public class SearchEngine {
    ArrayList<String> arr = new ArrayList<String>(10);
    ArrayList<String> alt = new ArrayList<String>(10);

    public ArrayList<String> handleRequest(URI url) {
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                arr.add(parameters[1]);
                return arr;
            }
            else if (url.getPath().contains("/search")) {
                String[] parameters = url.getQuery().split("=");
                
                for(int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).contains(parameters[1])) {
                        alt.add(parameters[1]);
                        return alt;
                    }
                }
            }
            return arr;
        }
    }

