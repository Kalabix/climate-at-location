package common.jerseyclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import common.exceptions.JerseyClientBuildException;
import common.exceptions.Messages;
import common.interfaces.BuilderInterface;

/**
 * Builder for the Jersey client
 *
 */
public class JerseyClientBuilder implements BuilderInterface<Invocation.Builder> {

	private String target;
	private String path;
	private String mediaType;
	private String queryParam;

	public Invocation.Builder build() {
		Invocation.Builder invocationBuilder = null;
		try {
			// create and configure the Jersey client
			Client client = ClientBuilder.newClient();
			WebTarget webTarget = client.target(target).path(path);
			invocationBuilder = webTarget.request(mediaType);

			// adds queryparam to url
			webTarget.queryParam("location", queryParam);
		} catch (Exception e) {
			throw e;
		}
		return invocationBuilder;
	}

	/**
	 * Defines the resource target.
	 * 
	 * @param target - location of web resource eg http://weatherapi.com .
	 * @return JerseyClientBuilder
	 * @throws JerseyClientBuildException
	 */
	public JerseyClientBuilder setTarget(String target) throws JerseyClientBuildException {
		if (target == null || target.isEmpty()) {
			throw new JerseyClientBuildException(Messages.INVALID_WEB_TARGET);
		}
		this.target = target;
		return this;
	}

	/**
	 * Defines the path to the resource.
	 * 
	 * @param path 		The path to a particular resource
	 * @return JerseyClientBuilder
	 * @throws JerseyClientBuildException
	 */
	public JerseyClientBuilder setPath(String path) throws JerseyClientBuildException {
		if (path == null || path.isEmpty()) {
			throw new JerseyClientBuildException(Messages.INVALID_PATH);
		}
		this.path = path;
		return this;
	}

	/**
	 * Defines the type of data returned eg json, text ect.
	 * 
	 * @param mediaType	The type of the data the endpoint will return
	 * @return
	 * @throws JerseyClientBuildException
	 */
	public JerseyClientBuilder setMediaType(String mediaType) throws JerseyClientBuildException {
		if (mediaType == null || mediaType.isEmpty()) {
			throw new JerseyClientBuildException(Messages.INVALID_MEDIA_TYPE);
		}
		this.mediaType = mediaType;
		return this;
	}

	/**
	 * Defines the location the user wants the weather report for.
	 * 
	 * @param location 	 The  query parameter of the location
	 * @return JerseyClientBuilder
	 * @throws JerseyClientBuildException
	 */
	public JerseyClientBuilder setLocationParameter(String location) throws JerseyClientBuildException {
		if (location == null || location.isEmpty()) {
			throw new JerseyClientBuildException(Messages.INVALID_LOCATION);
		}
		this.queryParam = location;
		return this;
	}
}
