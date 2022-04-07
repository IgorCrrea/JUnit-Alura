package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioAlto() {
		BonusService service = new BonusService();
		
		//assertThrows(IllegalArgumentException.class,
		//		() -> service.calcularBonus(new Funcionario("Igor", LocalDate.now(), new BigDecimal("10000000"))));
		
		try {
			service.calcularBonus(new Funcionario("Igor", LocalDate.now(), new BigDecimal("10000000")));
			fail("Não deu a Exception");
		} catch (Exception e) {
			assertEquals("Funcionario com salario maior que R$ 10000 não pode receber o bonus", e.getMessage());
		}
		
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Igor", LocalDate.now(), new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Igor", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
