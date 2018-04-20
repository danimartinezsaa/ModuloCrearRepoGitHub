/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danimartinez.github;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category="File",
        id="com.danimartinez.github.CrearRepositorio"
)
@ActionRegistration(
        iconBase="com/danimartinez/github/github.png",
        displayName="#CTL_CrearRepositorio"
)
@ActionReference(path="Menu/Versioning", position=0)
@Messages("CTL_CrearRepositorio=Crear Repositorio GitHub")
public final class CrearRepositorio implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e){
        
        String nombre=JOptionPane.showInputDialog("Inserte el nombre del repositorio:");
        try{
            GitHub github=GitHub.connect();
            GHCreateRepositoryBuilder builder;
            builder=github.createRepository(nombre);
            builder.create();
        }catch(IOException ex){
            System.out.println("Error:"+ex);
        }
    }
}
