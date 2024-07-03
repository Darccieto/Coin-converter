
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) throws IOException, InterruptedException {
            Convert coin = new Convert("",0,"","");
            boolean menuSelection = true;
            String menuText =
                    """
                            |****************************************|\s
                            Sea bienvenido/a al Conversor de Monedas\s
                            Ahora indique cual conversión desea realizar\s
                            1) Peso argentino =>> Bolivar boliviano\s
                            2) Bolivar boliviano =>> Real brasileño\s
                            3) Real brasileño =>> Peso chileno\s
                            4) Peso chileno =>> Peso colombiano\s
                            5) Peso colombiano =>> Dolar estadounidense\s
                            6) Salir\s
                            Elija una opción válida:""";
            String menuConverted =
                    "|***************************************| \n" +
                    "Elige la cantidad que deseas convertir:  ";
            Scanner optionChosen = new Scanner(System.in);
            System.out.println(menuText);


            String url_api = "https://v6.exchangerate-api.com/v6/c103d91d6b6fca086b44b0f6/pair/";
            while (menuSelection) {
                System.out.println(menuText);
                try {
                    int option = optionChosen.nextInt();
                    if (option == 6) {
                        menuSelection = false;
                        System.out.println("Gracias por usar el conversor de monedas. ¡Adiós!");
                        break;
                    }
                    Scanner intakeDigit = new Scanner(System.in);
                    int coinValue;
                    switch (option) {
                        case 1:
                            // Peso argentino =>> Bolivar boliviano
                            System.out.println(menuConverted);
                            coinValue = intakeDigit.nextInt();
                            coin.setCoin(coinValue);
                            coin.setUrl_api(url_api);
                            coin.setCountry1("ARS");
                            coin.setCountry2("BOB");
                            System.out.println(coin.conversion());
                            break;
                        case 2:
                            // Bolivar boliviano =>> Real brasileño
                            System.out.println(menuConverted);
                            coinValue = intakeDigit.nextInt();
                            coin.setCoin(coinValue);
                            coin.setUrl_api(url_api);
                            coin.setCountry1("BOB");
                            coin.setCountry2("BRL");
                            System.out.println(coin.conversion());
                            break;
                        case 3:
                            // Real brasileño =>> Peso chileno
                            System.out.println(menuConverted);
                            coinValue = intakeDigit.nextInt();
                            coin.setCoin(coinValue);
                            coin.setUrl_api(url_api);
                            coin.setCountry1("BRL");
                            coin.setCountry2("CLP");
                            System.out.println(coin.conversion());
                            break;
                        case 4:
                            // Peso chileno =>> Peso colombiano
                            System.out.println(menuConverted);
                            coinValue = intakeDigit.nextInt();
                            coin.setCoin(coinValue);
                            coin.setUrl_api(url_api);
                            coin.setCountry1("CLP");
                            coin.setCountry2("COP");
                            System.out.println(coin.conversion());
                            break;
                        case 5:
                            // Peso colombiano =>> Dolar estadounidense
                            System.out.println(menuConverted);
                            coinValue = intakeDigit.nextInt();
                            coin.setCoin(coinValue);
                            coin.setUrl_api(url_api);
                            coin.setCountry1("COP");
                            coin.setCountry2("USD");
                            System.out.println(coin.conversion());
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, elija una opción entre 1 y 5.");
                            break;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente un número entero.");
                    optionChosen.next(); // Limpiar el buffer del scanner
                }
            }
        }
    }