package es.dsrroma.school.springboot.reuniones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indica que esta clase define beans de configuración para Spring.
@EnableWebSecurity // Habilita la seguridad web de Spring Security.
public class SecurityConfig {

    @Bean // Define un bean para la configuración de la cadena de filtros de seguridad.
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Configuración de seguridad HTTP
        http.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        .requestMatchers("/api/**").hasRole("API_USER") // Las solicitudes a rutas que empiezan con "/api/" requieren el rol "API_USER".
                        .anyRequest().authenticated()) // Cualquier otra solicitud debe estar autenticada.
                .formLogin(
                        formLogin -> formLogin.loginPage("/login").permitAll())
                        ; // Si el usuario no está autenticado, será redirigido a la página de login "/login".

        return http.build(); // Construye y devuelve la configuración de seguridad.
    }

    @Bean // Define un bean para el codificador de contraseñas.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usa BCrypt para codificar contraseñas de manera segura.
    }
}




