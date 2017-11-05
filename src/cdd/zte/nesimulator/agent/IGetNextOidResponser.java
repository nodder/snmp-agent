package cdd.zte.nesimulator.agent;

import org.snmp4j.smi.OID;

public interface IGetNextOidResponser
{
    OID getResponseOid(OID oid);

}
