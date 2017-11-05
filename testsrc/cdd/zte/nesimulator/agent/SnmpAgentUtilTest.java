package cdd.zte.nesimulator.agent;

import junit.framework.TestCase;

import org.snmp4j.smi.OID;

public class SnmpAgentUtilTest extends TestCase
{
    private static final OID second = new OID("1.3.7");
    
    public void test_isSmaller_fun()
    {
        OID first = new OID("1.3.6");
        assertTrue(SnmpAgentUtil.isSmaller(first, second));
        assertTrue(!SnmpAgentUtil.isSmaller(second, first));
        
        first = new OID("1.3");
        assertTrue(SnmpAgentUtil.isSmaller(first, second));
        assertTrue(!SnmpAgentUtil.isSmaller(second, first));
        
        first = new OID("1.3.6.1");
        assertTrue(SnmpAgentUtil.isSmaller(first, second));
        assertTrue(!SnmpAgentUtil.isSmaller(second, first));
        
        first = new OID("1.3.7.1");
        assertTrue(!SnmpAgentUtil.isSmaller(first, second));
        assertTrue(SnmpAgentUtil.isSmaller(second, first));
    }
}
