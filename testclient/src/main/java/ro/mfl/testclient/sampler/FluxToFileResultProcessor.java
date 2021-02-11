package ro.mfl.testclient.sampler;

import java.io.FileWriter;
import java.io.IOException;

import reactor.core.publisher.Flux;
import ro.mfl.testclient.journey.Result;

public class FluxToFileResultProcessor implements ResultProcessor<Flux<String>> {

	@Override
	public void processResult(Result<Flux<String>> result) {
		try( FileWriter fileWriter = new FileWriter("test.out") ) {
//			result.getResult().subscribe( item -> fileWriter.write(item + "\n") );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
