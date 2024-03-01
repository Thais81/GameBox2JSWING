/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.QuestionDAO;
import entities.Question;
import graphics.Formulaire;
import java.util.Collection;

/**
 *
 * @author Guillaume Rostagnat
 */
public class MainDAO {

    public static void main(String[] args) {
        QuestionDAO qdao = new QuestionDAO();

        Question qa1 = new Question();
        Question qa2 = new Question();
        Question qa3 = new Question();
        Question qa4 = new Question();
        Question qa5 = new Question();
        
        qa1.setQuestion("Quelle est la capitale de la France?");
        qa1.setAnswer("Paris");
        System.out.println(qa1);
        qdao.create(qa1);
        System.out.println(qa1);

        Question q = qdao.read(2);
        System.out.println(q);
         // Modifier l'objet p (sof sur la bdd)
        q.setQuestion("Quelle est la capitale de l'Espagne?");
        q.setAnswer("Madrid");
        // l'update en DB
        qdao.update(q);
        System.out.println(q);
         //Supprimer
//        qdao.delete(q.getId_question());
        
        
        //Afficher la liste
        show(qdao.list());
         // Compter les lignes
        System.out.println("nb lignes = " + qdao.count());
    }

 private static void show(Collection<Question> list) {
        for (Question q : list) {
            System.out.println(q);
        }

 
        
        /*qa2.setQuestion("Comment s'appelle le président de la république ?");
        qa2.setAnswer("Emmanuel Macron");
        System.out.println(qa2);
        qdao.create(qa2);
        System.out.println(qa2);

        qa3.setQuestion("Combien une main contient de doigts ?");
        qa3.setAnswer("5");
        System.out.println(qa3);
        qdao.create(qa3);
        System.out.println(qa3);

        qa4.setQuestion("Est-ce que Guillaume est le boss du code ?");
        qa4.setAnswer("oui");
        System.out.println(qa4);
        qdao.create(qa4);
        System.out.println(qa4);

        qa5.setQuestion("De quelle couleur est le ciel?");
        qa5.setAnswer("bleu");
        System.out.println(qa5);
        qdao.create(qa5);
        System.out.println(qa5); */
    }

}

