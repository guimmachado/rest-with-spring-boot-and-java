package br.com.gui.controllers;

import br.com.gui.exception.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) {
        if(!isNumeric(number1) || !isNumeric(number2)) throw new UnsuportedMathOperationException("Please set a numeric value!!");
        return convertToDouble(number1) + convertToDouble(number2);
    }
    @RequestMapping("/sub/{number1}/{number2}")
    public Double sub(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) {
        if(!isNumeric(number1) || !isNumeric(number2)) throw new UnsuportedMathOperationException("Please set a numeric value!!");
        return convertToDouble(number1) - convertToDouble(number2);
    }
    @RequestMapping("/mult/{number1}/{number2}")
    public Double mult(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) {
        if(!isNumeric(number1) || !isNumeric(number2)) throw new UnsuportedMathOperationException("Please set a numeric value!!");
        return convertToDouble(number1) * convertToDouble(number2);
    }
    @RequestMapping("/div/{number1}/{number2}")
    public Double div(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) {
        if(!isNumeric(number1) || !isNumeric(number2)) throw new UnsuportedMathOperationException("Please set a numeric value!!");
        if(convertToDouble(number2) == 0) throw new UnsuportedMathOperationException("Division by zero is not allowed!!");
        return convertToDouble(number1) / convertToDouble(number2);
    }
    @RequestMapping("/mean/{number1}/{number2}")
    public Double mean(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) {
        if(!isNumeric(number1) || !isNumeric(number2)) throw new UnsuportedMathOperationException("Please set a numeric value!!");
        return (convertToDouble(number1) * convertToDouble(number2)) / 2;
    }
    @RequestMapping("/sqr/{number1}")
    public Double sqr(
            @PathVariable("number1") String number1) {
        if(!isNumeric(number1)) throw new UnsuportedMathOperationException("Please set a numeric value!!");
        return convertToDouble(number1) * convertToDouble(number1);
    }

    private Double convertToDouble(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsuportedMathOperationException("Please set a numeric value!!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }
    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
