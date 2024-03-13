package com.aravena.arriendolibrosbackend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="MENU")
@Getter
@Setter
public class Menu {

	@Id
	@Column(name = "ID_MENU")
    private Integer idMenu;

    @Column(name = "NOMBRE", length = 20)
    private String nombre;

    @Column(name = "URL", length = 50)
    private String url;

    @Column(name = "ICONO", length = 20)
    private String icono;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "MENU_ROL"
             , joinColumns = @JoinColumn(name = "ID_MENU", referencedColumnName = "ID_MENU")
             , inverseJoinColumns = @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL"))
    private List<Rol> roles;
}
