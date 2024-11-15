package com.frankgmv.TallerDeCoches.exceptions;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Manejo de excepción genérica para cualquier error no manejado
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // Devuelve el código de estado 500
    public String manejarErrorGenerico(Exception e, Model model) {
        // Agregar el mensaje de error a un atributo del modelo
        model.addAttribute("mensaje", "Error interno del servidor: " + e.getMessage());
        return "error";  // Retorna la vista "error.html"
    }

    // Manejo de una excepción de tipo "Recurso No Encontrado" (404)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)  // Código 404
    public String manejarRecursoNoEncontrado(ResourceNotFoundException e, Model model) {
        model.addAttribute("mensaje", "Recurso no encontrado: " + e.getMessage());
        return "404";  // Retorna la vista "error.html"
    }
}
