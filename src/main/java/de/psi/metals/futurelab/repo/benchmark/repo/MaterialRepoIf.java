//******************************************************************
//                                                                 
//  MaterialRepoIf.java                                               
//  Copyright 2017 PSI AG. All rights reserved.              
//  PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//                                                                 
// ******************************************************************

package de.psi.metals.futurelab.repo.benchmark.repo;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import de.psi.metals.futurelab.repo.benchmark.Material;

@Repository
public interface MaterialRepoIf extends EntityRepository< Material, String >
{

}


