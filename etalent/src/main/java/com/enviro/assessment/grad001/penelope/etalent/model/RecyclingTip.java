package com.enviro.assessment.grad001.penelope.etalent.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 500)
    private String tip;

    // Getters and Setters

    public @NotNull @Size(min = 2, max = 500) String getTip() {
        return tip;
    }

    public void setTip(@NotNull @Size(min = 2, max = 500) String tip) {
        this.tip = tip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}