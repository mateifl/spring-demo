package ro.mfl.testclient.sampler;


import lombok.Data;
import ro.mfl.testclient.journey.Journey;
import java.util.Calendar;


@Data
public class JourneySampler implements Sampler {

    private Long startTime;
    private Long endTime;
    private final Journey journey;
    private Boolean active;

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        startTime  = calendar.getTimeInMillis();
        journey.execute();
        endTime = calendar.getTimeInMillis();
    }

    @Override
    public Boolean active() {
        return active;
    }
}
