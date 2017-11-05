package cdd.zte.nesimulator.agent;

import org.snmp4j.smi.AbstractVariable;
import org.snmp4j.smi.OID;

public interface IVariableResponser
{
    AbstractVariable response(OID oid);
}