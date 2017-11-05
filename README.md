# SNMP网元模拟工具

## 程序功能：
    本程序用于模拟SNMP协议网元。运行本程序时会在161端口监听SNMP请求，并根据预设值返回。

## 使用步骤：

1. 设置环境变量中的JAVA_HOME，注意JAVA版本至少为1.6。  也可以不设置环境变量，但需要手工指定run.bat中的JAVA_HOME变量。

2. 根据使用场景运行下列之一：

    a. run.bat用于软件电表大规模模拟网元场景。需要配合软件表表工具使用。
    
    b. *selt_mocker.bat用于模拟SELT测试，需要配合网管客户端使用：
        i.  根据需要运行对应的bat，此时模拟网元工具处于监听状态；
        ii. 网管侧放开线路测试模拟菜单，编辑\ums-client\procs\ppus\an.ppu\an-dsl.pmu\dsl9000\an-dsl-dsl9000topo.par\conf\zxnm01-dsl-9806h-topo-popupmenu.xml，将LineTestMock节点放开。
        iii.网管侧创建模拟网元，IP为SNMPAgent软件启动的地址，类型与SNMPAgent模拟的网元类型相同。
        iv. 网管侧9806H网元右键，打开“模拟线路测试”菜单，填写模拟网元的IP，点击开始按钮
        v.  在弹出的线路测试窗口中，选择SELT进行测试。
        
    注意：9806V SNMP SELT测试由于引擎限制，只能在Linux下运行，因此网管服务器端也应使用Linux环境。
    
    
## 版本更新记录：

    2014.9.9 v1.0Alpha 初始版本
    
    2017.11 上传至Git