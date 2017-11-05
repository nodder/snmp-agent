package cdd.zte.nesimulator.agent;

import org.snmp4j.smi.OID;

import cdd.zte.nesimulator.common.MibDataTree;

public class GetNextOidResponser implements IGetNextOidResponser
{
    private MibDataTree mibDataTree;
    private OID lastOId = new OID("1.3.6.1.4.1.3902.9.99.999.9999");
    
    public GetNextOidResponser(MibDataTree mibDataTree)
    {
        this.mibDataTree = mibDataTree;
    }

    @Override
    public OID getResponseOid(OID oid)
    {
        mibDataTree.reset(); 
        
        while(mibDataTree.hasNext())
        {
            mibDataTree.next();
            if(SnmpAgentUtil.isSmaller(oid, mibDataTree.getCurrentOID()))
            {
                return mibDataTree.getCurrentOID();
            }
        }
        
        return lastOId;
        
        
//        if(oid.last() == 0)
//        {
//            oid.removeLast();
//            oid = oid.nextPeer().append(0);
//        }
//        else
//        {
//            oid = oid.append(0);
//        }
//        return oid;
    }
}
