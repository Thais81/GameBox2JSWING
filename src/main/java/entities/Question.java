/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;

/**
 *Création de l'entité question destinée à hydrater la base de données.
 * Contient les attributs correspondant à la table question:
 * Id, question et réponse correspondante.
 * Ne contiendra que toString pour affichage dans la console ainsi que getters et setters
 * @author Guillaume Rostagnat
 */
public class Question implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id_question;
    private String question;
    private String answer;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question{");
        sb.append("id_question=").append(id_question);
        sb.append(", question=").append(question);
        sb.append(", answer=").append(answer);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId_question() {
        return id_question;
    }

    public void setId_question(Integer id_question) {
        this.id_question = id_question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    
    
    
    
}
