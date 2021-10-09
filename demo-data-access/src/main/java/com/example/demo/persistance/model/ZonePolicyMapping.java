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
public class ZonePolicyMapping {
    
    
    private String uuid;
    private String zoneUuid;
    private String policyUuid;
    private String policyClass;
    private String policyType;
    private Integer sts;
    private String createUser;
    private Date createTs;
    private String lastModUser;
    private Date lastModTs;
    
    
}
