package ejercicio.evaluacion;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EvaluacionApplicationTests {

	@InjectMocks
	EvaluacionApplication evaluacionApplication;

	@Test
	public void applicationContextTest() {
		evaluacionApplication.main(new String[] {});
	}

}
