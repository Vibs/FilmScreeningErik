package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    
    @Bean
    PasswordEncoder passwordEncoder(){
        // default inde i param er 10 = dvs. den bliver krypteret 10 gange
        // man kan skrive et andet tal som param og så krypterer den dét antal gange
        return new BCryptPasswordEncoder();
    }

    
    // vi laver en metode
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        // TODO: research antMathcers
        /*
        * permiitAll() kan man ændre så man giver forskellige tiladelser til forskellige brugere
        * man siger hvilke sider man kan gå ind på
        *
        * */
        
        // du skal autorisere ALLE requests - uanset hvad
        http.authorizeRequests()
                // antMatchers = her kan man skrive nogle udtryk - så hvis man opfylder disse udtryk, så skal man
                // IKKE blive sm
                // webjar = filer
                // resources png, css-filer - man SKAL skrive didsse for at man kan tilgå dem
            .antMatchers("/", "/webjars/**", "/resources/**").permitAll()
            .antMatchers("/films").permitAll()
            // vi giver den urlen som vi vil sige hvem der må tilgå
            // .permitAll() == vi tillader ALLE - hvis vi ville gøre at det kun er én rolle der skal have adgang
                // siger man: .hasRole("ADMIN") fx - så ville det KUN være en admin som kunne se den side vi har
                // skrevet som param
            // når det er en RESTController skal vi bruge mvcMatchers og ikke antMatchers
            .mvcMatchers(HttpMethod.GET, "/api/films").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            // .loginPage("/") == vi sætter den til at linke til der hvor vi har vores loginPage - så vi kan
            // ændre loginsiden, så det er vores egen og ikke den der standard som følger med
            .and()
            .httpBasic();
        
    }


    
}
