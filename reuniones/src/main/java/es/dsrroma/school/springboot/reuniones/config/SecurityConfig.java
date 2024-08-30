package es.dsrroma.school.springboot.reuniones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indica que esta clase define beans de configuración para Spring.
@EnableWebSecurity // Habilita la seguridad web de Spring Security.
public class SecurityConfig {

    @Bean // Define un bean para la configuración de la cadena de filtros de seguridad.
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Configuración de seguridad HTTP
        http.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        .requestMatchers("/api/**", "/api/rest/**").hasRole("API_USER") // Las solicitudes a rutas que empiezan con "/api/" requieren el rol "API_USER".
                        .anyRequest().permitAll()) // Cualquier otra solicitud debe estar autenticada.
                .formLogin(
                        formLogin -> formLogin.loginPage("/login").permitAll())
                        ; // Si el usuario no está autenticado, será redirigido a la página de login "/login".

        return http.build(); // Construye y devuelve la configuración de seguridad.
    }

     @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("admin")
            .password(passwordEncoder().encode("admin123"))  // Configura el usuario "admin" con la contraseña "admin123".
            .roles("USER", "API_USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean // Define un bean para el codificador de contraseñas.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usa BCrypt para codificar contraseñas de manera segura.
    }
}




