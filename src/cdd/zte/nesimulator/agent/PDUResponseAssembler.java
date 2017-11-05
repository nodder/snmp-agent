package cdd.zte.nesimulator.agent;

import java.util.Vector;

import org.snmp4j.PDU;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.VariableBinding;

import cdd.zte.nesimulator.common.MibDataTree;

public class PDUResponseAssembler
{
    IVariableResponser variableResponse;
    IGetNextOidResponser oidResponse4GetNext;
    
    public PDUResponseAssembler(MibDataTree mibDataTree)
    {
        this(new VariableResponser(mibDataTree), new GetNextOidResponser(mibDataTree));
    }
    
    public PDUResponseAssembler(IVariableResponser variableResponse, IGetNextOidResponser oidResponse4GetNext)
    {
        this.variableResponse = variableResponse;
        this.oidResponse4GetNext = oidResponse4GetNext;
    }

    public void assembleResponsePDU(PDU vPDU)
    {
        int rcvPDUType = vPDU.getType();
        
        Vector<? extends VariableBinding> varBinds = vPDU.getVariableBindings();
        
        if(rcvPDUType == PDU.GET)
        {
            for(int i = 0; i < varBinds.size(); i++)
            {
                OID responseOid = varBinds.get(i).getOid();
                vPDU.get(i).setVariable(variableResponse.response(responseOid));
            }
        }
        else if(rcvPDUType == PDU.GETNEXT)
        {
            for(int i = 0; i < varBinds.size(); i++)
            {
                OID responseOid = oidResponse4GetNext.getResponseOid(varBinds.get(i).getOid());
                VariableBinding varBind = new VariableBinding(responseOid, variableResponse.response(responseOid));
                
                vPDU.set(i, varBind);
            }
        }
//        else if(rcvPDUType == PDU.SET)
//        {
//            for(int i = 0; i < varBinds.size(); i++)
//            {
//                OID responseOid = varBinds.get(i).getOid();
//                vPDU.get(i).setVariable(variableResponse.response(responseOid));
//            }
//        }
       
        vPDU.setType(PDU.RESPONSE);
    }
}
