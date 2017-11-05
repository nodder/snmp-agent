package cdd.zte.nesimulator.agent;

import org.snmp4j.smi.OID;

public class DefaultGetNextOidResponser implements IGetNextOidResponser
{

    @Override
    public OID getResponseOid(OID oid)
    {
        if(oid.last() == 0)
        {
            oid.removeLast();
            oid = oid.nextPeer().append(0);
        }
        else
        {
            oid = oid.append(0);
        }
        return oid;
    }
}
