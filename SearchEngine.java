import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler{
    ArrayList<String> arr = new ArrayList<String>(10);
    ArrayList<String> alt = new ArrayList<String>(10);
    
    public String handleRequest(URI url) {
            if (url.getPath().equals("/")) {
                return "This is search engine.";
            }
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                arr.add(parameters[1]);
                String empty = "";
                for (String s: arr) {
                    empty = empty + " " + s;
                }
                return empty;
            }
            else if (url.getPath().contains("/search")) {
                String[] parameters = url.getQuery().split("=");
                
                for(int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).contains(parameters[1])) {
                        alt.add(arr.get(i));
                    }
                }
                String empty = "";
                for (String s: alt) {
                    empty = empty + " " + s;
                }
                return empty;
            }
        return "404 Not Found!";
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
