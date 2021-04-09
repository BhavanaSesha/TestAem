package com.mindtree.Project_O2Store.core.models;


import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.mindtree.Project_O2Store.core.services.PdpFertilizersPageCreation;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PdpFertilizersPageCreationModel {
	@Inject
	String text;
	
	@OSGiService
	private PdpFertilizersPageCreation service;
    
	private String message;
	
	@PostConstruct
	protected void init()
	{
		if(text==null) {
			message="Enter Path in dialog to create pages";	
			}
			else
			{
			service.getPath(text);
			message="string is not empty, trying to create pages";
			}
	}

	public String getMessage() {
		return message;
	}	

}
