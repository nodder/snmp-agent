package cdd.zte.nesimulator.agent;

import java.util.Vector;

import org.snmp4j.PDU;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.VariableBinding;

public class DefaultPDUResponseAssembler implements IPDUResponserAssembler
{
    IVariableResponser variableResponse;
    IGetNextOidResponser oidResponse4GetNext;
    
    public DefaultPDUResponseAssembler()
    {
        this(new DefaultVariableResponser(), new DefaultGetNextOidResponser());
    }
    
    public DefaultPDUResponseAssembler(IVariableResponser variableResponse, IGetNextOidResponser oidResponse4GetNext)
    {
        this.variableResponse = variableResponse;
        this.oidResponse4GetNext = oidResponse4GetNext;
    }

    @Override
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
       
        vPDU.setType(PDU.RESPONSE);
    }
}
