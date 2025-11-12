import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Peticiones {

    private final HttpClient CLIENT = HttpClient.newHttpClient();

    public JsonDto Peticion(String moneda_uno,String moneda_dos,Integer monto){
        String URL = "https://v6.exchangerate-api.com/v6/e798294cd8b13eada3711c97/pair"
                +"/"+moneda_uno+"/"+moneda_dos+"/"+monto;

        HttpRequest request = HttpRequest.newBuilder()
                .header("accept","json/application")
                .uri(URI.create(URL))
                .GET()
                .build();
        return realizaPeticion(request);
    }

    public JsonDto realizaPeticion(HttpRequest request){
        Gson gson = new Gson();
        try{
            HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(),JsonDto.class);
        }catch (Exception e){
            System.out.println("Ocurrio un error al realizar la peticion");
        }
        return new JsonDto("","","",0);
    }
}
