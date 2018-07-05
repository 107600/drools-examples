package com.neo.drools;

import com.neo.drools.entity.AutoMessage;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class DroolsScoreExample {


    /**
     * 通过规则引擎决定是否发送自动消息
     *
     * @param args
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception{
        // KieServices is the factory for all KIE services
        KieServices ks = KieServices.Factory.get();

        // From the kie services, a container is created from the classpath
        KieContainer kc = ks.getKieClasspathContainer();

        execute( kc );
    }


    public static void execute( KieContainer kc ) throws Exception{
        // From the container, a session is created based on
        // its definition and configuration in the META-INF/kmodule.xml file
        KieSession ksession = kc.newKieSession("point-rulesKS");

        AutoMessage autoMessage = generateDbData();
            ksession.insert(autoMessage);
            ksession.fireAllRules();
            // 执行完规则后,这里需要执行接下来的逻辑
            printMessage(autoMessage);
        ksession.dispose();

    }

  
    private static void printMessage(AutoMessage autoMessage){
        System.out.println("用户" + autoMessage.getUserId() + "是否发送消息: " + autoMessage.getSend());
    }  
      
    private static AutoMessage generateDbData() throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            AutoMessage autoMessage = new AutoMessage();
            autoMessage.setState(false);
            autoMessage.setGameId(5936l);
            autoMessage.setLastLoginDate(df.parse("2017-6-25").getTime());
            autoMessage.setLastSendDate(df.parse("2017-7-2").getTime());
            autoMessage.setUserId(12331l);
            return autoMessage;

}  }