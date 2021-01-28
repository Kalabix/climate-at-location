package common.jerseyclient;

import org.junit.Test;
import common.exceptions.JerseyClientBuildException;
import common.jerseyclient.JerseyClientBuilder;

public class JerseyClientBuilderTest {

	@Test(expected = JerseyClientBuildException.class)
	public void testInvalidNullPath() throws JerseyClientBuildException {
		JerseyClientBuilder builder = new JerseyClientBuilder();
		builder.setPath(null);
	}
	
	@Test(expected = JerseyClientBuildException.class)
	public void testInvalidEmptyStringPath() throws JerseyClientBuildException {
		JerseyClientBuilder builder = new JerseyClientBuilder();
		builder.setPath("");
	}
	
	@Test(expected = JerseyClientBuildException.class)
	public void testInvalidNullTarget() throws JerseyClientBuildException {
		JerseyClientBuilder builder = new JerseyClientBuilder();
		builder.setPath(null);
	}
	
	@Test(expected = JerseyClientBuildException.class)
	public void testInvalidEmptyStringTarget() throws JerseyClientBuildException {
		JerseyClientBuilder builder = new JerseyClientBuilder();
		builder.setTarget("");
	}
	
	@Test(expected = JerseyClientBuildException.class)
	public void testInvalidNullMediaType() throws JerseyClientBuildException {
		JerseyClientBuilder builder = new JerseyClientBuilder();
		builder.setMediaType(null);
	}
	
	@Test(expected = JerseyClientBuildException.class)
	public void testInvalidEmptyStringMediaType() throws JerseyClientBuildException {
		JerseyClientBuilder builder = new JerseyClientBuilder();
		builder.setMediaType("");
	}

}
