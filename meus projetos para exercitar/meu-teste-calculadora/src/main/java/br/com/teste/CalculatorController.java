package br.com.teste;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	String primeiroNumero;
	String segundoNumero;
	
	@RequestMapping("/somar")
	public float somar(@RequestParam(value = "termo") String termo) {
		primeiroNumero = termo.substring(0, termo.indexOf(","));
		segundoNumero = termo.substring((termo.indexOf(",")+1), termo.length());
		
		return Float.parseFloat(primeiroNumero) + Float.parseFloat(segundoNumero);
		
	}
	
	@RequestMapping("/subtrair")
	public float subtrair(@RequestParam(value = "termo") String termo) {
		primeiroNumero = termo.substring(0, termo.indexOf(","));
		segundoNumero = termo.substring((termo.indexOf(",")+1), termo.length());
		
		return Float.parseFloat(primeiroNumero) - Float.parseFloat(segundoNumero);
	}
	
	@RequestMapping("/multiplicar")
	public float multiplicar(@RequestParam(value="termo") String termo) {
		primeiroNumero = termo.substring(0, termo.indexOf(","));
		segundoNumero = termo.substring((termo.indexOf(",")+1), termo.length());
		
		return Float.parseFloat(primeiroNumero) * Float.parseFloat(segundoNumero);
	}
	
	@RequestMapping("/dividir")
	public float dividir(@RequestParam(value="termo") String termo) {
		primeiroNumero = termo.substring(0, termo.indexOf(","));
		segundoNumero = termo.substring((termo.indexOf(",")+1), termo.length());
		
		return Float.parseFloat(primeiroNumero) / Float.parseFloat(segundoNumero);
	}
	
}
