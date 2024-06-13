package org.example;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Map<Integer, MonedaArmada> historial = new HashMap<>();
        MonedaArmada monedaArmadita = new MonedaArmada();
        List<MonedaArmada> monedas = new ArrayList();
        LocalDateTime dateNow = LocalDateTime.now();
        int valorMenu = 0;
        Double cantidadIngresada = 0.0;

        while (true) {
            System.out.println("""
                    *** CONVERSOR DE MONEDAS ***
                    ****************************
                    Digite el número de la opción que
                    desea ejecutar.
                                        
                    1. Dólar >>> Peso Argentino
                    2. Peso Argentino >>> Dólar
                    3. Dólar >>> Real Brasileño
                    4. Real Brasileño >>> Dólar
                    5. Dólar >>> Peso Colombiano
                    6. Peso Colombiano >>> Dólar
                    7. Otro Tipo de cambio. 
                    8. Salir
                    """);

            if (lectura.hasNextInt()) {
                valorMenu = lectura.nextInt();
                if (valorMenu >= 1 && valorMenu <= 8) {
                    if (valorMenu == 8) {
                        System.out.println("Aplicacion finalizada");
                        break;
                    }
                } else {
                    System.out.println("Por favor, ingrese un número entero entre 1 y 8.");
                    lectura.next(); // Descarta la entrada no válida
                    continue;
                }
            } else {
                System.out.println("Por favor, ingrese un número entero válido.");
                lectura.next(); // Descarta la entrada no válida
                continue;
            }

            switch (valorMenu) {
                case 1:
                    cantidadIngresada = leerMonto(lectura);
                    convertirMoneda(cantidadIngresada, "USD", "ARS");
                    monedas.add(monedaArmadita);
                    break;
                case 2:
                    cantidadIngresada = leerMonto(lectura);
                    convertirMoneda(cantidadIngresada, "ARS", "USD");
                    monedaArmadita(dateNow,cantidadIngresada,"ARS", "USD");
                    monedas.add(monedaArmadita);
                    break;
                case 3:
                    cantidadIngresada = leerMonto(lectura);
                    convertirMoneda(cantidadIngresada, "USD", "BRL");
                    monedaArmadita(dateNow,cantidadIngresada,"USD", "BRL");
                    monedas.add(monedaArmadita);
                    break;
                case 4:
                    cantidadIngresada = leerMonto(lectura);
                    convertirMoneda(cantidadIngresada, "BRL", "USD");
                    monedaArmadita(dateNow,cantidadIngresada,"BRL", "USD");
                    monedas.add(monedaArmadita);
                    break;
                case 5:
                    cantidadIngresada = leerMonto(lectura);
                    convertirMoneda(cantidadIngresada, "USD", "COP");
                    monedaArmadita(dateNow,cantidadIngresada,"USD", "COP");
                    monedas.add(monedaArmadita);
                    break;
                case 6:
                    cantidadIngresada = leerMonto(lectura);
                    convertirMoneda(cantidadIngresada, "COP", "USD");
                    monedaArmadita(dateNow,cantidadIngresada,"COP", "USD");
                    monedas.add(monedaArmadita);
                    break;
                case 7:
                    cantidadIngresada = leerMonto(lectura);
                    System.out.println("Ingresa tu moneda base segun el ISO 4217");
                    String monedaBase = lectura.next();
                    System.out.println("Ingresa la divisa a usar ISO 4217");
                    String divisaABuscar = lectura.next();
                    convertirMoneda(cantidadIngresada, monedaBase, divisaABuscar);
                    monedaArmadita(dateNow,cantidadIngresada,monedaBase,divisaABuscar);
                    monedas.add(monedaArmadita);
                    break;
                default:
                    System.out.println("El valor ingresado es inválido");
                    break;
            }
            System.out.println(monedaArmadita);
        }
    }

    private static void monedaArmadita(LocalDateTime dateNow, Double cantidadIngresada, String monedaBase, String divisaABuscar ) {
    }


    public static double leerMonto(Scanner lectura) {
        double cantidadIngresada;
        while (true) {
            System.out.println("Ingrese el monto a convertir: ");
            if (lectura.hasNextDouble()) {
                cantidadIngresada = lectura.nextDouble();
                break;
            } else {
                System.out.println("Ingresa un monto válido");
                lectura.next(); // Descarta la entrada no válida
            }
        }
        return cantidadIngresada;
    }

    public static void convertirMoneda(
             Double cantidadIngresada,
            String monedaBase,
            String divisaABuscar
            ){

        ConsultaMoneda consultaM = new ConsultaMoneda();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        Moneda moneda = consultaM.buscaMoneda(divisaABuscar);
        Map<String, Double> conversionRates = moneda.conversion_rates();

        double tipoDeCambio = conversionRates.get(monedaBase);
        System.out.println("El tipo de cambio es: "+ tipoDeCambio);
        double valorFinal = cantidadIngresada / tipoDeCambio;
        System.out.println("El tipo de cambio de " + cantidadIngresada + " " + monedaBase + " convertido a la moneda " + divisaABuscar + " es de: " + valorFinal);
    }

    }




