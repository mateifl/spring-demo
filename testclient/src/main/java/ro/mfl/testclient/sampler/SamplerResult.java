package ro.mfl.testclient.sampler;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class SamplerResult {
	private final Long startTime;
	private final Long endTime;
}
