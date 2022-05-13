/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Pessoa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aluno
 */
@Stateless
public class PessoaDAO {

    @PersistenceContext(unitName = "phaselistenerPU")
    private EntityManager em;

    public Pessoa findByLoginSenha(String login, String senha) {
        
        List<Pessoa> pessoas = em.createQuery("SELECT p FROM Pessoa p WHERE p.login = :login AND p.senha = :senha",
                 Pessoa.class).setParameter("login", login).setParameter("senha", senha).getResultList();
        
        if(!pessoas.isEmpty()){
            return pessoas.get(0);
        }else{
            return null;
        }
        
        
    }

}
