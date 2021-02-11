package ro.mfl.testclient.sampler;

import reactor.core.publisher.Flux;
import ro.mfl.testclient.journey.Result;

public class FluxToConsoleResultProcessor implements ResultProcessor<Flux<String>> {

	@Override
	public void processResult(Result<Flux<String>> result) {
//		result.getResult().buffer().subs;
		
	}

}
