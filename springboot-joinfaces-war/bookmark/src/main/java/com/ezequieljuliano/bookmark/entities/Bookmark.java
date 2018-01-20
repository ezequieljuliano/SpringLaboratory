package com.ezequieljuliano.bookmark.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "bookmark")
@SequenceGenerator(sequenceName = "seq_boo_id", name = "bookmark_identifier", allocationSize = 1)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Bookmark implements Serializable {

    @Id
    @GeneratedValue(generator = "bookmark_identifier", strategy = GenerationType.SEQUENCE)
    @Column(name = "boo_id", nullable = false, updatable = false)
    @Getter
    private Long id;

    @Column(name = "boo_description", length = 255, nullable = false)
    @NotNull
    @Size(max = 255)
    @Getter
    @Setter
    private String description;

    @Column(name = "boo_link", length = 255, nullable = false)
    @NotNull
    @Size(max = 255)
    @Getter
    @Setter
    private String link;

    @ManyToOne
    @JoinColumn(name = "boo_cat_id", referencedColumnName = "cat_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_boo_cat_id"))
    @NotNull
    @Getter
    @Setter
    private Category category;

    @CreationTimestamp
    @Column(name = "boo_created", nullable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Getter
    private Date created;

    @UpdateTimestamp
    @Column(name = "boo_updated", insertable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Getter
    private Date updated;

    @Version
    @Column(name = "boo_version", nullable = false)
    @Getter
    private Long version;

}
