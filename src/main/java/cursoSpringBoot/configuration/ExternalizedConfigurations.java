package cursoSpringBoot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//indica a spring que es un archivo de configuración y que debe ser tratado como un bean 
@Configuration
// indispensable, y que con esto vamos a indicarle a spring que vamos a utilizar
// las variables de
// configuración
// con prefix se enlaza a esta clase, al archivo application.propierties, lo
// cual, busca
// todas aquellas propiedades que inicien con app
@ConfigurationProperties(prefix = "app")
public class ExternalizedConfigurations {
    // definimos el nombre de los atributos que van a llegar del archivo de
    // configuración (no es indispensable que se llamen igual, pero si es buena
    // práctica)
    // lo que si es importante seguir, es el ORDEN EN COMO SE DEFINIERON EN EL
    // ARCHIVO DE CONFIGURACIÓN, es decir, si version lo definiste en segudo lugar
    // aqui igual debe ir en el segundo lugar

    private String name;
    private String version;
    private String autor;
    private String language;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Extenalized configuration: " + "\n" +
                "name: " + this.name + "\n" +
                "version: " + this.version + "\n" +
                "autor: " + this.autor + "\n" +
                "language: " + this.language + "\n" +
                "country:" + this.country;
    }
}
