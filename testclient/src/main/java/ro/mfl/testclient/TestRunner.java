package ro.mfl.testclient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import ro.mfl.testclient.sampler.JourneySampler;
import ro.mfl.testclient.sampler.Sampler;
import ro.mfl.testclient.testplan.TestPlan;
import ro.mfl.testclient.testplan.TestPlanItem;

@Component
@Slf4j
public class TestRunner implements CommandLineRunner, ApplicationContextAware {
	
    @Value("${pool.size}")
	private Integer fixedPoolSize;
    @Value("${test.plan.filename}")
    private String path;
    
    private ApplicationContext applicationContext;
    
    @Override
    public void run(String... args) throws Exception {
    	log.info("start test plan");
    	TestPlan testPlan = new TestPlan();
    	testPlan.loadFromFile(new ClassPathResource(path).getPath());
    	List<TestPlanItem> testPlanItems = testPlan.getItems();
    	
    	List<Sampler> samplers = new ArrayList<Sampler>();
    	
    	for(TestPlanItem testPlanItem : testPlanItems) {
    		for( int i = 0; i < testPlanItem.getRunsNumber(); i++ ) {
//    			JourneySampler<>
//    			samplers.add(  );
    		}
    	}
    	
        ExecutorService executor = Executors.newFixedThreadPool(fixedPoolSize);
        
        
        
//        executor.invokeAll( );

    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}
}
