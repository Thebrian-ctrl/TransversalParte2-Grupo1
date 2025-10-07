/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Materia;
import Modelo.alumno;
import Percistencia.MateriaData;
import Percistencia.alumnoData;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author paula
 */
public class Universidad_Gp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
     
//    alumno brayan = new alumno(42278291, "Arce", "Brayan", LocalDate.of(1999, 12, 16), 1);
//    
//    alumnoData alu = new alumnoData();
//    
//    alu.guardarAlumno(brayan);
//    
//    
//    alumno jonatan = new alumno(39092552, "Aguero", "Jonatan", LocalDate.of(1995, 9, 10), 1);
//    
//    alu.guardarAlumno(jonatan);
//  
//         
//    alumno eduardo = new alumno(24681663, "Giménez", "Héctor", LocalDate.of(1975, 11, 19), 1);
//    
//    alu.guardarAlumno(eduardo);
//    
//    alumno santiago = new alumno(44283749, "Gomez", "Santiago", LocalDate.of(2001, 05, 12), 1);
//    
//    alu.guardarAlumno(santiago);
//    
//    alumno martin = new alumno(41574821, "Leiza", "Martin", LocalDate.of(1995, 10, 5), 1);
//    
//    alu.guardarAlumno(martin);
//    
//    alumno paula = new alumno(42516816, "Giménez", "Paula", LocalDate.of(1997, 06, 15), 1);
//    
//    alu.guardarAlumno(paula);
//    
//    alumno milagros = new alumno(44285298, "Alfaro", "Milagros", LocalDate.of(2000, 07, 18), 1);
//    
//    alu.guardarAlumno(milagros);
    
    
     //-----PRUEBO  BUSCAR UN ALUMNO POR DNI 
    
//     alumno encontrado= alu.buscarAlumnonDni(42278291);
//     
//     if(encontrado !=null){
//         System.out.println("Alumno encontrado: "+encontrado);
//     }
     
     
     
     
     //-------- LISTAR ALUMNOS ACTIVOS------
     
//        List<alumno> listaActivos = alu.listarAlumnosActivos();
//        
//        System.out.println("------- alumnos activos--------");
//        
//        
//        
//        for (alumno a: listaActivos){
//            System.out.println(a);
//        }
        
        //--------------Prueba de dar baja a alumno---------------
//        
//        alu.darBaja(2);
//                
//         List<alumno> listaActivos2 = alu.listarAlumnosActivos();
//        
//        System.out.println("------- alumnos activos--------");
//        
//        
//        
//        for (alumno a: listaActivos2){
//            System.out.println(a);
//        }
        
        //----------Prueba de elimar alumno de la tabla-----------

//        System.out.println("------------");
//  alu.eliminarAumno(5);
//  
//  listaActivos = alu.listarAlumnosActivos();
//  
//        for (alumno a : listaActivos) {
//            System.out.println(a);
//        }
        //----------Prueba de materia-----------
    MateriaData mate = new MateriaData();
          //-------creamos la materia1------
          
          //Materia mate1 = new Materia(1,"Matematica",2025,1);
          
          //--------Prueva de guradado de la materia----------.
          
          //mate.guardarMateria(mate1);
          
          //-----creamos la materia2-----
          
          //Materia mate2 = new Materia("laboratorio",2025,1);
          
          //-----Prueva de guradado de la materia.-------
          
          //mate.guardarMateria(mate2);
          
          //-----provamos el dar de baja a la materia------
          
          //mate.darBajaMateria(1);
          
          //-----provamos el dar de alta a la materia-------
          
          //mate.darAltaMateria(1);
          
          //-----------modificamos la fecha de la materia--------- 
          
          //Materia buscada = mate.buscarMateria(1);
          
          //buscada.setAnio(2015);
          
          //mate.actualizarMateria(buscada);
          
          //---------Prueva de listar materia----------
          
          //List<Materia> lista = mate.listarMateriaActivos();
          //for(Materia materia: lista){
          //    System.out.println(materia);
          //}
          
          //-------Eliminamos la materia-----------
          
          mate.eliminarMateria(1);
          
          //---------Voolvemos a probar listar materia----------
          
          List<Materia> lista2 = mate.listarMateriaActivos();
          for(Materia materia: lista2){
              System.out.println(materia);
          }
    }
    
}
