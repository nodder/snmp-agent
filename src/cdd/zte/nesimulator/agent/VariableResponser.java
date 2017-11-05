package cdd.zte.nesimulator.agent;

import org.snmp4j.smi.AbstractVariable;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;

import cdd.zte.nesimulator.common.MibDataTree;

public class VariableResponser implements IVariableResponser
{
    private OctetString notSupport = new OctetString("NOTSUPPORT");
    
    private MibDataTree mibDataTree;

    public VariableResponser(MibDataTree mibDataTree)
    {
        this.mibDataTree = mibDataTree;
    }

    @Override
    public AbstractVariable response(OID oid)
    {
        AbstractVariable var = mibDataTree.getVariable(oid);
        return null == var ? notSupport : var;
    }

}
