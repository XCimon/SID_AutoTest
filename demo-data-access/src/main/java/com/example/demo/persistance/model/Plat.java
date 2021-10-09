package com.example.demo.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Cirmons
 * @since 2018-05-02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plat {
    
    
    private String uuid;
    private String platName;
    private String platImage;
    private String description;
    private Integer sts;
    private String privilege;
    private String createUser;
    private Date createTs;
    private String lastModUser;
    private Date lastModTs;
}
