package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @GetMapping("/hello-word")
    public String helloWord() {
        return "Hello word";
    }

    /**
     * 
     * @param name
     * @return
     */
    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable String name) {
        return "Hola " + name;
    }

    /**
     * endpoint para verificar si una palabra es un palindromo o no
     * 
     * @param word La paralabra a validar
     * @return Se retorna un texto indicando si word es o no palindromo
     */
    @GetMapping("/palindrome/{word}")
    public String identifyPalindromeWord(@PathVariable String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        String palindromeWord = stringBuilder.reverse().toString();

        if (word.equals(palindromeWord)) {
            return "Si es palindromo";
        } else {
            return "No es palindromo";
        }
    }

}
