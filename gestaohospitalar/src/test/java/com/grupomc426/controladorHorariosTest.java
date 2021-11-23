package com.grupomc426;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.grupomc426.API.controladorHorarios;
import com.grupomc426.Targets.Usuarios.*;
import java.time.LocalDateTime;

public class controladorHorariosTest {

    @Test
    void CasoValido() {
        boolean esperado = true;

        Pessoa paciente = new Pessoa("Pessoa Teste", "11987654322", "22222222222", "1980");
        Pessoa pessoaMedico = new Pessoa("Medico Teste", "11987654321", "11111111111", "1970");
        Usuario usuario = new Usuario(pessoaMedico, "senha123", true);
        Medico medico = new Medico(usuario, "12345", null);
        LocalDateTime horario = LocalDateTime.of(2021, 12, 21, 8, 15, 00);

        controladorHorarios controlador = new controladorHorarios();
        controlador.registrarHorario(medico, horario);
        boolean resultado = controlador.reservarHorario(medico, horario, paciente);

        assertEquals(esperado, resultado);
    }

    @Test
    void HorarioComMedicoOcupado() {
        boolean esperado = false;

        Pessoa paciente1 = new Pessoa("Pessoa Um", "11987654322", "22222222222", "1980");
        Pessoa paciente2 = new Pessoa("Pessoa Dois", "11987654323", "33333333333", "1981");
        Pessoa pessoaMedico = new Pessoa("Medico Teste", "11987654321", "11111111111", "1970");
        Usuario usuario = new Usuario(pessoaMedico, "senha123", true);
        Medico medico = new Medico(usuario, "12345", null);
        LocalDateTime horario = LocalDateTime.of(2021, 12, 21, 8, 15, 00);

        controladorHorarios controlador = new controladorHorarios();
        controlador.registrarHorario(medico, horario);
        controlador.reservarHorario(medico, horario, paciente1);
        boolean resultado = controlador.reservarHorario(medico, horario, paciente2);

        assertEquals(esperado, resultado);
    }

    @Test
    void HorarioInvalido() {
        boolean esperado = false;

        Pessoa pessoaMedico = new Pessoa("Medico Teste", "11987654321", "11111111111", "1970");
        Usuario usuario = new Usuario(pessoaMedico, "senha123", true);
        Medico medico = new Medico(usuario, "12345", null);
        LocalDateTime horario = LocalDateTime.of(2008, 04, 01, 12, 42, 25);

        controladorHorarios controlador = new controladorHorarios();
        boolean resultado = controlador.registrarHorario(medico, horario);

        assertEquals(esperado, resultado);
    }
}