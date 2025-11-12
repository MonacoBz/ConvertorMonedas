import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gui {

    private final Scanner SC = new Scanner(System.in);

    private final Peticiones API = new Peticiones();

    public void gui(){
        System.out.println("--------------------Bienvenido a Monaco Convertor--------------------");
        bienvenida();
    }
    private void bienvenida(){
        String menu = """
                Elije la conversion que quieres hacer:
                1)-> ARS(Peso argentino)
                2)-> BOB(Boliviano boliviano)
                3)-> BRL(Real brasileño)
                4)-> CLP(Peso chileno)
                5)-> COP(Peso colombiano)
                6)-> USD(Dólar estadounidense)
                7)-> Salir ;:D
                """;
        System.out.println(menu);
        int opcion = SC.nextInt();
        SC.nextLine();
        List<String> opciones = new ArrayList<>();
        while(opcion<=6){
            switch (opcion){
                case 1-> opciones.add("ARS");
                case 2-> opciones.add("BOB");
                case 3-> opciones.add("BRL");
                case 4-> opciones.add("CLP");
                case 5-> opciones.add("COP");
                case 6-> opciones.add("USD");
            }
            if(opciones.size() == 2){
                llamaApi(opciones);
                System.out.println("Elije la moneda");
            }else System.out.println("Elije la moneda a transformar");
            opcion = SC.nextInt();
            SC.nextLine();
        }
        System.out.println("Hasta luego!!!!");
    }

    private void llamaApi(List<String> opciones){
        System.out.println("¿De cuanto será el monto?");
        int monto = SC.nextInt();
        SC.nextLine();
        String moneda_uno = opciones.get(0);
        String moneda_dos = opciones.get(1);
        opciones.clear();
        if(monto <= 0 ){
            System.out.println("Error el monto no puede ser negativo o igual a 0");
            return;
        }
        muestraResultado(API.Peticion(moneda_uno, moneda_dos, monto),monto);

    }
    private void muestraResultado(JsonDto json,int monto){
        System.out.println("Moneda Inicial: "+json.monedaOriginal());
        System.out.println("Monto: "+monto);
        System.out.println("Moneda Transformar: "+json.monedaObjetivo());
        System.out.println("Monto equivalente: "+json.resultado());

    }

}
