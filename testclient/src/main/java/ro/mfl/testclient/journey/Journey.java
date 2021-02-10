package ro.mfl.testclient.journey;


public interface Journey<T> {

    Result<T> execute();

}
