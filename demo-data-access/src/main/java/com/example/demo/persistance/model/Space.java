package com.example.demo.persistance.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Cirmons
 * @since 2018-07-02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Space {
    
    
    private String uuid;
    private String spaceName;
    private String spaceParent;
    private Double spaceOrder;
    private String description;
    private Integer sts;
    private String privilege;
    private String createUser;
    private Date createTs;
    private String lastModUser;
    private Date lastModTs;
    private String platUuid;
    
    
}
