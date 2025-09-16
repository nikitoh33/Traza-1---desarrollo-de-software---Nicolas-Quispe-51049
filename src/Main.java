import org.example.repositorios.InMemoryRepository;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        //creo pais y creo provincia y se la agrego
        Pais Argentina = new Pais("Argentina");


        Provincia BuenosAires = new Provincia("Buenos Aires");
        Argentina.AgregarProvincia(BuenosAires);

        Provincia Cordoba = new Provincia("Cordoba");
        Argentina.AgregarProvincia(Cordoba);



        //creo localidad y se la agreguo a provincia
        Localidad Caba = new Localidad("Caba");
        BuenosAires.AgregarLocalidad(Caba);

        Localidad LaPlata = new Localidad("La plata");
        BuenosAires.AgregarLocalidad(LaPlata);

        Localidad CordobaCapital = new Localidad("Cordoba Capital");
        Cordoba.AgregarLocalidad(CordobaCapital);

        Localidad VillaCarlosPaz = new Localidad("Villa carlos paz");
        Cordoba.AgregarLocalidad(VillaCarlosPaz);



        //creo un domicilio y lo agrego a una localidad
        Domicilio domicilio1 = new Domicilio("Calle huamhuaca",9597, 5525);
        Caba.AgregarDomicilio(domicilio1);

        Domicilio domicilio2 = new Domicilio("Calle falsa",4953, 5550);
        Caba.AgregarDomicilio(domicilio2);

        Domicilio domicilio3 = new Domicilio("Calle verdadera",4543, 2550);
        CordobaCapital.AgregarDomicilio(domicilio3);

        Domicilio domicilio4 = new Domicilio("Calle tiraso",4354, 5555);
        VillaCarlosPaz.AgregarDomicilio(domicilio4);

        //consola
        System.out.println("\n----------Creacion de paises----------");
        System.out.println(Argentina.MostrarPais());

        System.out.println("\n----------Creacion de Provincias----------");
        System.out.println(BuenosAires.MostrarProvincia());
        System.out.println(Cordoba.MostrarProvincia());

        System.out.println("\n----------Creacion de Localidades----------");
        System.out.println(Caba.MostrarLocalidad());
        System.out.println(LaPlata.MostrarLocalidad());
        System.out.println(CordobaCapital.MostrarLocalidad());
        System.out.println(VillaCarlosPaz.MostrarLocalidad());

        System.out.println("\n----------Creacion de Sucursales----------");
        Sucursal sucursal1 = new Sucursal("Sucursal Nikitoh33", LocalTime.of(9,0), LocalTime.of(18,0) , true);

        sucursal1.MostrarSucursal();
        sucursal1.AsignarDomicilioConSucursal(domicilio2);
        sucursal1.MostrarDomicilioAsignado();





        System.out.println("\n----------Prueba con Repositorio----------");
        InMemoryRepository<Empresa> repoEmpresa = new InMemoryRepository<>();

        Empresa empresa1 = new Empresa("MiEmpresa", "SRL", 123456789, "logo.png");
        repoEmpresa.save(empresa1);

        // Mostrar todas las empresas en memoria
        System.out.println(repoEmpresa.findAll());

        // Buscar por ID
        repoEmpresa.findById(1L).ifPresent(e ->
                System.out.println("Empresa encontrada: " + e.MostrarEmpresa())
        );
    }
}