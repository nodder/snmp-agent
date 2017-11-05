package cdd.zte.nesimulator.common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.snmp4j.smi.AbstractVariable;
import org.snmp4j.smi.OID;

import cdd.zte.nesimulator.agent.SnmpAgentUtil;

public class MibDataTree
{
    List<OID> oidList = new LinkedList<OID>();
    Map<OID, AbstractVariable> mibDataList = new HashMap<OID, AbstractVariable>();
    
    private int index = 0;
    
    public void insert(OID oid, AbstractVariable var)
    {
        insertToOidList(oid);
        insertToMibDataList(oid, var);
    }

    private void insertToMibDataList(OID oid, AbstractVariable var)
    {
        mibDataList.put(oid, var);
    }

    private void insertToOidList(OID oid)
    {
        for(int i = 0; i < oidList.size(); i++)
        {
            if(SnmpAgentUtil.isSmaller(oid, oidList.get(i)))
            {
                oidList.add(i, oid);
                return;
            }
        }
        
        oidList.add(oid);
    }
    
    public void reset()
    {
        index = -1;
    }
    
    public boolean hasNext()
    {
        return index + 1 < oidList.size();
    }
    
    public void next()
    {
        index++;
    }

    public OID getCurrentOID()
    {
        return oidList.get(index);
    }
    
    public AbstractVariable getVariable(OID oid)
    {
        return mibDataList.get(oid);
    }

}
