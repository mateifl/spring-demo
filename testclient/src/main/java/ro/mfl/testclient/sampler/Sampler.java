package ro.mfl.testclient.sampler;

public interface Sampler extends Runnable {

    Long getStartTime();
    Long getEndTime();
    Boolean active();
}
