import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class SearchEngine implements URLHandler{
    ArrayList<String> str = new ArrayList<>();

    public String handleRequest(URI url) {
        String result = "";
        if(url.getPath().equals("/")){
           for(int i = 0; i < str.size(); i++){
           if(i > 0){
            result += " and ";
           }
           result = result + str.get(i);
        }
    }

        else if(url.getPath().equals("/add")){
            String[] parameters = url.getQuery().split("=");
            if(parameters[0].equals("s")){
                str.add(parameter[1]);
            }
        }
    }
}
