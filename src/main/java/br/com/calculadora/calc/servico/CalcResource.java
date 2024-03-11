package br.com.calculadora.calc.servico;

import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class CalcResource {

    // baixar postman para rodar o servidor
    @PostMapping("/soma")
    public String testPost(@RequestBody(required = true) double v1) {
        return  "Salvou no branco" + v1;
    }

    @PostMapping("/soma/{v2}")
    public String testPost(@RequestBody(required = true) double v1,
                           @RequestBody(required = true) double v2) {
        return "Salvou no branco" + (v1 + v2);
    }

    @DeleteMapping("/soma/{id}")
    public String apagarQC(@PathVariable double id) {
        return id + "apagado";
    }
    @PutMapping("/soma/{id}")
    public String putting(@PathVariable double id) {
        return "alterando mais de um campo" + id;
    }

    @GetMapping("equacao/{A}/{B}")
    public double equacao(@PathVariable(required = true) double A
            , @PathVariable(required = true) double B
            , @RequestParam(required = true) double C) {
        return (C - B)/A;
    }

    @GetMapping("/imc")
    public  double imc(@RequestHeader(required = true) double peso,
                       @RequestHeader(required = true) double altura) {
        return (peso)/(altura*altura);
    }

    // uma segunda forma de fazer
    @GetMapping("/imc/{peso}/{altura}")
    public  double imc2(@PathVariable(required = true) double peso,
                       @PathVariable(required = true) double altura) {
        return (peso)/(altura*altura);
    }
    @PatchMapping("/soma/{id}")
    public  String patch(@PathVariable double id) {
        return "alterando um campo" + id;
    }

    @GetMapping("/soma/{valor1}/{valo2}")
    public double soma(@PathVariable double valor1,
                       @PathVariable double valor2){
        return  valor1 + valor2;
    }

    @GetMapping("/soma/v1")
    public double somaQP (@RequestParam (required = true) double valor1,
                          @RequestParam (required = true) double valor2) {
        return valor1 + valor2;
    }

    @GetMapping("/soma")
    public double somaBP(@RequestParam(name = "v1", required = true)double valor1,
                         @RequestParam(name = "v2", required = true) double valor2){
        return  valor1 + valor2;
    }

    @GetMapping("soma/v2")
    public  double somaHP(@RequestParam (required = true) double valor1,
                          @RequestParam (required = true) double valor2) {
        return valor1 + valor2;
    }

    @GetMapping({"/nome", ""})
    public String retornarNome() {
        return  "Servico rest de calculadora";
    }
}
