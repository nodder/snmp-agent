package cdd.zte.nesimulator.agent;

import org.snmp4j.smi.AbstractVariable;
import org.snmp4j.smi.OID;

public class DefaultVariableResponser implements IVariableResponser
{

    @Override
    public AbstractVariable response(OID oid)
    {
        return null;
    }

}
