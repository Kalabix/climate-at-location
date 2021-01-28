package common.dtos.builders;

import org.junit.Test;
import common.dtos.builders.ClimateDTOBuilder;

public class ClimateDtoBuilderTest {

	@Test(expected = NullPointerException.class)
	public void testNullDto() {
		ClimateDTOBuilder.ClimateDTOBuilder(null).build();
		
	}
}
