package cdd.zte.nesimulator.agent;

import junit.framework.TestCase;

import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;

import cdd.zte.nesimulator.common.MibDataTree;

public class GetNextOidResponserTest extends TestCase
{
    private static final String PREFIX = "1.3.6.1.4.1.3902.1015";
    
    private MibDataTree mibDataTree = null;
    private GetNextOidResponser nextOidRes = null;
    
    @Override
    protected void setUp() throws Exception
    {
        mibDataTree = new MibDataTree();
        mibDataTree.insert(new OID(PREFIX + ".100"), new Integer32(100));
        
        nextOidRes = new GetNextOidResponser(mibDataTree);
    }
    
    
    public void test1()
    {
        assertEquals(new OID(PREFIX + ".100"), nextOidRes.getResponseOid(new OID(PREFIX)));
        assertEquals(new OID(PREFIX + ".100"), nextOidRes.getResponseOid(new OID(PREFIX + ".99")));
        assertEquals(new OID(PREFIX + ".100"), nextOidRes.getResponseOid(new OID(PREFIX + ".99.9")));
        assertEquals(new OID("1.3.6.1.4.1.3902.9.99.999.9999"), nextOidRes.getResponseOid(new OID(PREFIX + ".100")));
        assertEquals(new OID("1.3.6.1.4.1.3902.9.99.999.9999"), nextOidRes.getResponseOid(new OID(PREFIX + ".200")));
    }
    
    public void test2()
    {
        mibDataTree.insert(new OID(PREFIX + ".102"), new Integer32(100));
        mibDataTree.insert(new OID(PREFIX + ".104"), new Integer32(100));
        mibDataTree.insert(new OID(PREFIX + ".106.10.1"), new Integer32(100));
        
        assertEquals(new OID(PREFIX + ".100"), nextOidRes.getResponseOid(new OID(PREFIX + ".99.9")));
        assertEquals(new OID(PREFIX + ".102"), nextOidRes.getResponseOid(new OID(PREFIX + ".100")));
        assertEquals(new OID(PREFIX + ".102"), nextOidRes.getResponseOid(new OID(PREFIX + ".100.10.2.6.45")));
        assertEquals(new OID(PREFIX + ".106.10.1"), nextOidRes.getResponseOid(new OID(PREFIX + ".104")));
        assertEquals(new OID("1.3.6.1.4.1.3902.9.99.999.9999"), nextOidRes.getResponseOid(new OID(PREFIX + ".106.10.1")));
    }
    
    public void test3()
    {
        mibDataTree.insert(new OID(PREFIX + ".200.1"), new Integer32(100));
        mibDataTree.insert(new OID(PREFIX + ".200.2"), new Integer32(100));
        mibDataTree.insert(new OID(PREFIX + ".300.100.1"), new Integer32(100));
        mibDataTree.insert(new OID(PREFIX + ".300.100.3"), new Integer32(100));
        
        assertEquals(new OID(PREFIX + ".200.1"), nextOidRes.getResponseOid(new OID(PREFIX + ".200")));
        assertEquals(new OID(PREFIX + ".200.2"), nextOidRes.getResponseOid(new OID(PREFIX + ".200.1")));
        assertEquals(new OID(PREFIX + ".300.100.1"), nextOidRes.getResponseOid(new OID(PREFIX + ".200.2")));
        
        assertEquals(new OID(PREFIX + ".300.100.1"), nextOidRes.getResponseOid(new OID(PREFIX + ".300.100")));
        assertEquals(new OID(PREFIX + ".300.100.3"), nextOidRes.getResponseOid(new OID(PREFIX + ".300.100.1")));
        assertEquals(new OID("1.3.6.1.4.1.3902.9.99.999.9999"), nextOidRes.getResponseOid(new OID(PREFIX + ".300.100.3")));
    }
}
