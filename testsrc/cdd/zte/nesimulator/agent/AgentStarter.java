package cdd.zte.nesimulator.agent;



public class AgentStarter
{
    private static final int port = 161;
    
    private static void blockProgram() throws InterruptedException
    {
        synchronized(CommandResponseAgent.class)
        {
            CommandResponseAgent.class.wait();
        }
    }
    
    private static int getResponseDelay(String[] args)
    {
        if(args.length == 0)
        {
            return 0;
        }
        
        try
        {
            return Integer.parseInt(args[0]);
        }
        catch(NumberFormatException e)
        {
            return 0;
        }
    }
    
    public static void main(String[] args) throws Exception
    {
        String localIp = SnmpAgentUtil.getLocalhostIp();
        System.out.println("localIp == " + localIp);
        
        final int responseDelay = getResponseDelay(args);
        System.out.println("responseDelay == " + responseDelay + "ms");
        
        CommandResponseAgent agent = new CommandResponseAgent(localIp, port);
        agent.setDataResponser(new DefaultPDUResponseAssembler(new VariableResponseStub(), new GetNextOidResponserStub()));
        agent.setResoponseDelay(responseDelay);
        
        agent.startListening();
        System.out.println("SNMP agent program is listening at port " + port + "...");
        
        blockProgram();
    }
}
