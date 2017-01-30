/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;

/**
 *
 * @author jaime
 */
public class Estacoes {
   //declaracoes das estacos
    String IP_POP = "192.168.2.2";
    String IP_TVU = "192.168.70.90";
    String IP_MUSEU = "192.168.2.4";
    String IP_ODONTO = "192.168.2.5";
    String IP_CEARAMIRIM = "192.168.2.6";
    String IP_VERACRUZ = "192.168.2.7";
    String IP_CCS = "192.168.2.8";
    String IP_DEGEPOL = "192.168.2.9";
    
    
    int Porta_POP = 161;
    int Porta_TVU = 162;
    int Porta_MUSEU = 163;
    int Porta_ODONTO = 164;
    int Porta_CEARAMIRIM = 165;
    int Porta_VERACRUZ = 166;
    int Porta_CCS = 166;
    int Porta_DEGEPOL = 166;
    
    String Descricao_POP = "Fica no datacenter central do PoP";
    String Descricao_TVU = "Predio B da TVU";
    String Descricao_MUSEU = "Sala de Maquinas";
    String Descricao_ODONTO = "Sala do Rack";
    String Descricao_CEARAMIRIM = "Dentro do servidor";
    String Descricao_VERACRUZ = "De baixo da antena";
    String Descricao_CCS = "Centro Ciencias Sociais";
    String Descricao_DEGEPOL = "Sala do delegado";
    
    String MAC_POP = "DE:AD:BE:EF:FE:ED";
    String MAC_TVU = "DE:AD:BE:EF:EE:DE";
    String MAC_MUSEU = "EE:AD:21:1F:33:55";
    String MAC_ODONTO = "EE:AD:21:1F:33:55";
    String MAC_CEARAMIRIM = "EE:AD:21:1F:33:55";
    String MAC_VERACRUZ = "EE:AD:21:1F:33:55";
    String MAC_CCS = "EE:AD:21:1F:33:55";
    String MAC_DEGEPOL = "EE:AD:21:1F:33:55";
    
    String MASCARA_POP = "255.255.255.0";
    String MASCARA_TVU = "255.255.255.0";
    String MASCARA_MUSEU = "255.255.255.0";
    String MASCARA_ODONTO = "255.255.255.0";
    String MASCARA_CEARAMIRIM = "255.255.255.0";
    String MASCARA_VERACRUZ = "255.255.255.0";
    String MASCARA_CCS = "255.255.255.0";
    String MASCARA_DEGEPOL = "255.255.255.0";
    
    String GATEWAY_POP = "192.168.2.100";
    String GATEWAY_TVU = "192.168.2.100";
    String GATEWAY_MUSEU = "192.168.2.100";
    String GATEWAY_ODONTO = "192.168.2.100";
    String GATEWAY_CEARAMIRIM = "192.168.2.100";
    String GATEWAY_VERACRUZ = "192.168.2.100";
    String GATEWAY_CCS = "192.168.2.100";
    String GATEWAY_DEGEPOL = "192.168.2.100";
   public Estacoes(){
       
   }
   
   public String getIPEstacao(int index){
       String Retorno="";
       switch (index){
           case 0:
               Retorno =  IP_POP;
               break;
           case 1:
               Retorno = IP_TVU;
               break;
           case 2:
               Retorno = IP_MUSEU;
               break;
           case 3:
               Retorno = IP_ODONTO;
               break;
           case 4:
               Retorno = IP_CEARAMIRIM;
               break;
           case 5:
               Retorno = IP_VERACRUZ;
               break;
           case 6:
               Retorno = IP_CCS;
               break;
           case 7:
               Retorno = IP_DEGEPOL;
               break;
           default:
               break;
       }
       return Retorno;
   }
   public int getPortaEstacao(int index){
       int Retorno=1;
       switch (index){
           case 0:
               Retorno =  Porta_POP;
               break;
           case 1:
               Retorno = Porta_TVU;
               break;
           case 2:
               Retorno = Porta_MUSEU;
               break;
           case 3:
               Retorno = Porta_ODONTO;
               break;
           case 4:
               Retorno = Porta_CEARAMIRIM;
               break;
           case 5:
               Retorno = Porta_VERACRUZ;
               break;
           case 6:
               Retorno = Porta_CCS;
               break;
           case 7:
               Retorno = Porta_DEGEPOL;
               break;
           default:
               break;
       }
       return Retorno;
   }
   
   public String getDescricaoEstacao(int index){
       String Retorno="";
       switch (index){
           case 0:
               Retorno =  Descricao_POP;
               break;
           case 1:
               Retorno = Descricao_TVU;
               break;
           case 2:
               Retorno = Descricao_MUSEU;
               break;
           case 3:
               Retorno = Descricao_ODONTO;
               break;
           case 4:
               Retorno = Descricao_CEARAMIRIM;
               break;
           case 5:
               Retorno = Descricao_VERACRUZ;
               break;
           case 6:
               Retorno = Descricao_CCS;
               break;
           case 7:
               Retorno = Descricao_DEGEPOL;
               break;
           default:
               break;
       }
       return Retorno;
   }
   public String getMACEstacao(int index){
       String Retorno="";
       switch (index){
           case 0:
               Retorno =  MAC_POP;
               break;
           case 1:
               Retorno = MAC_TVU;
               break;
           case 2:
               Retorno = MAC_MUSEU;
               break;
           case 3:
               Retorno = MAC_ODONTO;
               break;
           case 4:
               Retorno = MAC_CEARAMIRIM;
               break;
           case 5:
               Retorno = MAC_VERACRUZ;
               break;
           case 6:
               Retorno = MAC_CCS;
               break;
           case 7:
               Retorno = MAC_DEGEPOL;
               break;
           default:
               break;
       }
       return Retorno;
   }
   public String getMascaraEstacao(int index){
       String Retorno="";
       switch (index){
           case 0:
               Retorno = MASCARA_POP;
               break;
           case 1:
               Retorno = MASCARA_TVU;
               break;
           case 2:
               Retorno = MASCARA_MUSEU;
               break;
           case 3:
               Retorno = MASCARA_ODONTO;
               break;
           case 4:
               Retorno = MASCARA_CEARAMIRIM;
               break;
           case 5:
               Retorno = MASCARA_VERACRUZ;
               break;
           case 6:
               Retorno = MASCARA_CCS;
               break;
           case 7:
               Retorno = MASCARA_DEGEPOL;
               break;
           default:
               break;
       }
       return Retorno;
   }
   public String getGatewayEstacao(int index){
       String Retorno="";
       switch (index){
           case 0:
               Retorno = GATEWAY_POP;
               break;
           case 1:
               Retorno = GATEWAY_TVU;
               break;
           case 2:
               Retorno = GATEWAY_MUSEU;
               break;
           case 3:
               Retorno = GATEWAY_ODONTO;
               break;
           case 4:
               Retorno = GATEWAY_CEARAMIRIM;
               break;
           case 5:
               Retorno = GATEWAY_VERACRUZ;
               break;
           case 6:
               Retorno = GATEWAY_CCS;
               break;
           case 7:
               Retorno = GATEWAY_DEGEPOL;
               break;
           default:
               break;
       }
       return Retorno;
   }
   public String getNomeEstacao(String IP){
       String retorno = "Error";
       switch(IP){
           case "192.168.2.2":
               retorno = "Estação PoP-RN";
               break;
            case "192.168.70.90":
               retorno = "Estação TVU";
               break;
            case "192.168.2.4":
               retorno = "Estação Museu";
               break;
            case "192.168.2.5":
               retorno = "Estação Odonto";
               break;
            case "192.168.2.6":
               retorno = "Estação Ceará Mirirm";
               break;
            case "192.168.2.7":
               retorno = "Estação Vera Cruz";
               break;
            case "192.168.2.8":
               retorno = "Estação CCS";
               break;
            case "192.168.2.9":
               retorno = "Estação DEGIPOL";
               break;
            default:
                break;       
       }
       return retorno;
   }
}
