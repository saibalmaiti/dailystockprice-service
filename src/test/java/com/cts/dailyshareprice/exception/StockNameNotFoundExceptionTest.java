package com.cts.dailyshareprice.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StockNameNotFoundExceptionTest {
	private StocksNameNotFoundException e = new StocksNameNotFoundException("message");
	@Test
	void testMessageSetter() {
		assertThat(e).isNotNull();
	}	
}
