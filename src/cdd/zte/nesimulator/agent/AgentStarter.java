package cdd.zte.nesimulator.agent;

import cdd.zte.nesimulator.common.MibDataTree;


public class AgentStarter
{
    private static final int port = 161;
    
    private CommandResponseAgent agent = null;
    
    public AgentStarter(String[] args, IVariableResponser variableResponse, IGetNextOidResponser getNextOidResponser)
    {
        final int responseDelay = getResponseDelay(args);
        System.out.println("responseDelay == " + responseDelay + "ms");
        
        String localIp = SnmpAgentUtil.getLocalhostIp();
        System.out.println("localIp == " + localIp);
        
        agent = new CommandResponseAgent(localIp, port, variableResponse, getNextOidResponser);
        agent.setResoponseDelay(responseDelay);
    }

    public AgentStarter(String[] args, MibDataTree mibDataTree)
    {
        final int responseDelay = getResponseDelay(args);
        System.out.println("responseDelay == " + responseDelay + "ms");
        
        String localIp = SnmpAgentUtil.getLocalhostIp();
        System.out.println("localIp == " + localIp);
        
        agent = new CommandResponseAgent(localIp, port, mibDataTree);
        agent.setResoponseDelay(responseDelay);
    }
    
    public void startAgent()
    {
        try
        {
            agent.startListening();
            System.out.println("SNMP agent program is listening at port " + port + "...");
            
            blockProgram();
        }
        catch(Throwable e)
        {
            e.printStackTrace();
        }
    }

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
}
