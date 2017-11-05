package cdd.zte.nesimulator.agent;

import java.net.InetAddress;

import org.snmp4j.CommandResponder;
import org.snmp4j.CommandResponderEvent;
import org.snmp4j.MessageException;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.StatusInformation;
import org.snmp4j.smi.UdpAddress;

import cdd.zte.nesimulator.common.MibDataTree;

public class CommandResponseAgent implements CommandResponder
{
    private String ipAddress;
    private int port;

    private TransportMapping<UdpAddress> serverSocket;
    
    private PDUResponseAssembler pduResponse = null;
    private int responseDelay = 0;

    public CommandResponseAgent(String agentIPAddress, int lsnPort, MibDataTree mibDataTree)
    {
        this.ipAddress = agentIPAddress;
        this.port = lsnPort;
        pduResponse = new PDUResponseAssembler(mibDataTree);
    }
    
    public CommandResponseAgent(String agentIPAddress, int lsnPort, IVariableResponser variableResponse, IGetNextOidResponser getNextOidResponser)
    {
        this.ipAddress = agentIPAddress;
        this.port = lsnPort;
        pduResponse = new PDUResponseAssembler(variableResponse, getNextOidResponser);
    }
    
    public void setResoponseDelay(int responseDelay)
    {
        this.responseDelay  = responseDelay;
    }
    
    public void startListening() throws Exception
    {
        serverSocket = new MyUdpTransportMapping(new UdpAddress(InetAddress.getByName(ipAddress), port));
        Snmp mSNMP = new Snmp(serverSocket);
        mSNMP.addCommandResponder(this);

        serverSocket.listen();
    }
    
    @Override
    public void processPdu(CommandResponderEvent aEvent)
    {
        PDU vPDU = aEvent.getPDU();
//        System.out.println("SNMP Received:" + getDisplayPDUStr(vPDU));
        
        try
        {
            pduResponse.assembleResponsePDU(vPDU);
            
            sleep(responseDelay);
            
            returnResponsePDU(aEvent);
//            System.out.println("SNMP Response:" + getDisplayPDUStr(vPDU));
        }
        catch(MessageException vException)
        {
            System.out.println(vException);
        }
    }
    
    private void sleep(int responseDelay)
    {
        if(responseDelay > 0)
        {
            try
            {
                Thread.sleep(responseDelay);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    private static void returnResponsePDU(CommandResponderEvent aEvent) throws MessageException
    {
        aEvent.getMessageDispatcher().returnResponsePdu(aEvent.getMessageProcessingModel(),
        aEvent.getSecurityModel(), aEvent.getSecurityName(),
        aEvent.getSecurityLevel(), aEvent.getPDU(), aEvent.getMaxSizeResponsePDU(), aEvent.getStateReference(),
        new StatusInformation());
    }

//    private static String getPDUTypeStr(PDU vPDU)
//    {
//        switch(vPDU.getType())
//        {
//            case PDU.GET:
//                return "get";
//            case PDU.GETNEXT:
//                return "get-next";
//            case PDU.RESPONSE:
//                return "response";
//            case PDU.SET:
//                return "set";
//            case PDU.GETBULK:
//                return "get-bulk";
//            default:
//                return "Unknown type:" + vPDU.getType();
//        }
//    }

}
