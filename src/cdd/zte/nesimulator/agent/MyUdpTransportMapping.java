package cdd.zte.nesimulator.agent;

import java.io.IOException;

import org.snmp4j.TransportStateReference;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.transport.DefaultUdpTransportMapping;

//此类暂未用到
public class MyUdpTransportMapping extends DefaultUdpTransportMapping
{

    public MyUdpTransportMapping(UdpAddress udpAddress) throws IOException
    {
        super(udpAddress);
    }
    
    @Override
    public void sendMessage(UdpAddress targetAddress, byte message[], TransportStateReference tmStateReference) throws IOException
    {
        super.sendMessage(targetAddress, message, tmStateReference);
        System.out.println("send OK");
    }

}
