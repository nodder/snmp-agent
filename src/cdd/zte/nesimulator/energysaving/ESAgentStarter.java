package cdd.zte.nesimulator.energysaving;

import cdd.zte.nesimulator.agent.AgentStarter;

public class ESAgentStarter
{
    public static void main(String[] args) throws Exception
    {
        AgentStarter agent = new AgentStarter(args, new ESVariableResponse(), new ESGetNextOidResponser());
        agent.startAgent();
    }
}
