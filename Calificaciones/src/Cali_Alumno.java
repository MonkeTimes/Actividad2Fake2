//pongo el import del scanner para que despues me permita leer entradas por parte del usuario
import java.util.Scanner;
public class Cali_Alumno {
    //Declarando los atributos string y array que almacenaran valores
    public String nombre;
    //double para que pueda decirme decimales
    public double [] calificaciones;

    //constructor
    public Cali_Alumno(String nombre,double [] calificaciones ){
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }
    //Metodo para conseguir el promedio, se esta declarando una variable como cero en donde se le iran sumando las calificaciones y al final se divide por el largo del array que es 5
    public double GetPromedio (){
        double sumaCalis = 0;
        for (double calificacion : calificaciones){
            sumaCalis += calificacion;
        }
        //Divide la suma del array divido entre la longitud de la misma
        return sumaCalis/ calificaciones.length;
    }
    //Metodo para que segun el promedio determina una calificacion uso if para evaluar la calificacion
    public char GetCaliFinal (double promedio) {
        if (promedio <= 50) {
            return 'F';
        } else if (promedio <= 60) {
            return 'E';
        } else if (promedio <= 70) {
            return 'D';
        } else if (promedio <= 80) {
            return 'C';
        } else if (promedio <= 90) {
            return 'B';
        } else {
            return 'A';
        }
    }
    //Metodo que llama a los otros dos metodos para conseguir el promedio y la calificacion final, importante destacar que no regresa valores porque este metodo solo hace los calculos necesarios para almacenar los datos de promedio y calificacion final en las variables que despues se van a hacer llamar, por eso es void este metodo
    public void GetResultados (){
        System.out.println("Nombre del estudiante: " + nombre);
        //Este bucle se va a hacer a lo largo del array, el cual se define su tamaño en main
        for (int i =0;i< calificaciones.length;i++){
            //Esta parte es la que despliega las calificaciones ingresadas
            System.out.println("Calificación " + (i + 1) + ": " + calificaciones[i]);
        }
        //en esta parte se manda a llamar a los dos metodos de arriba para que calculen sus resultados
        double promedio = GetPromedio();
        char CaliFinal = GetCaliFinal(promedio);
        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación: " + CaliFinal);
    }
    //main en donde se le van a pedir los valores al usuario y se van a hacer los calculos
    public static void main(String[] args) {
        //Creo un objeto scanner que pida los datos del usuario
        Scanner Lectura = new Scanner(System.in);
        //Pido los datos al usuario
        System.out.print("Ingrese el nombre del alumno: ");
        //Importante poner nextLine porque sino marca error, lo intentaria leer como double
        String nombre = Lectura.nextLine();
        //Tengo que hacer un bucle en donde me pida las cinco calificaciones del alumno
        //Declaro la variable en el main y luego la inicializo
        double[] calificaciones= new double[5];
        //Empiezo bucle para que vaya almacenando los valores en un array
        for (int a = 0; a < calificaciones.length; a++) {
            //Creo una variable double para realizar la comparacion de la validacion mas adelante
            double cali;
            //Hago una validacion que en caso de que se escriba un numero mayor a 100 y lo pide de nuevo
            do {
                //Va a realizar estas acciones hasta que el valor ingresado sea igual o menor a 100
                System.out.print("Ingrese la calificacion " + (a + 1) + ": ");
                cali = Lectura.nextDouble();
                if (cali > 100) {
                    System.out.println("El número debe ser igual o menor a 100. Intente nuevamente.");
            } } while (cali> 100);
            //Una vez validado el numero ingresado se va a agregar el valor al array
            calificaciones [a] = cali;
            }
        //Declaro un objeto nuevo donde se va a llamar el metodo de conseguir los resultados
        Cali_Alumno caliAlumno = new Cali_Alumno(nombre, calificaciones);
        //Mando a llamar el metodo que despliega los resultados con las variables que se definieron en main
        caliAlumno.GetResultados();
    }
}
