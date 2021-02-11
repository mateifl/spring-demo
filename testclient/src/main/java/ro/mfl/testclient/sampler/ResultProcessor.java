package ro.mfl.testclient.sampler;

import ro.mfl.testclient.journey.Result;

@FunctionalInterface
public interface ResultProcessor<T> {
	void processResult(Result<T> result);
}
