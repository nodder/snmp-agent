package cdd.zte.nesimulator.agent;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;

import org.snmp4j.smi.OID;

public class SnmpAgentUtil
{
    private SnmpAgentUtil()
    {
    }
    
    public static boolean isSmaller(OID first, OID second)
    {
        int result = first.leftMostCompare(Math.min(first.size(), second.size()), second);
        
        if(result == 0)
        {
            return first.size() - second.size() < 0;
        }
        
        return result < 0;
    }
    
    public static String getLocalhostIp()
    {
        return getIpv4List().get(0);
    }
    
    private static ArrayList<String> getIpv4List()
    {
        ArrayList<String> arrayList = new ArrayList<String>();
        try
        {
            Enumeration<?> enumNetworkInterface = NetworkInterface.getNetworkInterfaces();
            if(enumNetworkInterface != null)
            {
                while(enumNetworkInterface.hasMoreElements())
                {
                    NetworkInterface ni = (NetworkInterface)enumNetworkInterface.nextElement();
                    Enumeration<?> cardipenum = ni.getInetAddresses();
                    while(cardipenum.hasMoreElements())
                    {
                        InetAddress inetAddress = (InetAddress)cardipenum.nextElement();
                        if(inetAddress instanceof Inet4Address&&!inetAddress.getHostAddress().equalsIgnoreCase("127.0.0.1") 
                                        && !inetAddress.getHostAddress().equalsIgnoreCase("0.0.0.0"))
                        {
                            String ip = inetAddress.getHostAddress();
                            arrayList.add(ip);
                        }
                    }
                }
            }
        }
        catch(SocketException e)
        {
            e.printStackTrace();
        }
        return arrayList;
    }
}
