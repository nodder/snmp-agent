package cdd.zte.nesimulator.agent;

import org.snmp4j.smi.AbstractVariable;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;

public class VariableResponseStub implements IVariableResponser
{
    @Override
    public AbstractVariable response(OID oid)
    {
        if(oid.toString().equals("1.3.6.1.2.1.1.1.0"))//sysDescr
        {
            return new OctetString("ZTE ACCESS NODE AGENT");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.4.18.0"))//sysObjectID
        {
            return new Integer32(24);
        }
        else if(oid.toString().equals("1.3.6.1.2.1.1.2.0"))//sysObjectID
        {
            return new OID(new int[]{1, 3, 6, 1, 4, 1, 3902, 1015, 9836, 1, 1, 1});
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4"))//sysObjectID
        {
            return new OID(new int[]{1, 3, 6, 1, 4, 1, 3902, 1015, 9836, 1, 1, 1});
        }
        
        
        
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.1"))
        {
            return new Integer32(291);
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.2"))
        {
            return new Integer32(2755);
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.3"))
        {
            return new Integer32(3155);
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.4"))
        {
            return new Integer32(2867);
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.5"))
        {
            return new Integer32(2067);
        }
        
        
        
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.1"))
        {
            return new Integer32(16);
        }
        
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.2"))
        {
            return new Integer32(48);
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.3"))
        {
            return new Integer32(16);
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.4"))
        {
            return new Integer32(24);
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.5"))
        {
            return new Integer32(2);
        }
        
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.1"))
        {
            return new Integer32(4);
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.2"))
        {
            return new Integer32(4);
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.3"))
        {
            return new Integer32(4);
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.4"))
        {
            return new Integer32(4);
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.5"))
        {
            return new Integer32(4);
        }
        
        
        else if(oid.toString().startsWith("1.3.6.1.4.1.3902.701.1.1.10.1.3.1.3.2"))
        {
            return new Integer32(7);
        }
        
        else if(oid.toString().startsWith("1.3.6.1.4.1.3902.1004.1.1.1.1.2"))
        {
            return new Integer32(0);
        }
        
        
        
        
        else if(oid.toString().startsWith("1.3.6.1.2.1.2.2.1.8") || oid.toString().startsWith("1.3.6.1.2.1.2.2.1.7"))
        {
            return new Integer32(2);
        }
        
        return new OctetString("NA");
    }

}
