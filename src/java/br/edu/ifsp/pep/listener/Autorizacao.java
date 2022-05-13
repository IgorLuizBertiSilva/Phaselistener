/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.listener;

import br.edu.ifsp.pep.control.PessoaController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author aluno
 */
public class Autorizacao implements PhaseListener {
    
    @Inject
    private PessoaController pessoaController;

    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println("After: " + event.getPhaseId());

        HttpServletRequest request = (HttpServletRequest) event.getFacesContext().getExternalContext().getRequest();

        System.out.println("Path: " + request.getServletPath());
        if (request.getServletPath().equals("/financeiro.xhtml")) {
            if(pessoaController.getPessoaAutentificada() == null){
                try {
                    event.getFacesContext().getExternalContext().redirect("index.xhtml");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

//        System.out.println("................");
//        System.out.println("Address: " + request.getRemoteAddr());
//        System.out.println("Host: " + request.getRemoteHost());
//        System.out.println("User: " + request.getRemoteUser());
//        System.out.println("Local Addr: " + request.getLocalAddr());
//        System.out.println("Path: " + request.getServletPath());
//        System.out.println("Server Name: " + request.getServerName());
//        System.out.println("Path Info: " + request.getPathInfo());
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("Before: " + event.getPhaseId());

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
