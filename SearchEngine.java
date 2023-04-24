import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class SearchEngine implements URLHandler{
    ArrayList<String> result = new ArrayList<>();

    public String handleRequest(URI url) {
        String str = "";
        if(url.getPath().equals("/")){
           for(int i = 0; i < result.size(); i++){
            str = str + result.get(i) + "\n";
            System.out.println(str);
        }
        return(str);
    }

        else if(url.getPath().equals("/add-message")){
            String[] parameters = url.getQuery().split("=");
            if(parameters[0].equals("s")){
                result.add(parameters[1]);
                return("String " + parameters[1] + " added to server.");
            }
        }
        return("404 not found");
    }
}

class StringServer{ 
    public static void main(String[] args) throws IOException{
        if(args.length == 0){
            System.out.println("Missing port Number! Please try any number between 1024 and 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new SearchEngine());

    }
}
