package com.example.demo.persistance.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author Cirmons
 * @since 2018-05-02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Poi {
    
    
    private String uuid;
    private String poiName;
    private String poiType;
    private String poiDef;
    private String referId;
    private String description;
    private Integer sts;
    private String privilege;
    private String createUser;
    private Date createTs;
    private String lastModUser;
    private Date lastModTs;
    private String platUuid;
    
    
}
