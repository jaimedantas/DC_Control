/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.Target;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
  

/**
 *
 * @author jaime
 */
public class SNMP_server {
    public String senha = "pop-rn";
    
    public SNMP_server(){      
    }
    public static String SNMP_GET(String ipAddress, int port, String strOID, String community) {
        String strResponse = "";
        ResponseEvent response;
        Snmp snmp;
        try {
            OctetString community1 = new OctetString(community);
            String host = ipAddress + "/" + port;
            Address tHost = new UdpAddress(host);
            TransportMapping transport = new DefaultUdpTransportMapping();
            transport.listen();
            CommunityTarget comtarget = new CommunityTarget();
            comtarget.setCommunity(community1);
            comtarget.setVersion(SnmpConstants.version1);
            comtarget.setAddress(tHost);
            comtarget.setRetries(2);
            comtarget.setTimeout(5000);
            PDU pdu = new PDU();
            pdu.add(new VariableBinding(new OID(strOID)));
            pdu.setType(PDU.GET);
            snmp = new Snmp(transport);
            response = snmp.get(pdu, comtarget);
            if (response != null) {
                if (response.getResponse().getErrorStatusText().equalsIgnoreCase("Success")) {
                    PDU pduresponse = response.getResponse();
                    strResponse = pduresponse.getVariableBindings().firstElement().toString();
                    if (strResponse.contains("=")) {
                        String strNewResponse[] = null;
                        int len = strResponse.indexOf("=");
                        strNewResponse = strResponse.split("=");
                        //System.out.println("The SNMP response to the OID requested is : " + strNewResponse[1]); //FOR DEBUG
                        strResponse = strNewResponse[1].trim();
                    }
                }
            } else {
                System.out.println("TimeOut occured");
            }
            snmp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strResponse;
    }


    
    
    
    
    
    public String getLastBoot(String IP, int Porta) throws IOException {
        String lastBoot = SNMP_GET(IP, Porta, ".1.3.6.1.2.1.1.3.0", senha);
        return lastBoot;
    }
    
    public String getName(String IP, int Porta) throws IOException {
        String name = SNMP_GET(IP, Porta,".1.3.6.1.2.1.1.5.0",senha);
        return name;
    }
    
    public String getTemp1(String IP, int Porta) throws IOException {
        String temp1 = SNMP_GET(IP, Porta,".1.3.6.1.2.1.6540.1.0",senha);
        return temp1;
    }

    public String getTemp2(String IP, int Porta) throws IOException {;
        String getTemp2 = SNMP_GET(IP, Porta,".1.3.6.1.2.1.6540.2.0", senha);
        //snmp.close();
        return getTemp2;
    }
    public String OpenDoor(String IP, int Porta) throws IOException {
        String openDoor = SNMP_GET(IP, Porta,".1.3.6.1.2.1.3716.1.0", senha);
        return openDoor;
    }
    public String CloseDoor(String IP, int Porta) throws IOException {
        String closeDoor = SNMP_GET(IP, Porta,".1.3.6.1.2.1.3716.0.0", senha);
        return closeDoor;
    }
    public String DesligaAr(String IP, int Porta) throws IOException {
        String desligaAr = SNMP_GET(IP, Porta,".1.3.6.1.2.1.9862.0.0",senha);
        return desligaAr;
    }
    public String LigaAr(String IP, int Porta) throws IOException {
        String ligaAr = SNMP_GET(IP, Porta,".1.3.6.1.2.1.9862.1.0", senha);
        return ligaAr;
    }
    public String getHumidade(String IP, int Porta) throws IOException {
        String humidade = SNMP_GET(IP, Porta,".1.3.6.1.2.1.6540.3.0", senha);
        return humidade;
    }
    public String getSaidas(String IP, int Porta) throws IOException {
        String humidade = SNMP_GET(IP, Porta,".1.3.6.1.2.1.6540.4.0", senha);
        return humidade;
    }
 
}
