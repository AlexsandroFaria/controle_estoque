/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.utilitarios;

import br.com.cde.view.TelaConsultaBaixaEstoquePorData;
import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author alafaria
 */
public class Utilitarios {
    
     public void limpaTela(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
        }
    }
    
    
     
}
