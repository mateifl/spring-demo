package ro.mfl.testclient.sampler;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ro.mfl.testclient.journey.Journey;
import java.util.Calendar;


@Data
@RequiredArgsConstructor
@Slf4j
public class JourneySampler<T> implements Sampler {

    private Long startTime;
    private Long endTime;
    private final Journey<T> journey;
    private final ResultProcessor<T> resultProcessor;

    @Override
    public SamplerResult call() {
  	
    	if(log.isDebugEnabled()) log.debug("start sample");
        Calendar calendar = Calendar.getInstance();
        startTime  = calendar.getTimeInMillis();
        resultProcessor.processResult(journey.execute());
        calendar = Calendar.getInstance();
        endTime = calendar.getTimeInMillis();
        if(log.isDebugEnabled()) log.debug("end sample");
        log.info("time: " + (endTime - startTime));
        return SamplerResult.builder().startTime(startTime).endTime(endTime).build();
        
    }

}
