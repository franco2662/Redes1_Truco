/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrucoPaquete;

public class Mazo {
private String[] pinta={"oros","bastos","copas","espadas"};
   
public Mazo(){
    
    Carta[] Cartas = new Carta[48];
     
    for( int i=1;i<=4;i++){
        for( int j=1;j<=48;j++){
          Cartas[j]= new Carta(j,pinta[i]);  
          
            
        } 
    }
    
    
    }
}
