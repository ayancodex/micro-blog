package org.codex.rest.impl;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;



public class RestApplication extends ResourceConfig {

	/**
	 * Register JAX-RS application components.
	 */
	public RestApplication() {
		// register application resources
		register(UserResource.class);
		register(PostResource.class);
		register(ReplyResource.class);
		//register(PodcastLegacyResource.class);

		// register filters
		register(RequestContextFilter.class);
		//register(LoggingResponseFilter.class);
		//register(CORSResponseFilter.class);

		// register exception mappers
		//register(GenericExceptionMapper.class);
		//register(AppExceptionMapper.class);
		//register(NotFoundExceptionMapper.class);

		// register features
		register(JacksonFeature.class);
		//register(MultiPartFeature.class);
	}
}