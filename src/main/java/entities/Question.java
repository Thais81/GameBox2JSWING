/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author Guillaume Rostagnat
 */
public class Question implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id_qa;
    private String question;
    private String answer;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question{");
        sb.append("id_qa=").append(id_qa);
        sb.append(", question=").append(question);
        sb.append(", answer=").append(answer);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId_qa() {
        return id_qa;
    }

    public void setId_qa(Integer id_qa) {
        this.id_qa = id_qa;
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
