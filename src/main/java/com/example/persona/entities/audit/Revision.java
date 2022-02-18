package com.example.persona.entities.audit;

import com.example.persona.config.CustomRevisionListener;
import lombok.Data;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "REVISION_INFO")
@RevisionEntity(CustomRevisionListener.class)
@Data
public class Revision implements Serializable {


    /*El campo serialVersionUID es el número de versión
    de la clase. Cuando el objeto es serializado lo
    primero que hace es escribir el serialVersionUID.
    Si al leer el objeto se dectecta que el valor del
    serialVersionUID guardado no coincide con el actual
     se lanza una exception InvalidClassException, de
     modo que el programador puede tratar la excepción
     de manera adecuada (por ejemplo, creando un objeto
      por defecto para susbtituir al que no puede leerse)
      .*/
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_seq")
    @SequenceGenerator(
            name = "revision_seq",
            sequenceName = "rbac_seq_revision_id"
    )
    @RevisionNumber
    private int id;

    @Column(name = "REVISION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp
    private Date date;

}
