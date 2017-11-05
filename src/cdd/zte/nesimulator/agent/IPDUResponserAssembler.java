package cdd.zte.nesimulator.agent;

import org.snmp4j.PDU;

public interface IPDUResponserAssembler
{
    void assembleResponsePDU(PDU vPDU);
}
