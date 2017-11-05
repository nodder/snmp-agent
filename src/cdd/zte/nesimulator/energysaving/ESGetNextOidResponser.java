package cdd.zte.nesimulator.energysaving;

import org.snmp4j.smi.OID;

import cdd.zte.nesimulator.agent.IGetNextOidResponser;

public class ESGetNextOidResponser implements IGetNextOidResponser
{

    @Override
    public OID getResponseOid(OID oid)
    {
        if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.1");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.1"))
        {                              
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.2");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.2"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.3");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.3"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.4");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.4"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.5");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.4.1.1.5"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.5.1.1.1");
        }
        
        
        
        
        
        
        
        
        
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.1");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.1"))
        {                              
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.2");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.2"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.3");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.3"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.4");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.4"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.5");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.6.1.1.5"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.7.1.1.1");
        }
        
        
        
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.1");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.1"))
        {                              
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.2");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.2"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.3");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.3"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.4");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.4"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.5");
        }
        else if(oid.toString().equals("1.3.6.1.4.1.3902.1004.3.1.1.6.1.9.1.1.5"))
        {
            return new OID("1.3.6.1.4.1.3902.1004.3.1.1.6.1.10.1.1.1");
        }

        return null;
    }

}
